package com.hcl.ems;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EmloyeeDaO {
	
	public Employee showEmployee(int emp_id) {
		Connection con = DaoConnection.getConnection();
		Employee obj = null;
		String cmd = "select * from employee where emp_id = ?";
		try {
			PreparedStatement pst = con.prepareStatement(cmd);
			pst.setInt(1, emp_id);
			ResultSet rs = pst.executeQuery();
			rs.next();
			obj = new Employee();
			obj.setEmp_id(rs.getInt("emp_id"));
			obj.setEmp_name(rs.getString("emp_name"));
			obj.setEmp_email(rs.getString("emp_email"));
			obj.setEmp_mob_no(rs.getLong("emp_mob_no"));
			obj.setEmp_dpt_name(rs.getString("emp_dpt_name"));
			obj.setEmp_date_joined(rs.getString("emp_date_joined"));
			obj.setEmp_mgr_id(rs.getInt("emp_mgr_id"));
			obj.setEmp_leave_balance(rs.getInt("emp_leave_balance"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
	public List<LeaveHistory> leaveDao(int emp_id) {
		Connection con = DaoConnection.getConnection();
		List<LeaveHistory> lst = null;
		LeaveHistory obj = null;
		String cmd = "select * from LEAVE_HISTORY where emp_id = ? order by LEA_ID desc";
		try {
			PreparedStatement pst = con.prepareStatement(cmd);
			pst.setInt(1, emp_id);
			ResultSet rs = pst.executeQuery();
			lst = new ArrayList<LeaveHistory>();
			while(rs.next()){
				obj = new LeaveHistory();	
				obj.setLEA_ID(rs.getInt("LEA_ID"));
				obj.setLEA_NO_OF_DAYS(rs.getInt("LEA_NO_OF_DAYS"));
				obj.setLEA_START_DATE(rs.getString("LEA_START_DATE"));
				obj.setLEA_END_DATE(rs.getString("LEA_END_DATE"));
				obj.setLEA_TYPE(rs.getString("LEA_TYPE"));
				obj.setLEA_STATUS(rs.getString("LEA_STATUS"));
				obj.setLEA_REASON(rs.getString("LEA_REASON"));
				obj.setLEA_APPLIED_ON(rs.getString("LEA_APPLIED_ON"));
				obj.setLEA_MGR_COMMENTS(rs.getString("LEA_MGR_COMMENTS"));
				lst.add(obj);
			}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return lst;
	
	}
	
	public String applyLeaveDao(LeaveHistory obj){
		Connection con = DaoConnection.getConnection();
		String cmd = "select EMP_LEAVE_BALANCE from EMPLOYEE where EMP_ID=?";
		
		
		try {
			PreparedStatement pst = con.prepareStatement(cmd);
			pst.setInt(1, obj.getEMP_ID());
			ResultSet rs = pst.executeQuery();
			rs.next(); int leaveno = rs.getInt("EMP_LEAVE_BALANCE");
			
			cmd = "insert into LEAVE_HISTORY (LEA_START_DATE, LEA_END_DATE, LEA_NO_OF_DAYS, LEA_REASON, LEA_TYPE, EMP_ID, LEA_STATUS,"
					+ " LEA_MGR_COMMENTS) values(?,?,?,?,?,?,?,?)";
			Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(obj.getLEA_START_DATE());
			Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(obj.getLEA_END_DATE());
			Calendar c = Calendar.getInstance();
			c.setTime(date1);
			if(c.get(Calendar.DAY_OF_WEEK)== Calendar.SATURDAY ){
				return "You Cannot Apply Holiday on SATURDAY";
			}
			if(c.get(Calendar.DAY_OF_WEEK)== Calendar.SUNDAY ){
				return "You Cannot Apply Holiday on SUNDAY";
			}
			int count =1;
			while(date1.compareTo(date2)!=0){
			c.setTime(date1);
			c.get(Calendar.DAY_OF_WEEK);
			c.add(Calendar.DATE,1 );
			
			if(c.get(Calendar.DAY_OF_WEEK)!= Calendar.SATURDAY && c.get(Calendar.DAY_OF_WEEK)!= Calendar.SUNDAY ){
				count++;
			}
			date1 = c.getTime();
			}
			if(leaveno<count){
				return "leave balance is lesser than applied leave";
			}
			pst = con.prepareStatement(cmd);
			pst.setString(1, obj.getLEA_START_DATE());
			pst.setString(2, obj.getLEA_END_DATE());
			pst.setInt(3, count);
			pst.setString(4, obj.getLEA_REASON());
			pst.setString(5, obj.getLEA_TYPE());
			pst.setInt(6, obj.getEMP_ID());
			pst.setString(7, obj.getLEA_STATUS());
			pst.setString(8, obj.getLEA_MGR_COMMENTS());
			pst.executeUpdate();
			cmd="update employee set EMP_LEAVE_BALANCE=EMP_LEAVE_BALANCE-? where emp_id=?";
			pst=con.prepareStatement(cmd);
			pst.setInt(1, count);
			pst.setInt(2, obj.getEMP_ID());
			pst.executeUpdate();
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Leave Applied Successfully";
		
	}

}
