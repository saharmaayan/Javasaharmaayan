package com.myorg.javacourse.model;

public class Portfolio {
private String title; 
private final static int MAX_PORTFOLIO_SIZE=5;
private Stock[] stocks; 
private int index=0;

	
	public Portfolio(String title){
		stocks= new Stock [MAX_PORTFOLIO_SIZE];
		this.title=title;
    }
	
	
	public Portfolio(Portfolio p)
	{
		this(p.getTitle());
		for(int i=0 ; i < p.index ; i++)
		{
			 this.addStock(new Stock(p.getStock()[i]));
		
		}
	}
	public void deleteStockFromPortfolio(Portfolio p)
	{
		for(int i=0 ; i < p.index ; i++)
		{
			 p.stocks[i]=p.stocks[i+1];
		
		}
		p.index--;
		
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