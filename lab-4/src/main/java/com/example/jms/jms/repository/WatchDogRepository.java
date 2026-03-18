package com.example.jms.jms.repository;

import com.example.jms.jms.entities.WatchDogEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchDogRepository extends CrudRepository<WatchDogEntity, Integer> {
}