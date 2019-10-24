package com.hcl.employ;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

public class DataInsertDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void inserEmploy(){
		int empno,basic;
		String name,dept,desig;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Employ Number, name, dept, desig, basic");
		empno = sc.nextInt();
		name = sc.next();
		dept = sc.next();
		desig = sc.next();
		basic = sc.nextInt();
		String cmd = "insert into employ values(?,?,?,?,?)";
		jdbcTemplate.update(cmd,new Object[]{empno,name,dept,desig,basic});
	}
	
}
