package com.hcl.employ;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import javax.swing.tree.TreePath;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class EmploySearch {
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public void employSearch(){
		int empno;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Employ Number");
		empno = sc.nextInt();
		String cmd = "select * from employ where empno = ?";
		List emp = null;
		emp  = jdbcTemplate.query(cmd, new Object[]{empno}, new RowMapper() {
			
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				String res = rs.getInt("empno")+"\t"+
						rs.getString("name")+"\t"+
						rs.getString("dept")+"\t"+
						rs.getString("desig")+"\t"+
						rs.getInt("basic");
				return res;
			}
		});
		for(Object object : emp){
			System.out.println(object);
		}
	}
}
