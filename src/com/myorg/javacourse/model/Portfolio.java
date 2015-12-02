package com.myorg.javacourse.model;

import com.myorg.javacourse.Stock;


public class Portfolio {
private String title; 
private final static int MAX_PORTFOLIO_SIZE=5;
private Stock[] stocks; 
private int index=0;

	public Portfolio(){
		stocks= new Stock [MAX_PORTFOLIO_SIZE];
}
	public void addStock(Stock sahar){
		stocks[index++]=sahar;
}
	public Stock[] getStock(){
		return stocks;
	}
	
	public void setTitle(String title){
		this.title= title;
	}
	public String getTitle(){
		return title;
	}	
	public String getHtmlString(){
		String ret= "<h1>" +getTitle()+ "</h1><br>";
		
		for (int i =0; i < index; i++) {
				ret += stocks[i].getHtmlDescription();
			}
		return ret;
	}
}