package com.myorg.javacourse.service;

import java.util.Date;

import com.myorg.javacourse.Stock;
import com.myorg.javacourse.model.Portfolio;

public class PortfolioManager {

	@SuppressWarnings("deprecation")
	public Portfolio  getPortfolio()
	{
		Portfolio portfolio = new Portfolio("Maayan and Sahar portfolio");

		Stock stock1= new Stock("PIH",13.1f,12.4f,new Date("11/15/2014"));
		
		Stock stock2= new Stock(stock1);
		stock2.setSymbol("AAL");
		stock2.setAsk((float)(5.78));
		stock2.setBid((float)(5.5));		
		
		Stock stock3= new Stock(stock1);
		stock3.setSymbol("CAAS");
		stock3.setAsk((float)(32.2));
		stock3.setBid((float)(31.5));
		
		
		
		portfolio.addStock(stock1);
		portfolio.addStock(stock2);
		portfolio.addStock(stock3);
		
		return portfolio;
	}
}
