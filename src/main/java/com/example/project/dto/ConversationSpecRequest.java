package com.example.project.dto;

import javax.validation.constraints.NotNull;

public class ConversationSpecRequest {

    @NotNull
    private Long myId;

    @NotNull
    private Long otherId;

    public Long getMyId() {
        return myId;
    }

    public void setMyId(Long myId) {
        this.myId = myId;
    }

    public Long getOtherId() {
        return otherId;
    }

    public void setOtherId(Long otherId) {
        this.otherId = otherId;
    }
}
