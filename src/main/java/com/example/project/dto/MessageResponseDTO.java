package com.example.project.dto;

import com.example.project.entity.Conversation;
import com.example.project.entity.Message;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MessageResponseDTO {
	private Long id;
	private String text;
	private Long conversationId;
	private Long authorId;

	public MessageResponseDTO(Message message) {
		this.id = message.getId();
		this.text = message.getText();
		this.authorId = message.getAuthor().getId();
		this.conversationId = message.getConversationId().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getConversationId() {
		return conversationId;
	}

	public void setConversationId(Long conversationId) {
		this.conversationId = conversationId;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}
}


