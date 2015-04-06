package com.zizibujuan.util.json;

import java.util.Date;

public class Bean {
	private String text;
	private int intNumber;
	private double doubleNumber;
	private Date date;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getIntNumber() {
		return intNumber;
	}
	public void setIntNumber(int intNumber) {
		this.intNumber = intNumber;
	}
	public double getDoubleNumber() {
		return doubleNumber;
	}
	public void setDoubleNumber(double doubleNumber) {
		this.doubleNumber = doubleNumber;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
