package com.ssafy.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.entity.Dept;

public interface DeptDAO {

	// 부서 등록
	boolean insertDept(Dept dept) throws SQLException;
	// 부서 수정
	boolean updateDept(Dept dept) throws SQLException;
	// 부서 삭제
	boolean deleteDept(int deptno) throws SQLException;
	// 부서 조회
	Dept selectDept(int deptno) throws SQLException;
	// 부서 목록 조회
	List<Dept> selectDepts() throws SQLException;
	
	// 부서 목록 조회2
	List<Dept> selectDepts(String dname) throws SQLException;
}

