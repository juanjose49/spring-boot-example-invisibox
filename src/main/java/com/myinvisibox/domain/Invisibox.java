package com.myinvisibox.domain;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Invisibox {
	@Id
	private String id;
	private String title;
	private String barcodeId;
	private List<String> slides;
	private String userId;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getBarcodeId() {
		return barcodeId;
	}
	public void setBarcodeId(String barcodeId) {
		this.barcodeId = barcodeId;
	}
	public List<String> getSlides() {
		return slides;
	}
	public void setSlides(List<String> slides) {
		this.slides = slides;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	
}
