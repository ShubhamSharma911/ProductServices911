package dev.shubham911.productservices911.advices;

import dev.shubham911.productservices911.dtos.ErrorDto;
import dev.shubham911.productservices911.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice

public class ControllerAdvice {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> handleProductNotFound(ProductNotFoundException productNotFoundException){
        ErrorDto errorDto = new ErrorDto();

        errorDto.setMessage(productNotFoundException.getMessage());
        ResponseEntity<ErrorDto> responseEntity = new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
        return responseEntity;
    }

}
