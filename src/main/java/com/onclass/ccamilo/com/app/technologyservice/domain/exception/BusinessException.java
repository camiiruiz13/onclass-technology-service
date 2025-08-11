package com.onclass.ccamilo.com.app.technologyservice.domain.exception;

import com.onclass.ccamilo.com.app.technologyservice.domain.enums.ErrorMessage;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final ErrorMessage errorMessage;

    public BusinessException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }

    public BusinessException(ErrorMessage errorMessage, Throwable cause) {
        super(errorMessage.getMessage(), cause);
        this.errorMessage = errorMessage;
    }

}
