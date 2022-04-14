package com.infogalaxy.employeepayrollappbackend.exceptions;

import com.infogalaxy.employeepayrollappbackend.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

/***
 * @ControllerAdvice handle All Exception globally form all layers in app
 * @ExceptionHandler create proper exception message from generated error list
 */
@ControllerAdvice
@Slf4j
public class EmployeePayrollExceptionHandler {

    public final String message="Exception while procwssing REST API Call";

    /***
     *
     * @param exception
     * @return ResponseEntity 
     */

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errorMessage = errorList.stream().map(errObj -> errObj.getDefaultMessage()).collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO(message,errorMessage);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    /***
     * Custome Excpetion Handled by User Defined Runtime Exception Class
     * @param exception
     * @return
     */
    @ExceptionHandler(EmployeePayrollException.class)
    public ResponseEntity<ResponseDTO> handleEmployeePayrollException(EmployeePayrollException exception) {
        ResponseDTO responseDTO = new ResponseDTO(message, exception.getMessage());
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
    }

    /***
     * Date Format Validation Exception
     * @param exception
     * @return
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseDTO> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        ResponseDTO responseDTO = new ResponseDTO(message, "Should have Date in Format of dd MMM yyyy");
        log.error("Invalid Date Format "+exception);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
    }
}
