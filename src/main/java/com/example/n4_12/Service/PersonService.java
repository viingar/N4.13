package com.example.n4_12.Service;

import com.example.n4_12.Repository.PersonRepository;
import com.example.n4_12.dto.Message;
import com.example.n4_12.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Service
public class PersonService {
    @Autowired
    PersonRepository repository;

    public Person addMeesageToPerson(int personId, Message message) {
        if (!repository.existsById(personId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Person person = repository.findById(personId).get();
        message.setPerson(person);
        message.setTime(LocalDateTime.now());
        person.addMessage(message);
        return repository.save(person);
    }



}