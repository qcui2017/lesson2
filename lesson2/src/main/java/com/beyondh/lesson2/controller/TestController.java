package com.beyondh.lesson2.controller;

import com.beyondh.lesson2.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value="/hello/{value}",method= RequestMethod.GET)
    public String Hello(@PathVariable String value)
    {
        return "test:"+value;
    }

    @RequestMapping(value="/gen",method= RequestMethod.GET)
    public String genData()
    {
        return testService.genData();
    }
}
