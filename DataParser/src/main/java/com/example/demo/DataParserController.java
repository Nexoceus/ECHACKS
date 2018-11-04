package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


@RestController
public class DataParserController {

    public boolean once = false;

    public String dataString;


    @RequestMapping(
            value = "/process",
            method = RequestMethod.POST,
            consumes = "application/json")

    public String process(@RequestBody DeviceData deviceData) throws Exception {

//        if (!once) {

         //   Class.forName("com.mysql.jdbc.Driver");

        //    String jdbcUrl = String.format(
                   // "jdbc:mysql://google/%s?cloudSqlInstance=%s&"
                      //      + "socketFactory=com.google.cloud.sql.mysql.SocketFactory",
                 //   "petclinic",
                 //   "optimum-parity-221406:us-central1:instance-1");

//        //    Connection connection =


         //   try (Connection conn = DriverManager.getConnection(jdbcUrl, "root", "password")) {
         //       
          //  }
//            "jdbc:mysql://google/petclinic?cloudSqlInstance=instance-1&socketFactory=com.google.cloud.sql.mysql.SocketFactory&user=root&password=password&useSSL=false\n"
          //  once = true;
     //   }

        if (dataString == null)
            dataString = (deviceData.toString() + System.lineSeparator()+ new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date()));
        else {
            dataString += (deviceData.toString() + System.lineSeparator() +  new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date()));
        }

        return "success!";
    }

    @RequestMapping(
            value = "/home",
            method = RequestMethod.GET)

    public String process(String hello) {
        return dataString;
    }
}
