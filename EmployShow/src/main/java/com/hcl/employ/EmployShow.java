package com.hcl.employ;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class EmployShow {
	 private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public void showEmploy(){
		String cmd="select * from employ";
		List emp =null;
		emp = jdbcTemplate.query(cmd, new RowMapper() {
			
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				String res = rs.getInt("empno")+"\t"+
						rs.getString("name")+"\t\t\t\t"+
						rs.getString("dept")+"\t\t"+
						rs.getString("desig")+"\t\t"+
						rs.getInt("basic");
				return res;
			}
		});
		for(Object object : emp){
			System.out.println(object);
		}
	}
}
