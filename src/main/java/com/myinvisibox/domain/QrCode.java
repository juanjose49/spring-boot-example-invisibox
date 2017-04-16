package com.myinvisibox.domain;

public class QrCode {
	private String qrCode;
	private String plaintext;
	
	public QrCode(String qrCode,String plaintext) {
		super();
		this.qrCode = qrCode;
		this.plaintext = plaintext;
	}
	
	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public String getPlaintext() {
		return plaintext;
	}

	public void setPlaintext(String plaintext) {
		this.plaintext = plaintext;
	}


}
