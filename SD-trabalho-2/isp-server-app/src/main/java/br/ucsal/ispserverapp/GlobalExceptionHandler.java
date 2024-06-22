package br.ucsal.ispserverapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import br.ucsal.ispserverapp.viewmodels.ErrorResponseDTO;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ErrorResponseDTO> handleHttpException(HttpClientErrorException ex) {
        var statusCode = ex.getStatusCode();
        var errorMessage = ex.getResponseBodyAsString();
        var errorResponse = new ErrorResponseDTO(statusCode, errorMessage);
        return ResponseEntity.status(statusCode).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleException(Exception ex) {
        var statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        var errorMessage = new ErrorResponseDTO(statusCode, ex.getMessage());
        return ResponseEntity.status(statusCode).body(errorMessage);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponseDTO> handleNotFoundException(Exception ex) {
        var statusCode = HttpStatus.NOT_FOUND;
        var errorMessage = new ErrorResponseDTO(statusCode, ex.getMessage());
        return ResponseEntity.status(statusCode).body(errorMessage);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponseDTO> handleBadRequestException(Exception ex) {
        var statusCode = HttpStatus.BAD_REQUEST;
        var errorMessage = new ErrorResponseDTO(statusCode, ex.getMessage());
        return ResponseEntity.status(statusCode).body(errorMessage);
    }
}