package com.example.project.dto;

import com.example.project.entity.Conversation;
import com.example.project.entity.Message;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ConversationResponseDTO {
	
	private Long Id;
	private Long authorId;
	private Long receiverId;
	private List<MessageResponseDTO> messages = new ArrayList<MessageResponseDTO>();


	public ConversationResponseDTO(Conversation conversation) {
		this.Id=conversation.getId();
		this.authorId=conversation.getAuthor().getId();
		this.receiverId=conversation.getReceiver().getId();
		for(Message message : conversation.getMessage()){
			MessageResponseDTO messageResponseDTO = new MessageResponseDTO(message);
			messages.add(messageResponseDTO);
		}
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public Long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}

	public List<MessageResponseDTO> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageResponseDTO> messages) {
		this.messages = messages;
	}
}
