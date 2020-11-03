package com.informatica.demo.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.informatica.demo.model.Item;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private Item[] items;

	public Item[] getItems() {
		return items;
	}

	public void setItems(Item[] items) {
		this.items = items;
	}

}
