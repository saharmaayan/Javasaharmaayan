package com.myorg.javacourse.model;

import com.myorg.javacourse.service.PortfolioManager;

public class Portfolio {
private String title; 
private final static int MAX_PORTFOLIO_SIZE=5;
private Stock[] stocks; 
private int index=0;
private float balance;
public enum ALGO_RECOMMENDATION{BUY, SELL, REMOVE, HOLD};

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
	
	public void updateBalance(float amount)
	{
		if(amount+balance<0)
		{
			return;
		}
		else
		{
			balance+=amount;
		}
	}
	
	public float getBalance()
	{
		return balance;
	}
	public float getTotalValue(){
		float total=0;
		total= getBalance()+getStockValue();
		return total;
	}
	public float getStockValue(){
		float amount = 0; 
		for(int i=0; i<index; i++)
		{
			amount+=getStock()[i].getBid()*getStock()[i].getStockQuantity();
		}
		return amount;
	}

	/**
	 * this method add new stock to the portfolio
	 * the method check if there is space in the portfolio to add another stock,
	 * then it adds the stock to the end of the portfollio and increase the portfolio size by 1
	 * @param p
	 */
	
	public void addStock(Stock s){
		for(int i=0; i < index; i++)
		{
			if(s.getSymbol().equals(stocks[i].getSymbol())&&index!=0)
			{
				return;
			}
			else if(index>4)
			{
				System.out.println("Can’t add new stock, portfolio can have only" + MAX_PORTFOLIO_SIZE+ "stocks");
			}
			else
			{
				s.setStockQuantity(0);
				stocks[index++]=s;
			}
		}
    }
	public boolean removeStock(Stock symbol)
	{
		boolean flag=false;
		for(int i=0; i<index; i++)
		{
			if(getStock()[i].getSymbol().equals(symbol.getSymbol()))
			{
				flag= sellStock(symbol.getSymbol(), -1);
				for(int j=i; j<index; j++)
				{
					getStock()[j]=getStock()[j+1];
				
				}
				index--;
			}
		}
		return flag;
	}
	public boolean sellStock(String symbol,int quantity)
	{
		boolean flag=false;
		
			for(int i=0; i < index; i++)
			{
				if(symbol.equals(getStock()[i].getSymbol()))
				{
					if(quantity==-1)
					{
						updateBalance(quantity*(getStock()[i].getBid()));
						getStock()[i].setStockQuantity(0);
						flag=true;
					}
					else if(quantity<0 &&  quantity!= -1)
					{
						flag=false;
						System.out.println("Sorry, but you cant sell");
					}
					else if((getStock()[i].getStockQuantity())-quantity<0)
					{
						flag=false;
						System.out.println("Sorrt,Not enough stocks to sell.");

					}
					else
					{
						updateBalance(quantity*(getStock()[i].getBid()));
						getStock()[i].setStockQuantity((getStock()[i].getStockQuantity())-quantity);
						flag=true;
					}
				}
			}
		
			return flag;
	}
	public boolean buyStock(Stock stock,int quantity)
	{
		
		for(int i=0; i<index; i++)
		{
			if(getStock()[i].getSymbol().equals(stock.getSymbol()))
			{
				if(quantity==-1)
				{
					while(getBalance()>0 && stock.getAsk()< getBalance() )
					{
						updateBalance(-stock.getAsk());
					}
					getStock()[i].setStockQuantity(quantity+getStock()[i].getStockQuantity());
					return true;
				}
				else
				{
					if(quantity*stock.getAsk()>getBalance())
					{
						return false;
					}
					else
					{
						updateBalance(-quantity*stock.getAsk());
						getStock()[i].setStockQuantity(quantity+getStock()[i].getStockQuantity());
						return true;
					}
				}
				
			}
			}
		if(quantity*stock.getAsk()>getBalance())
		{
			System.out.println("Not enough balance to complete purchase.");
			return false;
		}
		else
		{
			addStock(stock);
			updateBalance(-quantity*stock.getAsk());
			stock.setStockQuantity(quantity);
			return true;
		}
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