//includes
#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>
#include <Wire.h>
#include <LiquidCrystal_I2C.h>

//var declarations
LiquidCrystal_I2C lcd(0x3F, 2, 1, 0, 4, 5, 6, 7, 3, POSITIVE);

//setup once
void setup() {
  Serial.begin(115200);
  lcd.begin(16, 2);
  lcd.print("...");
  pinMode(D8, OUTPUT);
  
  //now check if GPS has location
  bool validpayload = false;
  String payload ="";
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
     }
   }

//get wifi vars from serial, parse them, store them
  while(WiFi.status() != WL_CONNECTED){
    Serial.println();
    char* u = "echacks";
    char* p = "Fall2020";
    Serial.print("Connecting to ");
    Serial.println(u);
    Serial.println(p);
    WiFi.begin(u, p);

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
            Serial.println(payload);
            //<o2;co2;voc;temp;hum;lat;long;elev;dev_id;>
            float EofP[9]; String E; int i = 0;
            for(int x=0;x<payload.length();x++){
              if(payload[x]==';'){
                EofP[i++]=E.toFloat();
                E="";
              } else if(payload[x]!='>'&&payload[x]!='<'){
                E+=payload[x];
              }
            }
            HTTPClient http;
            payload = "{\"o2\":"+String(EofP[0])+",\"co2\":"+String(EofP[1])+",\"voc\":"+String(EofP[2])+",\"temperature\":";
            payload = payload+String(EofP[3])+",\"humidity\":"+String(EofP[4])+",\"latitude\":"+String(EofP[5]);
            payload = payload+",\"longitude\":"+String(EofP[6])+",\"elevation\":"+String(EofP[7])+",\"deviceID\":"+String(EofP[8])+"}";
            
            Serial.println(payload);
            http.begin("http://oxydb.com/server/scripts/parse.php");      
            http.header("POST / HTTP/1.1");
            http.header("Host: http://oxydb.com/server/scripts/parse.php");
            http.header("Accept: */*");
            http.header("Content-Type: application/x-www-form-urlencoded");
            http.header("Content-Length : "+payload.length());
            int httpCode = http.POST(payload);   
            String payload = http.getString();                                        
            Serial.println(httpCode);
            Serial.println(payload);    
            digitalWrite(D8, HIGH);
            delay(100);
            digitalWrite(D8, LOW);
            http.end();  
    }
}

void loop(){
 postData();
 delay(1000);
}
