package com.bookmyshowbyshah.bookmyshow.Controllers.globalExceptionHandler;

import com.bookmyshowbyshah.bookmyshow.dto.ResponseDTO;
import com.bookmyshowbyshah.bookmyshow.exceptions.InvalidTokenException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestGlobalExceptionHandler {
    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<ResponseDTO> handleInvalidTokenException(Exception ex) {
        ResponseDTO response = new ResponseDTO();
        response.setMessage(ex.getMessage());
        response.setMessageCode("403");
        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }
}
