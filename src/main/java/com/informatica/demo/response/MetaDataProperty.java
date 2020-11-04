package com.informatica.demo.response;

public enum MetaDataProperty {

	ERROR("error"), STATUS("status");

	private String description;

	MetaDataProperty(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return this.description;
	}
}