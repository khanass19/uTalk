package com.example.project.service.serviceImpl;



import com.example.project.dto.MessageRequestDTO;
import com.example.project.dto.MessageResponseDTO;
import com.example.project.dto.MessageSpecRequest;
import com.example.project.dto.PlanResponse;
import com.example.project.entity.Message;
import com.example.project.entity.Plan;
import com.example.project.repository.ConversationRepository;
import com.example.project.repository.MessageRepository;
import com.example.project.repository.UserRepository;
import com.example.project.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
	public class MessageServiceImpl implements MessageService {

		@Autowired
		private MessageRepository messageRepository;

		@Autowired
		private UserRepository userRepository;

		@Autowired
		private ConversationRepository conversationRepository;

		
		@Override
	    public List<MessageResponseDTO> getAll(){
	        List<Message> messages = messageRepository.findAll();
	        List<MessageResponseDTO> messageResponses = new ArrayList<MessageResponseDTO>();
	        for (Message message:messages){
	        	messageResponses.add(new MessageResponseDTO(message));
	        }
	        return messageResponses;
	    }

	@Override
	public List<MessageResponseDTO> findAllByConversationId(MessageSpecRequest messageSpecRequest) {
		List< Message> messages = messageRepository.findMsg(messageSpecRequest.getIdConversation());
		List<MessageResponseDTO> messageResponseDTOS = new ArrayList<MessageResponseDTO>();
		for (Message message:messages){
			messageResponseDTOS.add(new MessageResponseDTO(message));
		}
		return messageResponseDTOS;
	}

	@Override
		public MessageResponseDTO save(MessageRequestDTO messageRequestDTO) {
			Message message = new Message();
			message.setText(messageRequestDTO.getMessage());
			message.setConversationId(conversationRepository.getOne(messageRequestDTO.getConversationId()));
			message.setAuthor(userRepository.getOne(messageRequestDTO.getAuthorId()));
			return  new MessageResponseDTO(messageRepository.save(message));
		}


	}


