package com.example.n4_12.Controller;

import com.example.n4_12.Repository.MessageRepository;
import com.example.n4_12.dto.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
public class MessageController {

    @Autowired
    private MessageRepository repository;
    @GetMapping("/message")
    public Iterable<Message> getMessage() {
        return repository.findAll();
    }

    @GetMapping("/message/{id}")
    public Optional<Message> findMessageById(@PathVariable int id) {
        return repository.findById(id);
    }
    @PostMapping("/message")
    public Message addMessage(@RequestBody Message message) {
        repository.save(message);
        return message;
    }
    @PutMapping("/message/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable int id, @RequestBody Message message) {
        HttpStatus status = repository.existsById(id) ? HttpStatus.OK : HttpStatus.CREATED;
        if (status == HttpStatus.OK){
            message.setId(id);
            return new ResponseEntity(repository.save(message), status);
        }
        else
            return new ResponseEntity(repository.save(message), status);
    }
    @DeleteMapping("/message/{id}")
    public void deleteMessage(@PathVariable int id) {
        repository.deleteById(id);
    }
}