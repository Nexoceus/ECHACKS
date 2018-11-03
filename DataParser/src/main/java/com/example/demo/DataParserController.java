package com.example.demo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;


@RestController
public class DataParserController {

    public ArrayList arrayList = new ArrayList();

    @RequestMapping(
            value = "/process",
            method = RequestMethod.POST,
            consumes = "application/json")

    public String process(@RequestBody DeviceData deviceData) throws Exception {
        arrayList.add(deviceData.toString());
        return deviceData.toString();
    }

    @RequestMapping(
            value = "/home",
            method = RequestMethod.GET)

    public String process(String hello) {
//        return "HELLO WORLD!";
        return arrayList.toString();
    }
}
