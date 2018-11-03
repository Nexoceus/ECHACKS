package com.echacks.DataParser;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataParserController {

    @RequestMapping(value = "*", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello( String name) {
        return "Hello world";
    }

}
