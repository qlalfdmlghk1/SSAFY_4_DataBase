package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List ;

import com.ssafy.model.entity.Dept;

public interface DeptService {
	
	// 부서 등록
	boolean registerDept(Dept dept) throws Exception;
	// 부서 수정
	boolean modifyDept(Dept dept) throws Exception;
	// 부서 삭제
	boolean removeDept(int deptno) throws Exception;
	// 부서 조회
	Dept getDept(int deptno) throws Exception;
	// 부서 목록 조회
	List<Dept> getDepts() throws Exception;
	
	// 부서 목록 조회
	List<Dept> getDepts(String dname) throws Exception;
}
