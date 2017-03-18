package com.myinvisibox.domain;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Invisibox {
	@Id
	private String id;
	private String title;
	private String wikipediaUrl;
	private List<String> funFacts;
	private String barcodeId;
	private List<String> imageUuids;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWikipediaUrl() {
		return wikipediaUrl;
	}
	public void setWikipediaUrl(String wikipediaUrl) {
		this.wikipediaUrl = wikipediaUrl;
	}
	public List<String> getFunFacts() {
		return funFacts;
	}
	public void setFunFacts(List<String> funFacts) {
		this.funFacts = funFacts;
	}
	public String getBarcodeId() {
		return barcodeId;
	}
	public void setBarcodeId(String barcodeId) {
		this.barcodeId = barcodeId;
	}
	public List<String> getImageUuids() {
		return imageUuids;
	}
	public void setImageUuids(List<String> imageUuids) {
		this.imageUuids = imageUuids;
	}
	
}
