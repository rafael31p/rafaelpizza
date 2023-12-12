package com.rafael.pizzeria.exceptions;

import com.rafael.pizzeria.security.model.dto.UserDTO;
import jakarta.transaction.SystemException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.resource.transaction.backend.jta.internal.synchronization.ExceptionMapper;
import org.springframework.http.ResponseEntity;

public class ResponseExceptionHandler implements ExceptionMapper {

    public ResponseEntity<UserDTO> userDTOResponseEntity(CustomException e){
        if(e.getMessage().equals("El usuario ya existe")){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
    @Override
    public RuntimeException mapStatusCheckFailure(String message, SystemException systemException, SessionImplementor sessionImplementor) {
        return null;
    }

    @Override
    public RuntimeException mapManagedFlushFailure(String message, RuntimeException failure, SessionImplementor session) {
        return null;
    }
}
