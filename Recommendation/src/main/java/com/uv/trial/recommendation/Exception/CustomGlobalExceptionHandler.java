package com.uv.trial.recommendation.Exception;

import org.hibernate.exception.ConstraintViolationException;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler
{
    @ExceptionHandler({InvalidInputException.class,InvalidGenderException.class,NotUniqueException.class, ConstraintViolationException.class})
    public void BadRequest(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler({InvalidCategoryException.class,InvalidBrandException.class,DataNotFoundException.class,NoPreviousPurchaseException.class})
    public void NotFound(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(InvalidUserException.class)
    public void InvalidUser(HttpServletResponse response) throws IOException
    {
        response.sendError(HttpStatus.UNAUTHORIZED.value());
    }

    @NotNull
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());
        String error = Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage();
        body.put("errors", error);
        return new ResponseEntity<>(body, headers, status);
    }

}
