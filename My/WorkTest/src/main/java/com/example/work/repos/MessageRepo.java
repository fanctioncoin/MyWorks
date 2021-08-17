package com.example.work.repos;

import com.example.work.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Integer>  {

   List<Message> findByTag(String tag); // указали что ищем в поле vin
}
