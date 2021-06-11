package com.test;

import java.util.UUID;

public class Message {
	private UUID messageId;
	private String message;
	
	public Message(String message) {
		this.message = message;
		this.messageId = UUID.randomUUID();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId.toString() + ", message=" + message + "]";
	}	
	
	
}
