package com.mrkrazyak.zend.controller;

import com.mrkrazyak.zend.entity.CreateConversationRequest;
import com.mrkrazyak.zend.entity.CreateUserRequest;
import com.mrkrazyak.zend.entity.MessageRequest;
import com.mrkrazyak.zend.entity.request.CreateFriendRequest;
import com.mrkrazyak.zend.entity.response.MessageResponse;
import com.mrkrazyak.zend.service.ConversationService;
import com.mrkrazyak.zend.service.FriendRequestService;
import com.mrkrazyak.zend.service.MessageService;
import com.mrkrazyak.zend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RootController {

	@Autowired
	private MessageService messageService;
	@Autowired
	private UserService userService;
	@Autowired
	private ConversationService conversationService;
	@Autowired
	private FriendRequestService friendRequestService;

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

	@PostMapping("/friendrequest")
	public String createFriendRequest(@RequestBody CreateFriendRequest body) {
		boolean created = friendRequestService.createFriendRequest(body);
		return String.valueOf(created);
	}
}
