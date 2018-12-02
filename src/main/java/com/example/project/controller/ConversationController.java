package com.example.project.controller;

import java.util.List;

import com.example.project.dto.*;
import com.example.project.entity.Conversation;
import com.example.project.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@CrossOrigin
@RequestMapping("/besida")
public class ConversationController {

	@Autowired
	private ConversationService conversationService;

	@PostMapping
	@PreAuthorize("hasAnyAuthority('USER')")
	public ConversationResponseDTO save(@Valid @RequestBody ConversationRequestDTO conversationRequestDTO) {
		return conversationService.save(conversationRequestDTO);
	}

	@PostMapping("/selectOne")
	@PreAuthorize("hasAnyAuthority('USER')")
	public List<ConversationResponseDTO> getOneByIds(@Valid @RequestBody ConversationSpecRequest conversationSpecRequest){
		return conversationService.findAllByIds(conversationSpecRequest);
	}

	@GetMapping
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public List<ConversationResponseDTO> findAll() {
		return conversationService.findAll();
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAnyAuthority('ADMIN')")
	public ConversationResponseDTO getOne(@Valid @PathVariable Long id) {
		return conversationService.getOne(id);
	}

	@DeleteMapping("/delete")
	@PreAuthorize("hasAnyAuthority('USER')")
	public void deleteBesida(@RequestBody BesidaDeleteRequest besidaDeleteRequest){
		conversationService.deleteBesida(besidaDeleteRequest);
	}

}