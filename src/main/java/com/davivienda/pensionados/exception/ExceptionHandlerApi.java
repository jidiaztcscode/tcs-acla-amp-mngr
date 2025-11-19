package com.davivienda.pensionados.exception;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerApi {
	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerApi.class);
	
	private ResponseEntity<Map<String, String>> buildStaticMessageResponse(HttpStatus status, String logMessage, String userMessage, Exception ex) {
        logger.warn("{}: {}", logMessage, ex.getMessage());
        Map<String, String> error = new HashMap<>();
        error.put("message", userMessage);
        return ResponseEntity.status(status).body(error);
    }

	@ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleAllOtherExceptions(Exception ex) {
        logger.error("Unhandled exception", ex);
        return buildStaticMessageResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Unhandled exception", "Error interno del servidor, por favor comuníquese con el administrador.", ex);
    }
}
