package com.example.jms.jms.repository;

import com.example.jms.jms.entities.EmailEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends CrudRepository<EmailEntity, Integer> {
}