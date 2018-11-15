package com.littlepo.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class QrData {
	private String qrString;
	
	public void setQrString(String qrString) {
		this.qrString = qrString;
	}
	
	public String getQrString() {
		return this.qrString;
	}
}
