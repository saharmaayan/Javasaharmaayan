package com.myorg.javacourse.model;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Stock {
	
	private String symbol;
	private float ask;
	private float bid;
	private Date date;
	@SuppressWarnings("unused")
	private int recommendation;
	private int stockQuantity;
	private static final int BUY=0;
	private static final int SELL=1;
	private static final int REMOVE=2;
	private static final int HOLD=3;
	
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

	public String getHtmlDescription() {
		String stockHtmlDetailsString =  "<b> Stock symbol: </b> " + getSymbol()+ "  <b>Ask:</b> " + getAsk() + "<b>Bid:</b>" +getBid() + " <b>date</b>:  " + sdf.format(getDate())+ "<br>";
		return stockHtmlDetailsString;

	}
	
	
}

