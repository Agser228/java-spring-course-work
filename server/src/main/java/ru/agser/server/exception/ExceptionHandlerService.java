package ru.agser.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.agser.server.model.dto.Response;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerService {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response> invalidRequestException(
            MethodArgumentNotValidException ex
    ) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        Map<String, Object> data = new HashMap<>();
        data.put("success", false);
        for (FieldError fieldError : fieldErrors) {
            data.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return ResponseEntity.ok(Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .data(data)
                .build());
    }

    @ExceptionHandler(IllegalEmailStateException.class)
    public ResponseEntity<Response> illegalEmailStateException(
            IllegalEmailStateException ex
    ) {
        Map<String, Object> data = new HashMap<>();
        data.put("success", false);
        data.put("email", ex.getMessage());
        return ResponseEntity.ok(Response.builder()
                .timeStamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .data(data)
                .build());
    }

    @ExceptionHandler(IncorrectPasswordException.class)
    public ResponseEntity<Response> incorrectPasswordException(
            IncorrectPasswordException ex
    ) {
        Map<String, Object> data = new HashMap<>();
        data.put("success", false);
        data.put("password", ex.getMessage());
        return ResponseEntity.ok(Response.builder()
                .timeStamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .data(data)
                .build());
    }

}
