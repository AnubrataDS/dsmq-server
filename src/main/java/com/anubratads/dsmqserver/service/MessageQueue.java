package com.anubratads.dsmqserver.service;

import java.util.ArrayDeque;
import java.util.Queue;

import com.anubratads.dsmqserver.model.Message;

public class MessageQueue {
	private final String name;
	private Queue<Message> queue;
	public static Message EMPTY_MESSAGE = new Message("");

	public synchronized void send(Message message) {
		queue.add(message);
	}

	public synchronized Message receive() {
		if (queue.isEmpty())
			return EMPTY_MESSAGE;
		else {
			return queue.remove();
		}
	}

	public String getName() {
		return name;
	}

	public MessageQueue(String name) {
		super();
		this.name = name;
		this.queue = new ArrayDeque<Message>();
	}

	public MessageQueue() {
		super();
		this.name = "";
		this.queue = null;
	}

}
