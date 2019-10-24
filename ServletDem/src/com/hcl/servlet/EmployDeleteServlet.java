package com.hcl.servlet;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployDeleteServlet
 */
public class EmployDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = DaoConnection.getconnection();
		PrintWriter out =response.getWriter();
		String cmd = "Select * From Employ where empno=?";
		int del = Integer.parseInt(request.getParameter("del"));
		try {
			PreparedStatement pst = con.prepareStatement(cmd);
			pst.setInt(1, del);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				cmd = "delete from employ where empno = ?";
				pst = con.prepareStatement(cmd);
				pst.setInt(1, del);
				pst.executeUpdate();
				out.print("Employ Deleted");
			} else out.print("Employ not found");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
