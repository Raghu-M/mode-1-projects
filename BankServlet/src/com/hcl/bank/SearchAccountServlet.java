package com.hcl.bank;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchAccountServlet
 */
public class SearchAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int accno = Integer.parseInt(request.getParameter("accno"));
		Accounts obj = AccountBAL.searchAccountBal(accno);
		if(obj != null){
			out.println("Account Number  : " + obj.getAccountNo());
			out.println("First Name      : " + obj.getFirstName());
			out.println("Last Name       : " + obj.getLastName());
			out.println("City            : " + obj.getCity());
			out.println("State           : " + obj.getState());
			out.println("Amount          : " + obj.getAmount());
			out.println("Cheque Facility : " + obj.getCheqFacil());
			out.println("Account Type    : " + obj.getAccountType());
		} else out.println("Account Not Found");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
