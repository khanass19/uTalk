package com.example.project.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.project.entity.Message;

import javax.validation.constraints.NotNull;

public class ConversationRequestDTO {

	@NotNull
	private Long authorId;

	@NotNull
	private Long receiverId;

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


}
