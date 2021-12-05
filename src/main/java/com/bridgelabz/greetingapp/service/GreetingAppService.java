package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.GreetingMessageDto;
import com.bridgelabz.greetingapp.entity.GreetingMessageEntity;
import com.bridgelabz.greetingapp.repository.GreetingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GreetingAppService {
    private String MESSAGE_SAVED_SUCCESSFULLY = "Message saved successfully";
    @Autowired
    GreetingRepo greetingRepo;

    public String addGreeting(GreetingMessageDto greetingMessageDto) {
        GreetingMessageEntity greetingMessageEntity = new GreetingMessageEntity();
        greetingMessageEntity.setFirstName(greetingMessageDto.getFirstName());
        greetingMessageEntity.setLastName(greetingMessageDto.getLastName());
        greetingMessageEntity.setGreetingMessage(greetingMessageDto.getGreetingMessage());
        greetingRepo.save(greetingMessageEntity);
        return MESSAGE_SAVED_SUCCESSFULLY;
    }

    public String getMessage() {
        return "hello wold!";
    }

    public Optional<GreetingMessageEntity> findMessage(int id) {
        return greetingRepo.findById(id);
    }
}
