package com.bridgelabz.greetingapp.dto;

import lombok.Data;

/**
 * Purpose : To invoke the data from client
 *
 * @author ASIM AHAMMED
 * @version : 0.0.1-SNAPSHOT
 * @since 2021-12-03
 */
@Data
public class GreetingMessageDto {
    private String firstName;
    private String lastName;
    private String greetingMessage;
}
