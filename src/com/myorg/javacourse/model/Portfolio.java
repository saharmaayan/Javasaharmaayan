package com.myorg.javacourse.model;
import org.algo.model.PortfolioInterface;
import org.algo.model.StockInterface;
import com.myorg.javacourse.*;
import com.myorg.javacourse.exception.BalanceException;
import com.myorg.javacourse.exception.PortfolioFullException;
import com.myorg.javacourse.exception.StockAlreadyExistsException;
import com.myorg.javacourse.exception.StockNotExistException;
@SuppressWarnings("unused")
public class Portfolio implements PortfolioInterface {
private String title;
private StockInterface[] stocks;
private final static int MAX_PORTFOLIO_SIZE=5;
 private int index=0;
private float balance;
public enum ALGO_RECOMMENDATION{BUY, SELL, REMOVE, HOLD};

	/*public Portfolio(String title){
		stocks= new Stock [MAX_PORTFOLIO_SIZE];
		this.title=title;
    }*/
	/**
	 * this method removes the first stock in the portfolio
	 * the method checks if the portfolio is not empty, then the method removes the first stock by
	 * overwriting his place with the next stock after him.
	 * if the portfolio is empty, the method does nothing
	 * @param p
	 */
	public Portfolio() {
		this.stocks=new Stock[MAX_PORTFOLIO_SIZE];
	}
	public Portfolio(Stock[] stockArray) {
		this();
		for (int i = 0; i < stockArray.length; i++){
			this.stocks[i] = stockArray[i];	
		}
		index= stockArray.length;
	}
	/**
	 * this method change the bid's value of the last stock in the portfolio.
	 * the method checks if the portfolio is not empty, then the method change the bid's value of the last stock
	 * if the portfolio is empty, the method does nothing
	 * @param p
	 */
	
	public void updateBalance(float amount) throws BalanceException
	{
		if(amount+balance<0)
		{
			throw new BalanceException("The balance can not be negative!");
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
			amount+=getStocks()[i].getBid()*getStocks()[i].getStockQuantity();
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
	 * @throws StockAlreadyExistsException 
	 * @throws PortfolioFullException 
	 * @throws StockNotExistException 
	 */
	
	public void addStock(Stock s) throws StockAlreadyExistsException, PortfolioFullException, StockNotExistException{
		if (this.index < MAX_PORTFOLIO_SIZE)
		{
			for (int i = 0 ; i < this.index; i++)
			{
				if(s.getSymbol().equals(this.stocks[i].getSymbol())){
					throw new StockAlreadyExistsException("The stock is already exist");
				}
			}
			this.stocks[index] = s;
			((Stock) stocks[index]).setStockQuantity(0);
			this.index++;
		}
		else if(this.index>= MAX_PORTFOLIO_SIZE)
		{
			throw new PortfolioFullException("The protfolio is full!!");
		}
		else
		{
			throw new StockNotExistException("The stock is noe exist!!");
		}
    }
	public void removeStock(Stock symbol) throws StockNotExistException, Exception
	{
		
		for(int i=0; i<index; i++)
		{
			if(getStocks()[i].getSymbol().equals(symbol.getSymbol()))
			{
				 sellStock(symbol.getSymbol(), -1);
				for(int j=i; j<index; j++)
				{
					getStocks()[j]=getStocks()[j+1];
				}
				index--;
				return;
			}
		}
		throw new StockNotExistException("The stock is not exist");
	}
	public void sellStock(String symbol,int quantity) throws Exception
	{
		
		for(int i=0; i < index; i++)
			{
				if(symbol.equals(getStocks()[i].getSymbol()))
				{
					if(quantity==-1)
					{
						updateBalance(((Stock) stocks[i]).getStockQuantity() * stocks[i].getBid());
						getStocks()[i].setStockQuantity(0);
						return;
					}
					else if(quantity<=0 &&  quantity!= -1)
					{
						throw new Exception("the quantity cant be negative");
					}
					else if(getStocks()[i].getStockQuantity() >= quantity)
					{
						updateBalance(getStocks()[i].getStockQuantity() * getStocks()[i].getBid());
						getStocks()[i].setStockQuantity(getStocks()[i].getStockQuantity() - quantity);
						return;

					}
					else if(getStocks()[i].getStockQuantity() < quantity)
					{
						throw new Exception("Not enough stocks to sell");
					}
				}
			}
		
	}
	public void buyStock(Stock stock,int quantity) throws BalanceException, Exception
	{
		int max=0;
		if(quantity<=0 && quantity!= -1)
		{
			throw new Exception("sorry the quantity is worng!");
		}
		else{
			max=(int)(balance/stock.getAsk());
			if(quantity>max){
				throw new BalanceException("the balance is not enough");
			}
			for(int i=0; i<index; i++)
			{
					if(getStocks()[i].getSymbol().equals(stock.getSymbol()))
					{
						if(quantity== -1)
						{
							getStocks()[i].setStockQuantity(getStocks()[i].getStockQuantity()+max);
							updateBalance(-(max*stock.getAsk()));
							return;
						}
						else
						{
							stock.setStockQuantity(getStocks()[i].getStockQuantity()+quantity);
							updateBalance(-(quantity*stock.getAsk()));
							return;
						}
					}
			}
			this.addStock(stock);
			if(quantity==-1){
				this.getStocks()[index-1].setStockQuantity(max);
				this.updateBalance(-(max*stock.getAsk()));
				return ;
			}
			else{
				getStocks()[index-1].setStockQuantity(quantity);
				this.updateBalance(-(quantity*stock.getAsk()));
				return;
			}
		}
	}
	public Stock[] getStocks(){
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
			details = details +"<br>"+getStocks()[i].getHtmlDescription();
		}
		portfolioValue = getTotalValue() + "$ Total Stocks value:" + this.getStockValue() + "$ Balance:" + getBalance() + "$";
		return (portfolioTitle + "<br><br>" + "Total Portfolio Value:" + portfolioValue + "<br><br>" + details);
	}
	public static int getMaxPortfolioSize() {
		return MAX_PORTFOLIO_SIZE;
	}
	public StockInterface findStock(String symbol) {
		for(int i=0; i< getIndex(); i++)
		{
			if(symbol.equals(getStocks()[i].getSymbol()));
			{
				return getStocks()[i];
			}
		}
		return null;
	}
}