package com.bridgelabz.greetingapp.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

/**
 * Purpose : To contains the entities in the database
 *
 * @author ASIM AHAMMED
 * @version : 0.0.1-SNAPSHOT
 * @since 2021-12-03
 */
@Getter
@Setter
@Table(name = "greeting")
@Entity
public class GreetingMessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private String greetingMessage;
}
