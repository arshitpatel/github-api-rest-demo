package com.informatica.demo.response;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.informatica.demo.model.Item;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private Map<String, String> metaData;
	private Item[] items;

	public Map<String, String> getMetaData() {
		return metaData;
	}

	public void setMetaData(Map<String, String> metaData) {
		this.metaData = metaData;
	}

	public Item[] getItems() {
		return items;
	}

	public void setItems(Item[] items) {
		this.items = items;
	}

}
