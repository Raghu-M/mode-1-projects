package com.hcl.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String[][] product = new String[100][100] ;
	int i=0;
	int sum=0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//out.print(request.getParameter("id"));
		product[i][0] = request.getParameter("id");
		product[i][1] = request.getParameter("ename");
		product[i][2] = request.getParameter("qty");
		product[i][3] = request.getParameter("price");
		sum += Integer.parseInt(product[i][2])*(Integer.parseInt(product[i][3]));
		for(int j=0;j<=i;j++){
			out.println("Id        : " + product[j][0] + "</br>");
			out.println("Name      : " + product[j][1]+ "</br>");
			out.println("Quantity  : " + product[j][2]+ "</br>");
			out.println("Price       : " + product[j][3]+ "</br>");
			out.println("****************************************"+ "</br>");
		}
		out.print("<a href='Order.html'><input type='button' value='Add item' /></a>");
		out.print("<button name='bill' type='button'>Bill</button>"+ "</br>");
		i++;
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
