package com.myorg.javacourse;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Stock {

	private String symbol;
	private float ask;
	private float bid;
	private Date date;
	
	SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy");
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public float getAsk() {
		return ask;
	}
	public void setAsk(float ask) {
		this.ask = ask;
	}
	public float getBid() {
		return bid;
	}
	public void setBid(float bid) {
		this.bid = bid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public String getHtmlDescription() {
		String stockHtmlDetailsString =  "<b> Stock symbol: </b> " + getSymbol()+ "  <b>Ask:</b> " + getAsk() + "  <b>Bid</b>:  " + sdf.format(getDate())+ "<br>";
		return stockHtmlDetailsString;

	}
}


