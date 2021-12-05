package com.bridgelabz.greetingapp.repository;

import com.bridgelabz.greetingapp.entity.GreetingMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepo extends JpaRepository<GreetingMessageEntity, Integer> {
}