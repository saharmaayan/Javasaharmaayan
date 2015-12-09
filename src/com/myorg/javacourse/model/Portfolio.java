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
	/**
	 * this method removes the first stock in the portfolio
	 * the method checks if the portfolio is not empty, then the method removes the first stock by
	 * overwriting his place with the next stock after him.
	 * if the portfolio is empty, the method does nothing
	 * @param p
	 */
	
	public Portfolio(Portfolio p)
	{
		this(p.getTitle());
		for(int i=0 ; i < p.index ; i++)
		{
			 this.addStock(new Stock(p.getStock()[i]));
		
		}
	}
	
	/**
	 * this method change the bid's value of the last stock in the portfolio.
	 * the method checks if the portfolio is not empty, then the method change the bid's value of the last stock
	 * if the portfolio is empty, the method does nothing
	 * @param p
	 */
	
	public void deleteStockFromPortfolio(Portfolio p)
	{
		for(int i=0 ; i < p.index ; i++)
		{
			 p.stocks[i]=p.stocks[i+1];
		
		}
		p.index--;
		
	}
	/**
	 * this method add new stock to the portpolio
	 * the method check if there is space in the portfolio to add another stock,
	 * then it adds the stock to the end of the portfollio and increase the portfolio size by 1
	 * @param p
	 */
	
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