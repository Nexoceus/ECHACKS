package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


@RestController
public class DataParserController {
//
//
    @Autowired
    public JdbcTemplate jdbcTemplate;
//


    public String dataString;


    @RequestMapping(
            value = "/process",
            method = RequestMethod.POST,
            consumes = "application/json")

    public String process(@RequestBody DeviceData deviceData) throws Exception {



        if (dataString == null)
            dataString = (deviceData.toString() + System.lineSeparator()+ new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date()));
        else {
            dataString += (deviceData.toString() + System.lineSeparator() +  new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date()));
        }

        jdbcTemplate.execute("show tables;");
        return "success!";
    }

    @RequestMapping(
            value = "/home",
            method = RequestMethod.GET)

    public String process(String hello) {
        return dataString;
    }
}
