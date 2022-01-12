package com.anubratads.dsmqserver.controller;

import com.anubratads.dsmqserver.model.Message;
import com.anubratads.dsmqserver.service.Exchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private Exchange exchange;

    @GetMapping("/test")
    public String test() {
        return String.format("Server is up");
    }

    @GetMapping("/receive/{channel}")
    public Message receive(@PathVariable String channel) {
        Message result = exchange.getQueueForChannel(channel).receive();
        return result;
    }

    @PutMapping("/create/{channel}")
    public ResponseEntity create(@PathVariable String channel) {
        exchange.createChannel(channel);
        return ResponseEntity.ok(null);
    }

    @PostMapping("/send/{channel}")
    public ResponseEntity send(@PathVariable String channel, @RequestBody Message message) {
        exchange.getQueueForChannel(channel).send(message);
        return ResponseEntity.ok(null);
    }
}
