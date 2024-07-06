package com.example.n4_12.dto;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToMany;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;


@Entity
public class Person {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue
    private int id;
    private String firstname;
    private String surname;

    private String lastname;

    private LocalDate birthday;
    @OneToMany(cascade = CascadeType.ALL)
    List<Message> messages;



    public Person(int id, String firstname, String surname, String lastname, LocalDate birthday, List<Message> messages) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.messages = messages;
    }

    public Person() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    public void addMessage(Message message) {
        messages.add(message);
    }
    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }



    public void removeMessage(Message message){
        messages.remove(message);
    }
    public Message findMessageById(int messageId) {
        for(Message message : this.messages) {
            if(message.getId() == messageId) {
                return message;
            }
        }
        return null;
    }


}