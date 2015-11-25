package com.myorg.javacourse;

import java.io.IOException;
import javax.servlet.http.*;
import java.util.Date;


@SuppressWarnings("serial")
public class StockDetailsServlet extends HttpServlet {
	@SuppressWarnings("deprecation")
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		
		Stock stock1= new Stock();
		stock1.setSymbol("PIH");
		stock1.setAsk((float)(13.1));
		stock1.setBid((float)(12.4));
		stock1.setDate(new Date("11/15/2014"));	
		
		Stock stock2= new Stock();
		stock2.setSymbol("AAL");
		stock2.setAsk((float)(5.78));
		stock2.setBid((float)(5.5));
		stock2.setDate(new Date("11/15/2014"));		
		
		Stock stock3= new Stock();
		stock3.setSymbol("CAAS");
		stock3.setAsk((float)(32.2));
		stock3.setBid((float)(31.5));
		stock3.setDate(new Date("11/15/2014"));	
		
		resp.getWriter().println(stock1.getHtmlDescription());
		resp.getWriter().println(stock2.getHtmlDescription());
		resp.getWriter().println(stock3.getHtmlDescription());
	}
}
