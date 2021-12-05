package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.dto.GreetingMessageDto;
import com.bridgelabz.greetingapp.entity.GreetingMessageEntity;
import com.bridgelabz.greetingapp.service.GreetingAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
 * Purpose : To demonstrate different HTTP methods
 *
 * @author ASIM AHAMMED
 * @version : 0.0.1-SNAPSHOT
 * @since 2021-12-03
 */
@RestController
@RequestMapping(value = "/app")
public class GreetingAppController {

    @Autowired
    private GreetingAppService greetingAppService;

    @GetMapping(value = "/greeting")
    public String greetingMessage() {
        return "Hello world";
    }

    @GetMapping("/greeting2/{name}")
    public String greetingUsingGetMethod(
            @PathVariable String name
    ) {
        return "Welcome " + name ;
    }

    @GetMapping("/greeting3")
    public String getMessageUsingQueryParameter(
            @RequestParam String firstName,
            @RequestParam String lastName
    ) {
        return greetingAppService.getMessage() + " , " + firstName + " " + lastName;
    }

    @GetMapping(value = "/")
    public String greetingMessageFromServiceClass() {
        return greetingAppService.getMessage();
    }

    @PostMapping(value = "/add")
    public String addMessage(
            @RequestBody GreetingMessageDto greetingMessageDto
    ) {
        return greetingAppService.addGreeting(greetingMessageDto);
    }

    @GetMapping(value = "/find/{id}")
    public Optional<GreetingMessageEntity> findMessage(
            @PathVariable(value = "id") int id
    ) {
        return greetingAppService.findMessage(id);
    }

    @GetMapping(value = "get-all")
    public List<GreetingMessageDto> getAll() {
        return greetingAppService.getAll();
    }

    @PutMapping(value = "update/{id}")
    public String updateMessage(
            @PathVariable(value = "id") int id,
            @RequestBody GreetingMessageDto greetingMessageDto
    ) {
        return greetingAppService.updateGreeting(id, greetingMessageDto);
    }

    @DeleteMapping(value = "delete/{id}")
    public String deleteMessage(@PathVariable(value = "id") int id) {
        return greetingAppService.deleteMessage(id);
    }

}
