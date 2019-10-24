package com.hcl.bank;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MiniSmtServlet
 */
public class MiniSmtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MiniSmtServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int accno = Integer.parseInt(request.getParameter("accno"));
		List<Trans> lst =  AccountBAL.miniSmtBal(accno);
		if(lst != null){
			for(Trans i :lst){
				out.println("Trans Type  : " + i.getTransType() );
				out.println("Amount      : " + i.getTransAmount() );
				out.println("Date        : " + i.getTransDate() );
				out.println("Balance     : " + i.getAccBalance() );
				out.println("-------------------------------------------------------------");

			}
		} else out.println("account number not found");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
