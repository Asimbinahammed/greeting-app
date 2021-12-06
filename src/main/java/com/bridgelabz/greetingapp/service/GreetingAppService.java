package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.GreetingMessageDto;
import com.bridgelabz.greetingapp.entity.GreetingMessageEntity;
import com.bridgelabz.greetingapp.exception.ResourceNotFoundException;
import com.bridgelabz.greetingapp.repository.GreetingRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Purpose : To demonstrate business logic which implements all the methods in controller layer
 *
 * @author ASIM AHAMMED
 * @version : 0.0.1-SNAPSHOT
 * @since 2021-12-03
 */
@Service
public class GreetingAppService {
    @Autowired
    GreetingRepo greetingRepo;
    @Autowired
    ModelMapper modelMapper;

    private final String MESSAGE_SAVED_SUCCESSFULLY = "Message saved successfully";
    private final String MESSAGE_UPDATED_SUCCESSFULLY = "Message updated successfully";
    private final String MESSAGE_DELETED_SUCCESSFULLY = "Message deleted successfully";

    /**
     * Purpose : To return string greeting message whenever this method is called
     * @return String : Greeting message
     */
    public String getMessage() {
        return "hello wold!";
    }

    /**
     * Purpose : To add messages ino database.
     * @param greetingMessageDto : Input json message to add into database
     * @return String : Message for success.
     */
    public String addGreeting(GreetingMessageDto greetingMessageDto) {
        GreetingMessageEntity greetingMessageEntity = modelMapper.map(greetingMessageDto, GreetingMessageEntity.class);
        greetingRepo.save(greetingMessageEntity);
        return MESSAGE_SAVED_SUCCESSFULLY;
    }

    /**
     * Purpose : To find message from repo using id
     * @param id : Database id of a message
     * @return greeting message : Consists of first name, last name & message
     */
    public Optional<GreetingMessageEntity> findMessage(int id) {
        return greetingRepo.findById(id);
    }

    /**
     * purpose :  To list all messages in database
     * @return list : Greeting messages with first name, last name & message for each entry.
     */
    public List<GreetingMessageDto> getAll() {
        return greetingRepo
                .findAll()
                .stream()
                .map(greetingMessageEntity -> {
                    GreetingMessageDto greetingMessageDto =
                            modelMapper.map(greetingMessageEntity, GreetingMessageDto.class);
                    return greetingMessageDto;
                }).collect(Collectors.toList());
    }

    /**
     * Purpose : To update an old greeting message with new one using id
     * @param id : Database id
     * @param greetingMessageDto : New greeting message with first name, last name & message
     * @return String : Success message if updated the entry
     */
    public String updateGreeting(int id, GreetingMessageDto greetingMessageDto) {
        Optional<GreetingMessageEntity> greetingMessageById = greetingRepo.findById(id);
        if (greetingMessageById.isPresent()) {
            GreetingMessageEntity greetingMessageEntity = greetingMessageById.get();
            modelMapper.map(greetingMessageDto, greetingMessageEntity);
            greetingRepo.save(greetingMessageEntity);
            return MESSAGE_UPDATED_SUCCESSFULLY;
        }
        throw new ResourceNotFoundException("User not found");
    }

    /**
     * Purpose : To delete greeting message from database.
     * @param id : Database id
     * @return String : Success message if deleted the entry
     */
    public String deleteMessage(int id) {
        Optional<GreetingMessageEntity> greetingMessage = greetingRepo.findById(id);
        if (greetingMessage.isPresent()) {
            greetingRepo.delete(greetingMessage.get());
            return MESSAGE_DELETED_SUCCESSFULLY;
        }
        throw new ResourceNotFoundException("User not found");
    }
}
