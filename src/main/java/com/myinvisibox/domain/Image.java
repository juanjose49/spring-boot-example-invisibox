package com.myinvisibox.domain;

import org.springframework.data.annotation.Id;

public class Image {
	@Id
	private String id;
	private String uuid;
	private String base64Img;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getBase64Img() {
		return base64Img;
	}
	public void setBase64Img(String base64Img) {
		this.base64Img = base64Img;
	}
	
}
