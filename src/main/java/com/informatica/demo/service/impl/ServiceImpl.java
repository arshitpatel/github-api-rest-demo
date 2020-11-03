package com.informatica.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.informatica.demo.response.GitHubResponse;
import com.informatica.demo.service.IService;

@Component
public class ServiceImpl implements IService {

	private RestTemplate restTemplate;

	@Value("${git.api.baseUrl}")
	private String baseUrl;

	private final static String SEARCH_REPO = "/search/repositories";

	@Autowired
	public ServiceImpl(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public GitHubResponse getRepoListByLang(String langName, String sort, String order, String perPage, String page) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/vnd.github.v3+json");

		HttpEntity<HttpHeaders> entity = new HttpEntity<HttpHeaders>(headers);

		String query = buildQuery(langName, sort, order, perPage, page);

		ResponseEntity<GitHubResponse> resp = restTemplate.exchange(baseUrl + SEARCH_REPO + query, HttpMethod.GET,
				entity, GitHubResponse.class);

		return resp.getBody();

	}

	private static String buildQuery(String langName, String sort, String order, String perPage, String page) {
		String query = "?q=language:" + langName;

		if (sort != null) {
			query += "&sort=" + sort;
		}
		if (order != null) {
			query += "&order=" + order;
		}		
		if (perPage != null) {
			query += "&per_page=" + perPage;
		}
		if (page != null) {
			query += "&page=" + page;
		}
		return query;
	}
}
