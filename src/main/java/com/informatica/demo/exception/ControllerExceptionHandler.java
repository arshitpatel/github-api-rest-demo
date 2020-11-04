package com.informatica.demo.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import com.informatica.demo.response.GitHubResponse;
import com.informatica.demo.response.MetaDataProperty;

@ControllerAdvice
public class ControllerExceptionHandler extends DefaultHandlerExceptionResolver {

	@ExceptionHandler(InternalServerException.class)
	public ResponseEntity<GitHubResponse> handleValidationError(Exception ex, HttpServletRequest req) {
		GitHubResponse response = new GitHubResponse();
		Map<String, String> metaData = new HashMap<String, String>();
		metaData.put(MetaDataProperty.ERROR.toString(), "Request Failed due to Internal Server Error.");
		metaData.put(MetaDataProperty.STATUS.toString(), HttpStatus.INTERNAL_SERVER_ERROR.toString());
		response.setMetaData(metaData);
		return buildResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private <T> ResponseEntity<T> buildResponseEntity(T body, HttpStatus status) {
		return new ResponseEntity<T>(body, status);
	}
}