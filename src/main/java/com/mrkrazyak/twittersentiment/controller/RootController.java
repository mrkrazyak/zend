package com.mrkrazyak.twittersentiment.controller;

import com.mrkrazyak.twittersentiment.entity.CreateConversationRequest;
import com.mrkrazyak.twittersentiment.entity.CreateUserRequest;
import com.mrkrazyak.twittersentiment.entity.Message;
import com.mrkrazyak.twittersentiment.entity.MessageRequest;
import com.mrkrazyak.twittersentiment.entity.response.MessageResponse;
import com.mrkrazyak.twittersentiment.entity.response.MessageResponseEntity;
import com.mrkrazyak.twittersentiment.service.ConversationService;
import com.mrkrazyak.twittersentiment.service.MessageService;
import com.mrkrazyak.twittersentiment.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RootController {

	@Autowired
	private MessageService messageService;
	@Autowired
	private UserService userService;
	@Autowired
	private ConversationService conversationService;
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}

	@GetMapping("/message")
	public ResponseEntity<MessageResponse> getMessages(@RequestParam String conversationId) {
		MessageResponse messageResponse = messageService.getMessages(conversationId);
		ResponseEntity<MessageResponse> responseEntity = new ResponseEntity<MessageResponse>(messageResponse, HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping("/message")
	public String message(@RequestBody MessageRequest body) {
		boolean saved = messageService.saveMessage(body);
		return String.valueOf(saved);
	}

	@PostMapping("/user")
	public String createUser(@RequestBody CreateUserRequest body) {
		String username = body.getUsername();
		boolean created = userService.createUser(username);
		return String.valueOf(created);
	}

	@PostMapping("/conversation")
	public String createConversation(@RequestBody CreateConversationRequest body) {
		boolean created = conversationService.createConversation(body.getMemberIds());
		return String.valueOf(created);
	}
}
