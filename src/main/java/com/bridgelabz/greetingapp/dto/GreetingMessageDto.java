package com.bridgelabz.greetingapp.dto;

import lombok.Data;

@Data
public class GreetingMessageDto {
    private String firstName;
    private String lastName;
    private String greetingMessage;
}
