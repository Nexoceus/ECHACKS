package com.example.demo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


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
            dataString = (deviceData.toString() + System.lineSeparator()+ new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date()));
        dataString += (deviceData.toString() + System.lineSeparator() +  new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date()));
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
