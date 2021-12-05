package com.bridgelabz.greetingapp.repository;

import com.bridgelabz.greetingapp.entity.GreetingMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Purpose : To implement an interface for database operations
 *
 * @author ASIM AHAMMED
 * @version : 0.0.1-SNAPSHOT
 * @since 2021-12-03
 */
public interface GreetingRepo extends JpaRepository<GreetingMessageEntity, Integer> {
}