package com.mrkrazyak.twittersentiment.controller;

import com.mrkrazyak.twittersentiment.entity.Message;
import com.mrkrazyak.twittersentiment.entity.MessageRequest;
import com.mrkrazyak.twittersentiment.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RootController {

	@Autowired
	private MessageService messageService;
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}

	@GetMapping("/message")
	public List<Message> getMessages(@RequestParam String chatRoom) {
		List<Message> messages = messageService.getMessages(chatRoom);
		return messages;
	}

	@PostMapping("/message")
	public String message(@RequestBody MessageRequest body) {
		boolean saved = messageService.saveMessage(body);
		return String.valueOf(saved);
	}
}
