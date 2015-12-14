package com.myorg.javacourse.servlet;

import java.io.IOException;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.myorg.javacourse.model.Portfolio;
import com.myorg.javacourse.service.PortfolioManager;

@SuppressWarnings("serial")
/**
 * this class provide information about all the portfolio that created
 * @param p
 */
public class PortfolioServlet extends HttpServlet {
	/**
	 * this method creats new portfolios and manage all commands of them
	 * at last, the method is present all the portfolio detailes 
	 * @param p
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
	
		PortfolioManager portfolioManager = new PortfolioManager();
		Portfolio portfolio = portfolioManager.getPortfolio();
		Portfolio portfolio2= new Portfolio(portfolio);
		resp.getWriter().println(portfolio.getHtmlString());
		portfolio2.setTitle("Portfolio #2");
		resp.getWriter().println(portfolio2.getHtmlString());
		resp.getWriter().println(portfolio.getHtmlString());
		resp.getWriter().println(portfolio2.getHtmlString());
		
		portfolio2.getStock()[2].setBid(55.55f);
		
		resp.getWriter().println(portfolio.getHtmlString());
		resp.getWriter().println(portfolio2.getHtmlString());
}
	}
