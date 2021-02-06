package com.mrkrazyak.zend.controller;

import com.mrkrazyak.zend.entity.request.*;
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

	@GetMapping("/message")
	public ResponseEntity<MessageResponse> getMessages(@RequestParam String conversationId) {
		MessageResponse messageResponse = messageService.getMessages(conversationId);
		ResponseEntity<MessageResponse> responseEntity = new ResponseEntity<MessageResponse>(messageResponse, HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping("/message")
	public String createMessage(@RequestBody MessageRequest requestBody) {
		boolean saved = messageService.saveMessage(requestBody);
		return String.valueOf(saved);
	}

	@PatchMapping("/message/{messageId}")
	public String updateMessage(@RequestBody MessagePatchRequest requestBody,
								@PathVariable("messageId") String messageId) {
		boolean saved = messageService.updateMessage(messageId, requestBody);
		return String.valueOf(saved);
	}

	@PostMapping("/user")
	public String createUser(@RequestBody CreateUserRequest requestBody) {
		String username = requestBody.getUsername();
		boolean created = userService.createUser(username);
		return String.valueOf(created);
	}

	@PostMapping("/conversation")
	public String createConversation(@RequestBody CreateConversationRequest requestBody) {
		boolean created = conversationService.createConversation(requestBody);
		return String.valueOf(created);
	}

	@PostMapping("/friendrequest")
	public String createFriendRequest(@RequestBody CreateFriendRequest requestBody) {
		boolean created = friendRequestService.createFriendRequest(requestBody);
		return String.valueOf(created);
	}
}
