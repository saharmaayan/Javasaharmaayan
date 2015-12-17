package com.myorg.javacourse.model;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Stock {
	
	private String symbol;
	private float ask;
	private float bid;
	private Date date;
	private int stockQuantity;
	@SuppressWarnings("unused")
	private Portfolio.ALGO_RECOMMENDATION recommendation;
	
	
	public Stock(String symbol, float ask, float bid, Date date)
	{
		this.symbol= symbol;
		this.ask=ask;
		this.bid=bid;
		this.date=date;
		
	}
	public Stock(Stock s)
	{
		this(s.getSymbol(),s.getAsk(),s.getBid(),s.getDate());
	}
	
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
	public void setStockQuantity(int stockQuantity)
	{
		this.stockQuantity=stockQuantity;
	}
	public int getStockQuantity(){
		return stockQuantity;
	}

	public String getHtmlDescription() {
		String stockHtmlDetailsString =  "<b> Stock symbol: </b> " + getSymbol()+ "  <b>Ask:</b> " + getAsk() + "<b>Bid:</b>" +getBid() + " <b>date</b>:  " + sdf.format(getDate())+ "<br>";
		return stockHtmlDetailsString;

	}
	
	
}


