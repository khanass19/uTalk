package com.example.project.controller;

import com.example.project.dto.*;
import com.example.project.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/sms")
public class MessageController {

	@Autowired
	private MessageService messageService;

	@PostMapping
	@PreAuthorize("hasAnyAuthority('USER')")
	public MessageResponseDTO save(@Valid @RequestBody MessageRequestDTO messageRequest) {
		return messageService.save(messageRequest);
	}

	@GetMapping
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public List<MessageResponseDTO> getAll() {
		return messageService.getAll();
	}

	@PostMapping("/selectOne")
	@PreAuthorize("hasAnyAuthority('USER')")
	public List<MessageResponseDTO> getAllById(@Valid @RequestBody MessageSpecRequest messageSpecRequest){
		return messageService.findAllByConversationId(messageSpecRequest);
	}


}
