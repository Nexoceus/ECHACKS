package com.example.demo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Timestamp;


@RestController
public class DataParserController {

//    public ArrayList arrayList = new ArrayList<>();
    public String dataString;

    @RequestMapping(
            value = "/process",
            method = RequestMethod.POST,
            consumes = "application/json")

    public void process(@RequestBody DeviceData deviceData) throws Exception {

        if (dataString == null)
            dataString = (deviceData.toString() + System.lineSeparator()+ (System.currentTimeMillis()));
        dataString += (deviceData.toString() + System.lineSeparator() + (System.currentTimeMillis()));
//        arrayList.add(deviceData.toString());
//        return deviceData.toString();
    }

    @RequestMapping(
            value = "/home",
            method = RequestMethod.GET)

    public String process(String hello) {
        return dataString;
    }
}
