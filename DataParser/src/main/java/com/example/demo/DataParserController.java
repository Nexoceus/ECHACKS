package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataParserController {

//    @RequestMapping(value = "/submitdata", method = RequestMethod.POST)
//    public String dataReceptionResponse() {
////        return "hello world!";
//        Req
//    }

    @PostMapping("/request")
    public String postController(@RequestBody DeviceData deviceData) {
        return deviceData.toString();
    }
}
