package com.cybersoft.restfulapi.exception;

import com.cybersoft.restfulapi.dto.response.ErrResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrResponseDTO> hdlStt(ResponseStatusException ex){
        ErrResponseDTO body = new ErrResponseDTO(ex.getReason(), ex.getStatusCode().value());
        return ResponseEntity.status(ex.getStatusCode()).body(body);
    }
}
