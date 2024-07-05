package com.example.n4_12.Controller;

import com.example.n4_12.dto.Message;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class MessageController {

    private List<Message> messageList = new ArrayList<>(Arrays.asList(
            new Message(1, "Сообщени", "Один", LocalDateTime.of(2024, 10, 25, 15,30 ,0)),
            new Message(2,"Сообщение2","Два",LocalDateTime.of(2024, 9, 21,10,20,10))
    ));

    @GetMapping("/message")
    public Iterable<Message> getMessage(){
        return messageList;
    }

    @PostMapping("/messages")
    public Message addMessage (@RequestBody Message message) {
        messageList.add(message);
        return message;
    }

    @GetMapping("/message/{id}")
    public Optional<Message> findMessageById(@PathVariable int id){
        return messageList.stream().filter(m -> m.getId() == id).findFirst();
    }

    @DeleteMapping("/message/{id}")
    public void deleteMessage(@PathVariable int id){
        messageList.removeIf(m -> m.getId() == id);
    }
    @PutMapping("/messages/{id}")
    public Message updateMessage(@PathVariable int id, @RequestBody Message message) {
        int index = - 1;
        for (Message m : messageList) {
            if (m.getId() == index) {
                index = messageList.indexOf(m);
                messageList.set(index,message);
            }

        }
        return index == -1 ? addMessage(message) : message;
    }
}
