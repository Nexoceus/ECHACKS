//include libraries
#include <SoftwareSerial.h>
#include <TinyGPS++.h>
#include "SparkFunCCS811.h"
#include <SPI.h>
#include <SD.h>

//define vars
#define CCS811_ADDR 0x5B
static const uint32_t GPSBaud = 9600;
int chipSelect = 10;
TinyGPSPlus gps;
SoftwareSerial ss(5, 6);
CCS811 mySensor(CCS811_ADDR);
float sensorValue, sensorVoltage;
float Value_O2 = 0;
int parameterNum;
bool hasgpsdata = false;
bool hasGivenConfigs = false;

void setup() {
  //sd setup
  Serial.begin(115200);

  if (!SD.begin(10)) {
    return;
  }
  delay(1000);
  startSensors();
//end setup  
}

void startSensors(){
    pinMode(3, OUTPUT);
    CCS811Core::status returnCode = mySensor.begin();
    ss.begin(GPSBaud);  
}

void loop() {
  if(hasgpsdata==false){
  Serial.println("loadingGPS");
  }
  while(hasgpsdata==false){
      if (ss.available() > 0){
        if (gps.encode(ss.read())){
          if (gps.location.isValid()&&gps.date.isValid()){
            Serial.println("gotGPS");
            hasgpsdata = true;
          }
        } else {
          delay(10);
        }
      }
    }
  while (gps.location.isValid()&&gps.date.isValid()&&hasGivenConfigs==false){
    printConfigs();
    delay(2000);
  }

  sensorValue = analogRead(A0); 
      sensorVoltage =(sensorValue/1024)*5; 
      sensorVoltage = sensorVoltage/201*10000; 
      Value_O2 = sensorVoltage/7.43;
      
   
 if (gps.location.isValid()&&gps.date.isValid()){

   //voc and co2 validity check
    if(mySensor.dataAvailable()){
      mySensor.readAlgorithmResults();
    } else {
     Serial.println("error calibrating tvoc");
    }

    Serial.println("<"+String(Value_O2)+";"+String(mySensor.getTVOC())+";"+String(mySensor.getCO2())+";"+String(gps.location.lat(),6)+";"+String(gps.location.lng(),6)+";>");

     File dataFile = SD.open("log.txt", FILE_WRITE);
      if (dataFile) {
        digitalWrite(3, HIGH);
        delay(100);
        digitalWrite(3, LOW);
        dataFile.println("<"+String(Value_O2)+";"+String(mySensor.getTVOC())+";"+String(mySensor.getCO2())+";"+String(gps.time.hour())+":"+String(gps.time.minute())+";>");   
        dataFile.close();
      } else { 
        Serial.println("error");
      }
      
} else{
      Serial.print("loadingGPS");
}

  delay(1000);
}
