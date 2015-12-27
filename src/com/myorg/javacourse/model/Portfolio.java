package com.myorg.javacourse.model;
import org.algo.model.PortfolioInterface;
import org.algo.model.StockInterface;

import com.myorg.javacourse.*;

@SuppressWarnings("unused")
public class Portfolio implements PortfolioInterface {
private String title;
private StockInterface[] stocks;
private final static int MAX_PORTFOLIO_SIZE=5;
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
	public Portfolio() {
		this.stocks=new Stock[MAX_PORTFOLIO_SIZE];
	}
	public Portfolio(Stock[] stockArray) {
		this();
		for (int i = 0; i < MAX_PORTFOLIO_SIZE; i++){
			this.stocks[i] = stockArray[i];	
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
		for(int i=0; i<getIndex(); i++)
		{
			amount+=getStock()[i].getBid()*getStock()[i].getStockQuantity();
		}
		return amount;
	}
	public int getIndex(){
		return index;
	}

	/**
	 * this method add new stock to the portfolio
	 * the method check if there is space in the portfolio to add another stock,
	 * then it adds the stock to the end of the portfollio and increase the portfolio size by 1
	 * @param p
	 */
	
	public void addStock(Stock s){
		if (this.index < MAX_PORTFOLIO_SIZE)
		{
			for (int i = 0 ; i < this.index; i++)
			{
				if(s.getSymbol() == this.stocks[i].getSymbol()){
					return;
				}
			}
			this.stocks[index] = s;
			((Stock) this.stocks[index]).setStockQuantity(0);
			this.index++;
		}
		else
			System.out.println("Can’t add new stock, portfolio can have only" + MAX_PORTFOLIO_SIZE + "stocks");
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
		
		for(int i=0; i < index; i++)
			{
				if(symbol.equals(getStock()[i].getSymbol()))
				{
					if(quantity==-1)
					{
						updateBalance(((Stock) stocks[i]).getStockQuantity() * stocks[i].getBid());
						getStock()[i].setStockQuantity(0);
						return true;
					}
					else if(quantity<=0 &&  quantity!= -1)
					{
						System.out.println("Sorry, but you cant sell");
						return false;
					}
					else if(getStock()[i].getStockQuantity() >= quantity)
					{
						updateBalance(getStock()[i].getStockQuantity() * getStock()[i].getBid());
						getStock()[i].setStockQuantity(getStock()[i].getStockQuantity() - quantity);
						return true;

					}
					else if(getStock()[i].getStockQuantity() < quantity)
					{
						System.out.println("Not enough stocks to sell");
						return false;
					}
				}
			}
		System.out.println("error!!!");
		return false;
			
	}
	public boolean buyStock(Stock stock,int quantity)
	{
		int max=0;
		if(quantity<=0 && quantity!= -1)
		{
			System.out.println("sorry the quantity is worng!");
			return false;
		}
		else{
			max=(int)(balance/stock.getAsk());
			if(quantity>max){
				System.out.println("the balance is not enough");
				return false;
			}
		
			for(int i=0; i<index; i++)
			{
					if(getStock()[i].getSymbol().equals(stock.getSymbol()))
					{
						if(quantity== -1)
						{
							getStock()[i].setStockQuantity(getStock()[i].getStockQuantity()+max);
							updateBalance(-(max*stock.getAsk()));
							return true;
						}
						else
						{
							getStock()[i].setStockQuantity(getStock()[i].getStockQuantity()+quantity);
							updateBalance(-(quantity*stock.getAsk()));
							return true;
						}
					}
			}
			addStock(stock);
			if(quantity==-1){
				getStock()[index-1].setStockQuantity(max);
				updateBalance(-(max*stock.getAsk()));
				return true;
			}
			else{
				getStock()[index-1].setStockQuantity(quantity);
				updateBalance(-(quantity*stock.getAsk()));
				return true;
			}
		}
	}
	
	
	public Stock[] getStock(){
		return (Stock[]) stocks;
	}
	
	public void setTitle(String title){
		this.title= title;
	}
	public String getTitle(){
		return title;
	}
	
	public String getHtmlString(){
		String portfolioTitle = "<h1>"  + getTitle() + "</h1>";
		String details = "";
		String portfolioValue;
		for(int i = 0; i < index; i++)
		{
			details = details +"<br>"+getStock()[i].getHtmlDescription();
		}
		portfolioValue = getTotalValue() + "$ Total Stocks value:" + this.getStockValue() + "$ Balance:" + getBalance() + "$";
		return (portfolioTitle + "<br><br>" + "Total Portfolio Value:" + portfolioValue + "<br><br>" + details);
	}
	public static int getMaxSize(){
		return MAX_PORTFOLIO_SIZE;
	}
	public StockInterface findStock(String symbol) {
		for(int i=0; i< getIndex(); i++)
		{
			if(symbol.equals(getStock()[i].getSymbol()));
			{
				return (StockInterface) getStock()[i];
			}
		}
		return null;
	}
	@Override
	public StockInterface[] getStocks() {
		// TODO Auto-generated method stub
		return null;
	}
}