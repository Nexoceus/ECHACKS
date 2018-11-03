package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;


@RestController
public class DataParserController {

	@RequestMapping(
    value = "/process", 
    method = RequestMethod.POST,
    consumes = "application/json")
public String process(@RequestBody DeviceData deviceData) throws Exception {

  return deviceData.toString();

//        return
}

}
