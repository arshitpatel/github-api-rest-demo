package com.informatica.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.informatica.demo.response.GitHubResponse;
import com.informatica.demo.response.MetaDataProperty;
import com.informatica.demo.service.IService;

@RestController
public class Controller {

	private final IService service;

	@Autowired
	public Controller(IService service) {
		this.service = service;
	}

	@GetMapping(value = "/search/repositories/{language}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<GitHubResponse> findReposByLang(@PathVariable("language") @NotBlank String lang,
			@RequestHeader(value = "sort", required = false) String sort,
			@RequestHeader(value = "order", required = false) String order,
			@RequestHeader(value = "perPage", required = false) String perPage,
			@RequestHeader(value = "page", required = false) String page) {

		GitHubResponse resp = service.getRepoListByLang(lang, sort, order, perPage, page);
		Map<String, String> metaData = new HashMap<String, String>();
		metaData.put(MetaDataProperty.STATUS.toString(), HttpStatus.OK.toString());
		resp.setMetaData(metaData);

		return new ResponseEntity<GitHubResponse>(resp, HttpStatus.OK);
	}

}
