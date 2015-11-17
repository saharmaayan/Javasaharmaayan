package com.myorg.javacourse;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Ex3 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		
		MathClass mathClass = new MathClass(50, 30, 50, 20, 13);
		
		resp.getWriter().println(mathClass.getResults());
	}
}