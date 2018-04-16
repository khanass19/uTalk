package com.example.project.dto;

import javax.validation.constraints.NotNull;

public class MessageRequestDTO {

	@NotNull
	private String text;

	@NotNull
	private Long conversationId;

	@NotNull
	private Long authorId;

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public Long getConversationId() {
		return conversationId;
	}

	public void setConversationId(Long conversationId) {
		this.conversationId = conversationId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


	public String getMessage() {
		return text;
	}

	public void setMessage(String message) {
		this.text = message;
	}

}

