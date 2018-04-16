package com.example.project.dto;

import com.example.project.entity.Ban;

public class BanResponse {

    private Long id;

    private Long idUser;

    public BanResponse(Ban ban) {
        this.id = ban.getId();
        this.idUser = ban.getUser().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
