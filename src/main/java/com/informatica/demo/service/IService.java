package com.informatica.demo.service;

import com.informatica.demo.response.GitHubResponse;

public interface IService {
	
	public GitHubResponse getRepoListByLang(String langName, String sort, String order, String perPage, String page);

}
