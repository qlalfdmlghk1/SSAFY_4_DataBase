package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.model.entity.Dept;
import com.ssafy.util.DBUtil;

public class DeptDAOImpl implements DeptDAO {

	@Override
	public boolean insertDept(Dept dept) throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "insert into dept(deptno, dname, loc) values(?,?,?)";
		try {
			// getConnection
			conn = DBUtil.getConnection();
			// create or prepare statement
			stmt = conn.prepareStatement(sql);
			// binding value(?)
			stmt.setInt(1, dept.getDeptno());
			stmt.setString(2, dept.getDname());
			stmt.setString(3, dept.getLoc());
			// execute sql
			return stmt.executeUpdate()>0;
		} finally {
			// release resources..
			DBUtil.close(stmt, conn);
		}
	}

	@Override
	public boolean updateDept(Dept dept) throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "update dept set dname=?, loc=? where deptno=?";
		try {
			// getConnection
			conn = DBUtil.getConnection();
			// create or prepare statement
			stmt = conn.prepareStatement(sql);
			// binding value(?)
			stmt.setInt(1, dept.getDeptno());
			stmt.setString(2, dept.getDname());
			stmt.setString(3, dept.getLoc());
			// execute sql
			return stmt.executeUpdate()>0;
		} finally {
			// release resources..
			DBUtil.close(stmt, conn);
		}
	}

	@Override
	public boolean deleteDept(int deptno) throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "delete from dept where deptno=?";
		try {
			// getConnection
			conn = DBUtil.getConnection();
			// create or prepare statement
			stmt = conn.prepareStatement(sql);
			// binding value(?)
			stmt.setInt(1, deptno);
			// execute sql
			return stmt.executeUpdate()>0;
		} finally {
			// release resources..
			DBUtil.close(stmt, conn);
		}
	}

	@Override
	public Dept selectDept(int deptno) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select deptno,dname,loc from dept where dname=?";
		try {
			// getConnection
			conn = DBUtil.getConnection();
			
			// create or prepare statement
			stmt = conn.prepareStatement(sql);
			
			// binding value(?)
			stmt.setInt(1, deptno);
			
			// execute sql
			rs = stmt.executeQuery();
			
			// handling resultSet
			if (rs.next()) {
				return new Dept(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} finally {
			// release resources..
			DBUtil.close(rs, stmt, conn);
		}
		return null;
	}

	@Override
	public List<Dept> selectDepts() throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select deptno, dname, loc from dept";
		List<Dept> list = new ArrayList<>();
		try {
			// getConnection
			conn = DBUtil.getConnection();
			// create or prepare statement
			stmt = conn.prepareStatement(sql);
			// execute sql
			rs = stmt.executeQuery();
			// handling resultSet
			while (rs.next()) {
				list.add(new Dept(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} finally {
			// release resources..
			DBUtil.close(rs, stmt, conn);
		}
		return list;
	}
	
	@Override
	public List<Dept> selectDepts(String dname) throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select deptno, dname, loc from dept where dname like ?";
//		String sql = "select deptno, dname, loc from dept where dname like concat('%', ? , '%')";
		List<Dept> list = new ArrayList<>();
		try {
			// getConnection
			conn = DBUtil.getConnection();
			// create or prepare statement
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + dname + "%");
			// execute sql
			rs = stmt.executeQuery();
			// handling resultSet
			while (rs.next()) {
				list.add(new Dept(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} finally {
			// release resources..
			DBUtil.close(rs, stmt, conn);
		}
		return list;
	}

}
