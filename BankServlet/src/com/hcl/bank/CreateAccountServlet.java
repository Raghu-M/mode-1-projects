package com.hcl.bank;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateAccountServlet
 */
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		 Accounts objAccounts = new Accounts();
		objAccounts.setFirstName(request.getParameter("firstname"));
		objAccounts.setLastName(request.getParameter("lastname"));
		objAccounts.setCity(request.getParameter("city"));
		objAccounts.setState(request.getParameter("state"));
		objAccounts.setAmount(Integer.parseInt(request.getParameter("amount")));
		objAccounts.setCheqFacil(request.getParameter("cheqfacl"));
		objAccounts.setAccountType(request.getParameter("acctype"));
		out.println(AccountBAL.createAccountBal(objAccounts));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
