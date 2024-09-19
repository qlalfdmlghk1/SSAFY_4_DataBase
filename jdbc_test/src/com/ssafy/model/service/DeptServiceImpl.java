package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dao.DeptDAO;
import com.ssafy.model.dao.DeptDAOImpl;
import com.ssafy.model.entity.Dept;

public class DeptServiceImpl implements DeptService {
	
	private DeptDAO deptDao = new DeptDAOImpl();

	@Override
	public boolean registerDept(Dept dept) throws Exception {
		if (getDept(dept.getDeptno()) != null) return false;
		return deptDao.insertDept(dept);
	}

	@Override
	public boolean modifyDept(Dept dept) throws Exception{
		if (getDept(dept.getDeptno()) == null) throw new IllegalArgumentException("부서정보가 존재하지 않습니다.");
		return deptDao.updateDept(dept);
	}

	@Override
	public boolean removeDept(int deptno) throws Exception{
		return deptDao.deleteDept(deptno);
	}

	@Override
	public Dept getDept(int deptno) throws Exception{
		return deptDao.selectDept(deptno);
	}

	@Override
	public List<Dept> getDepts() throws Exception{
		return deptDao.selectDepts();
	}
	
	@Override
	public List<Dept> getDepts(String dname) throws Exception{
		return deptDao.selectDepts(dname);
	}

}
