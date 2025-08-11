package com.onclass.ccamilo.com.app.technologyservice.domain.exception;

import com.onclass.ccamilo.com.app.technologyservice.domain.enums.ErrorMessage;

public class TechnologyAlreadyExistsException  extends BusinessException {
    public TechnologyAlreadyExistsException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
}
