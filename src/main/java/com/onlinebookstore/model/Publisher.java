package com.onlinebookstore.model;

public class Publisher {


	private String publisherName;

	public String getPublisherName() {
		return publisherName;
	}
	
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	
	@Override
	public String toString() {
		return "Publisher [publisherName=" + this.publisherName + "]";
	}
	
	
}
