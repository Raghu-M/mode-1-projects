package com.hcl.employ;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.swing.tree.TreePath;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployShowController {

	@RequestMapping("/employshow")
	public ModelAndView showEmp() {
		ApplicationContext ctx=new
		ClassPathXmlApplicationContext("ApplicationContext.xml");
		DataSource dataSource=
		(DriverManagerDataSource)ctx.getBean("dataSource");
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		String sql="select * from employ";
		List emps=null;
		emps=jt.query(sql,new RowMapper() {
			
			
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				String empInfo=rs.getInt("empno")+"----"+
							rs.getString("name") +"----"+
						    rs.getString("dept") +"----"+
							rs.getString("desig")+"----"+
						    rs.getString("basic");
				return empInfo;
			}
		});
		return (new ModelAndView("ShowPage","emps",emps));
	}
	
	@RequestMapping("/empSearch")
	public ModelAndView empSearch(HttpServletRequest req, HttpServletResponse res){
		int empno = Integer.parseInt(req.getParameter("empno"));
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		DataSource dataSource = (DriverManagerDataSource)ctx.getBean("dataSource");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select * from Employ where empno=?";
		List emps = null;
		emps = jdbcTemplate.query(sql, new Object[]{empno}, new RowMapper() {

			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				String empInfo=rs.getInt("empno")+"----"+
						rs.getString("name") +"----"+
					    rs.getString("dept") +"----"+
						rs.getString("desig")+"----"+
					    rs.getString("basic");
				return empInfo;
			
			}
		});
		return (new ModelAndView("ShowPage","emps",emps));
	}
	
	
	@RequestMapping("/empInsert")
	public ModelAndView empInsert(HttpServletRequest req, HttpServletResponse res) {
		ApplicationContext ctx=new
		ClassPathXmlApplicationContext("ApplicationContext.xml");
		DataSource dataSource=
		(DriverManagerDataSource)ctx.getBean("dataSource");
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		String sql="insert into employ values(?,?,?,?,?)";
		jt.update(sql,new  Object[]{
			req.getParameter("empno"),
			req.getParameter("name"),
			req.getParameter("dept"),
			req.getParameter("desig"),
			req.getParameter("basic")
			
		});
		return (new ModelAndView("Message","Message","Employ Inserted"));
	}
}
