package com.example.project.service;

import com.example.project.dto.*;
import com.example.project.repository.MessageRepository;

import javax.transaction.Transactional;
import java.util.List;


public interface MessageService {
	@Transactional
	MessageResponseDTO save(MessageRequestDTO messageRequestDTO);

	List<MessageResponseDTO> getAll();

	List<MessageResponseDTO> findAllByConversationId(MessageSpecRequest messageSpecRequest);
}
