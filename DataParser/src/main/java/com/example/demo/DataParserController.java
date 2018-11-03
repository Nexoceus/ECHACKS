package com.example.demo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DataParserController {

    @RequestMapping(
            value = "/process",
            method = RequestMethod.POST,
            consumes = "application/json")

    public String process(@RequestBody DeviceData deviceData) throws Exception {
        return deviceData.toString();
    }

    @RequestMapping(
            value = "/process",
            method = RequestMethod.GET)

    public String process(String hello) {
        return "HELLO WORLD!";
    }
}
