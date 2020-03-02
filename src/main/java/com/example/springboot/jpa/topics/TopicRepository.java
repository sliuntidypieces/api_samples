package com.example.springboot.jpa.topics;

import org.springframework.data.repository.CrudRepository;

// id type
public interface TopicRepository extends CrudRepository<Topic, String>{
       // create specific SQL
}
