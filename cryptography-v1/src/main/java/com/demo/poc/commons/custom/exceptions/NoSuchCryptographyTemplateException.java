package com.demo.poc.commons.custom.exceptions;

import com.demo.poc.commons.core.errors.dto.ErrorDto;
import com.demo.poc.commons.core.errors.enums.ErrorDictionary;
import com.demo.poc.commons.core.errors.exceptions.GenericException;
import org.springframework.http.HttpStatus;

public class NoSuchCryptographyTemplateException extends GenericException {

  private static final ErrorDictionary EXCEPTION = ErrorDictionary.NO_SUCH_CRYPTOGRAPHY_TEMPLATE;

  public NoSuchCryptographyTemplateException() {
    super(EXCEPTION.getMessage());
    this.httpStatus = HttpStatus.BAD_REQUEST;
    this.errorDetail = ErrorDto.builder()
        .code(EXCEPTION.getCode())
        .message(EXCEPTION.getMessage())
        .build();
  }
}
