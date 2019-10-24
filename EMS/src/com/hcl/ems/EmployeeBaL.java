package com.hcl.ems;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EmployeeBaL {

	public static Employee showEmployeeBal(int emp_id) {
		return new EmloyeeDaO().showEmployee(emp_id);
	}
	
	public static List<LeaveHistory> leaveBal(int emp_id) {
		return new EmloyeeDaO().leaveDao(emp_id);
	}
	
	public static String applyLeaveBal(LeaveHistory obj) {
		String result = "Please Enter Start Date And End Date";
		if(obj.getLEA_START_DATE() != "" || obj.getLEA_END_DATE() != "") {
			result = "Please Enter The Reason";
			if(obj.getLEA_REASON() != "") {
				try {
					Connection con = DaoConnection.getConnection();
					String cmd = "select count(*) count from LEAVE_HISTORY where ? between LEA_START_DATE and  LEA_END_DATE AND EMP_ID=?";
					PreparedStatement pst = con.prepareStatement(cmd);
					pst.setString(1, obj.getLEA_START_DATE());
					pst.setInt(2, obj.getEMP_ID());
					ResultSet rs = pst.executeQuery();
					rs.next();
					int count = rs.getInt("count");
					
					Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(obj.getLEA_START_DATE());
					Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(obj.getLEA_END_DATE());
					SimpleDateFormat formatt = new SimpleDateFormat("yyyy-MM-dd");
					Date date = new Date();
					date = new SimpleDateFormat("yyyy-MM-dd").parse(formatt.format(date));
					if(date.compareTo(date1)>0){
						result =  "You Cannot Use Previous Date";
					}
					else if (date1.compareTo(date2)>0){
						result = "Start Date Cannot be Greater Than end Date";	
					}
					else if(count>0){
						result = " Already Applied";
					}
					
					else{
						result = new EmloyeeDaO().applyLeaveDao(obj);
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
		
	}
}
