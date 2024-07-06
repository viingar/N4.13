package com.example.n4_12.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
public class Message {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String text;
    LocalDateTime time;

    public Message() {

    }

    public Message ( String title, String text, LocalDateTime time) {

        this.title = title;
        this.text = text;
        this.time = time;
    }
    public Message (int id, String title, String text, LocalDateTime time) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.time = time;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getText () {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getTime () {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }


}