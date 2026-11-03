package com.cybersoft.restfulapi.dto.response;

public class ErrResponseDTO {
    private String error;
    private int status;

    public ErrResponseDTO(String error, int status) {
        this.error = error;
        this.status = status;

    }

    public String getError() {
        return error;
    }

    public int getStatus() {
        return status;
    }
}
