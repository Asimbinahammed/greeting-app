package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.services.GreetingAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingAppController {

    @Autowired
    private GreetingAppService greetingAppService;

    @GetMapping(value = "/greeting")
    public String greetingMessage(){
        return "Welcome";
    }

    @GetMapping(value = "/greeting1/{name}")
    public String greetingMessageWithPathVariable(@PathVariable String name){
        return "Welcome " + name;
    }

    @GetMapping(value = "/greeting2")
    public String greetingMessageWithPassingParameters(@RequestParam(value = "name") String name){
        return "Welcome " + name;
    }

    @GetMapping(value = "/greeting3")
    public String greetingMessageFromServiceClass(){
        return greetingAppService.getMessage();
    }
}
