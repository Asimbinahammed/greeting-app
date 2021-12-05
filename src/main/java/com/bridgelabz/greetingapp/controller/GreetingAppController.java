package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.dto.GreetingMessageDto;
import com.bridgelabz.greetingapp.service.GreetingAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/app")
public class GreetingAppController {

    @Autowired
    private GreetingAppService greetingAppService;

    @GetMapping(value = "/greeting")
    public String greetingMessage(){
        return "Hello world";
    }


    @GetMapping(value = "/")
    public String greetingMessageFromServiceClass(){
        return greetingAppService.getMessage();
    }

    @PostMapping(value = "/add")
    public String addMessage(@RequestBody GreetingMessageDto greetingMessageDto) {
        return greetingAppService.addGreeting(greetingMessageDto);
    }

}
