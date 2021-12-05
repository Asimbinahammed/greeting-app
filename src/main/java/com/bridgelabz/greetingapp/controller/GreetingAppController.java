package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.dto.GreetingMessageDto;
import com.bridgelabz.greetingapp.entity.GreetingMessageEntity;
import com.bridgelabz.greetingapp.service.GreetingAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping(value = "/find/{id}")
    public Optional<GreetingMessageEntity> findMessage(@PathVariable(value = "id")int id){
        return greetingAppService.findMessage(id);
    }

    @GetMapping(value = "get-all")
    public List<GreetingMessageDto> getAll(){
        return greetingAppService.getAll();
    }

    @PutMapping(value = "update/{id}")
    public String updateMessage(
            @PathVariable(value = "id") int id,
            @RequestBody GreetingMessageDto greetingMessageDto
    ){
        return greetingAppService.updateGreeting(id, greetingMessageDto);
    }

}
