package com.anubratads.dsmqserver.service;

import java.text.MessageFormat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

@Service
public class Exchange {
	private Map<String, MessageQueue> channelNameToQueue;
	private static volatile Exchange instance;

	private Exchange() {
		this.channelNameToQueue = new ConcurrentHashMap<String, MessageQueue>();
	}

	public static Exchange getInstance() {
		Exchange result = instance;
		if (result != null) {
			return result;
		}
		synchronized (Exchange.class) {
			if (instance == null) {
				instance = new Exchange();
			}
			return instance;
		}
	}

	public void createChannel(String name) {
		if (channelNameToQueue.containsKey(name))
			return;
		MessageQueue newQueue = new MessageQueue(name);
		this.channelNameToQueue.put(name, newQueue);
	}

	public MessageQueue getQueueForChannel(String name) {
		if (!channelNameToQueue.containsKey(name)) {
			String message = MessageFormat.format("Channel {0} does not exist", name);
			throw new Error(message);
		} else {
			return channelNameToQueue.get(name);
		}
	}
}
