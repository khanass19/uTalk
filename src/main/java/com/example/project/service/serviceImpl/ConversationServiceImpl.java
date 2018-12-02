package com.example.project.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;


import com.example.project.dto.*;

import com.example.project.entity.Conversation;
import com.example.project.entity.Message;
import com.example.project.repository.ConversationRepository;
import com.example.project.repository.MessageRepository;
import com.example.project.repository.UserRepository;
import com.example.project.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class ConversationServiceImpl implements ConversationService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ConversationRepository conversationRepository;

	@Autowired
	MessageRepository messageRepository;

	@Override
	public ConversationResponseDTO save(ConversationRequestDTO conversationRequestDTO) {
		Conversation conversation=new Conversation();
		conversation.setAuthor(userRepository.getOne(conversationRequestDTO.getAuthorId()));
		conversation.setReceiver(userRepository.getOne(conversationRequestDTO.getReceiverId()));
		conversation.setMessage(messageRepository.findAll());
		return new ConversationResponseDTO(conversationRepository.save(conversation));
	}

	@Override
	@Transactional
    public List<ConversationResponseDTO> findAll(){
        List<Conversation> conversations = conversationRepository.findAll();
        List<ConversationResponseDTO> conversationResponses = new ArrayList<ConversationResponseDTO>();
        for (Conversation conversation:conversations){
        	conversationResponses.add(new ConversationResponseDTO(conversation));
        }
        return conversationResponses;
    }

	@Override
	public ConversationResponseDTO getOne(Long id){
		return new ConversationResponseDTO(conversationRepository.getOne(id));
	}

	@Override
	public List<ConversationResponseDTO> findAllByIds(ConversationSpecRequest conversationSpecRequest) {
			List<Conversation> conversations = conversationRepository.findCv(conversationSpecRequest.getMyId(),
					conversationSpecRequest.getOtherId());
			List<ConversationResponseDTO> conversationResponseDTOS = new ArrayList<ConversationResponseDTO>();
			for (Conversation conversation:conversations){
				conversationResponseDTOS.add(new ConversationResponseDTO(conversation));
			}
			return conversationResponseDTOS;
	}

	@Override
	public void deleteBesida(BesidaDeleteRequest besidaDeleteRequest) {
		Conversation conversation = conversationRepository.findCvForDelete(besidaDeleteRequest.getIdUser(),
				besidaDeleteRequest.getIdOther());
		List<Message> messages = messageRepository.findMsg(conversation.getId());
		messageRepository.deleteAll(messages);
		conversationRepository.delete(conversation);
	}
}
