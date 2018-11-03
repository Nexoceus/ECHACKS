//includes
#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>
#include "SparkFunCCS811.h"
#include <Wire.h>
#include <LiquidCrystal_I2C.h>

//var declarations
LiquidCrystal_I2C lcd(0x3F, 2, 1, 0, 4, 5, 6, 7, 3, POSITIVE);
String effectCompoundString = "unavailable";
String valuesString = "null";
bool hasType = false;
bool hasUsername = false;
bool hasPassword = false;
bool wifiHasStarted = false;
String wifiPassword, wifiType, wifiUsername, payload;

//setup once
void setup() {
  //quick and easy bootups
  Serial.begin(115200);
  lcd.begin(16, 2);
  lcd.print("bootup");
  pinMode(D8, OUTPUT);


          //now check if GPS has location
          bool validpayload = false;
          Serial.println("\n\nbooted");
          payload = "booted";
          while(validpayload==false){
            delay(1000);
                  payload = Serial.readString();
                  payload.trim();
                Serial.println(payload);
                if(payload=="loadingGPS"){
                      lcd.clear();
                      lcd.print("Grabbing");
                      lcd.setCursor(0, 2);
                      lcd.print("GPS data ...");
                } else if(payload=="gotGPS"){
                        lcd.clear();
                        lcd.print("Found you!");
                        validpayload = true;
                        lcd.clear();
               } else {
                    
               }
          }


//get wifi vars from serial, parse them, store them
  while(WiFi.status() != WL_CONNECTED){
    lcd.clear();
          lcd.print("wifi...");
            //getting and conditional parsing of data
            while(hasType!=true||hasPassword!=true||hasUsername!=true){
              String message = Serial.readString();
              message.trim();
              char messageType = message.charAt(0);
            switch(messageType){
            case '#':
            if(hasType==false){
               Serial.println("\nwifitype : "+message.substring(1));
               wifiType = message.substring(1);
               hasType = true;
                  digitalWrite(D8, HIGH);
                  delay(300);
                  digitalWrite(D8, LOW);
                  delay(300);
              }
              break;
            case '@':
            if(hasUsername==false){
               Serial.println("\nwifiusername : "+message.substring(1));
               wifiUsername = message.substring(1);
               hasUsername = true;
                  digitalWrite(D8, HIGH);
                  delay(300);
                  digitalWrite(D8, LOW);
                  delay(300);
              }
              break;
            case '$':
            if(hasPassword==false){
              Serial.println("\nwifipassword : "+message.substring(1));
              wifiPassword = message.substring(1);
              hasPassword = true;
                  digitalWrite(D8, HIGH);
                  delay(300);
                  digitalWrite(D8, LOW);
                  delay(300);
              }
              break;
            default:
              break;
            }
            }

      //stored vars are converted from strings to char arrays
      char CAwifiUsername[wifiUsername.length()];
      wifiUsername.toCharArray(CAwifiUsername, wifiUsername.length()+1);
      char CAwifiPassword[wifiPassword.length()];
      wifiPassword.toCharArray(CAwifiPassword, wifiPassword.length()+1);

      
      //feedback while connecting
        Serial.println();
        Serial.print("Connecting to ");
        Serial.println(CAwifiUsername);
        Serial.println(CAwifiPassword);
        WiFi.begin(CAwifiUsername, CAwifiPassword);

            //print dots while connection pending
            while (WiFi.status() != WL_CONNECTED) {
              delay(2000);
              Serial.print(".");
              lcd.clear();
              lcd.print("connect...");
            }

            
}
          //Connection to WiFi has been established
          Serial.println("");
          Serial.println("WiFi connected");
          Serial.println(WiFi.localIP());
          digitalWrite(D8, HIGH);
          lcd.clear();
          lcd.print("wifi [OK]");

}

void postData(){
    String payload = Serial.readString();
    payload.trim();
        if(payload!=""){
            HTTPClient http;
            String host = "http://158.69.210.95:80/server/scripts/parse.php";
              http.begin(host);      
              
                http.header("POST / HTTP/1.1");
                http.header("Host: http://158.69.210.95:80/server/scripts/parse.php");
                http.header("Accept: */*");
                http.header("Content-Type: application/x-www-form-urlencoded");
                http.header("Content-Length : "+payload.length());
                
                int httpCode = http.POST(payload);   
                String payload = http.getString();                                        
              
                  Serial.println(httpCode);
                  Serial.println(payload);   
                  
                  lcd.clear();
                  lcd.print("posting [OK]");
              
             http.end();  
    }
}

void loop(){
postData();
delay(10000);
}
