package com.hcl.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddCookieServlet
 */
public class AddCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie ckAnand = new Cookie("Anand","52");
		ckAnand.setMaxAge(1000*60*60*24);
		response.addCookie(ckAnand);
		
		Cookie ckRaghu = new Cookie("Raghu","22");
		ckAnand.setMaxAge(1000*60*60*24);
		response.addCookie(ckRaghu);
		
		Cookie ckVarun = new Cookie("Varun","32");
		ckAnand.setMaxAge(1000*60*60*24);
		response.addCookie(ckVarun);
		
		Cookie ckManju = new Cookie("Manju","41");
		ckAnand.setMaxAge(1000*60*60*24);
		response.addCookie(ckManju);
		
		Cookie ckNithin = new Cookie("Nithin","27");
		ckAnand.setMaxAge(1000*60*60*24);
		response.addCookie(ckNithin);
		PrintWriter out = response.getWriter();
		out.print("cookie Added Successfully </br></br>");
		out.print("<a href='ShowCookieServlet'>Show Cookie</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
