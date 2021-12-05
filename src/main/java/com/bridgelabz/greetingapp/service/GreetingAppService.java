package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.GreetingMessageDto;
import com.bridgelabz.greetingapp.entity.GreetingMessageEntity;
import com.bridgelabz.greetingapp.repository.GreetingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GreetingAppService {
    private String MESSAGE_SAVED_SUCCESSFULLY = "Message saved successfully";
    private String MESSAGE_UPDATED_SUCCESSFULLY = "Message updated successfully";

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

    public List<GreetingMessageDto> getAll() {
        return greetingRepo
                .findAll()
                .stream()
                .map(greetingMessageEntity->{
                    GreetingMessageDto greetingMessageDto = new GreetingMessageDto();
                    greetingMessageDto.setGreetingMessage(greetingMessageEntity.getGreetingMessage());
                    greetingMessageDto.setFirstName(greetingMessageEntity.getFirstName());
                    greetingMessageDto.setLastName(greetingMessageEntity.getLastName());
                    return greetingMessageDto;
                }).collect(Collectors.toList());
    }

    public String updateGreeting(int id, GreetingMessageDto greetingMessageDto) {
        GreetingMessageEntity greetingMessageEntity = greetingRepo.getById(id);
        greetingMessageEntity.setGreetingMessage(greetingMessageDto.getGreetingMessage());
        greetingMessageEntity.setFirstName(greetingMessageDto.getFirstName());
        greetingMessageEntity.setLastName(greetingMessageDto.getLastName());
        greetingRepo.save(greetingMessageEntity);
        return MESSAGE_UPDATED_SUCCESSFULLY;
    }
}
