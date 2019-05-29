package com.example.urlshorter.repository;

import com.example.urlshorter.model.ShortingEntity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends MongoRepository<ShortingEntity, String> {

}
