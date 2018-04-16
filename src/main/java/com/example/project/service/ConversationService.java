package com.example.project.service;

import java.util.List;

import com.example.project.dto.*;

import javax.transaction.Transactional;

public interface ConversationService {
	@Transactional
	ConversationResponseDTO save(ConversationRequestDTO conversationRequestDTO);
	@Transactional
	List<ConversationResponseDTO> findAll();
	ConversationResponseDTO findOne(Long id);

	List<ConversationResponseDTO> findAllByIds(ConversationSpecRequest conversationSpecRequest);
	void deleteBesida(BesidaDeleteRequest besidaDeleteRequest);

}


