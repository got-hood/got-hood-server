package com.gachon.gothood.global.exception;

import com.gachon.gothood.global.response.BaseResponseDto;
import com.gachon.gothood.global.response.BusinessException;
import com.gachon.gothood.global.response.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public BaseResponseDto<ErrorMessage> exceptionHandle(BusinessException e) {
        return new BaseResponseDto<>(e.getErrorMessage());
    }

    /**
     * HTTP Request Method 오류 전용
     * */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public BaseResponseDto<ErrorMessage> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return new BaseResponseDto<>(HttpStatus.METHOD_NOT_ALLOWED.value(), false, e.getMessage());
    }

    /**
     * 잘못 입력된 경우
     * */
    @ExceptionHandler({NullPointerException.class, HttpMessageNotReadableException.class})
    public BaseResponseDto<ErrorMessage> handleBadRequestException() {
        return new BaseResponseDto<>(HttpStatus.BAD_REQUEST.value(), false, "BAD_REQUEST");
    }

//    /**
//     * 내부 서버 오류 전용
//     * */
//    @ExceptionHandler(RuntimeException.class)
//    public BaseResponseDto<ErrorMessage> handleAnyException(RuntimeException e) {
//        return new BaseResponseDto<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), false, "INTERNAL_SERVER");
//    }

}
