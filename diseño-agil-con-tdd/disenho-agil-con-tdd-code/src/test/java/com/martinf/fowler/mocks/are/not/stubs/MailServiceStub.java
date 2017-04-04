package com.martinf.fowler.mocks.are.not.stubs;

import java.util.ArrayList;
import java.util.List;

public class MailServiceStub implements MailService {

	private List<Message> messages = new ArrayList<>();

	public void send(Message msg) {
		messages.add(msg);
	}

	public int numberSent() {
		return messages.size();
	}

}
