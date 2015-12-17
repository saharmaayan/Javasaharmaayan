package com.myorg.javacourse.service;

import java.util.Date;

/**
 * this class generate new potfolio and adding some stocks and their values by using method getPortfolio
 * @param p
 */

import com.myorg.javacourse.model.Portfolio;
import com.myorg.javacourse.model.Stock;

public class PortfolioManager {

	@SuppressWarnings("deprecation")
	public Portfolio  getPortfolio()
	/**
	 * this method generate new portfolio and adding some stocks and their values and then return the portfolio.
	 * @param p
	 */
	{
		Portfolio myPortfolio = new Portfolio("Exercise 7 portfolio");
		myPortfolio.updateBalance(10000f);
		

		Stock stock1= new Stock("PIH",10.0f,8.5f,new Date("12/15/2014"));
		
		Stock stock2= new Stock(stock1);
		stock2.setSymbol("AAL");
		stock2.setAsk((float)(30.0));
		stock2.setBid((float)(25.5));		
		
		Stock stock3= new Stock(stock1);
		stock3.setSymbol("CAAS");
		stock3.setAsk((float)(20.0));
		stock3.setBid((float)(15.5));
		
		myPortfolio.buyStock(stock1, 20);
		myPortfolio.buyStock(stock2, 30);
		myPortfolio.buyStock(stock3, 40);
		
		myPortfolio.sellStock("AAL",-1);
		myPortfolio.removeStock(stock3);

		
		return myPortfolio;
	}
}
