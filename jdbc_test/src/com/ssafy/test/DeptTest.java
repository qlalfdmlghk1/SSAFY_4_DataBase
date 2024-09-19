package com.ssafy.test;

import java.util.List;

import com.ssafy.model.entity.Dept;
import com.ssafy.model.service.DeptService;
import com.ssafy.model.service.DeptServiceImpl;

public class DeptTest {

	public static void main(String[] args) throws Exception {
		DeptService deptService = new DeptServiceImpl();
		
//		{
//			List<Dept> depts = deptService.getDepts();
//			for (Dept dept : depts) {
//				System.out.println(dept);
//			}
//		}
//		{
//			System.out.println("=========== 부서 상세조회(10) ===========");
//			System.out.println(deptService.getDept(10));
//		}
//		{
//			System.out.println("=========== 부서 등록 ===========");
//			deptService.registerDept(new Dept(50,"개발1팀", "서울"));
//		}
//		{
//			System.out.println("=========== 부서 등록 ===========");
//			deptService.registerDept(new Dept(60,"개발2팀", "경기"));
//		}
//		{
//			System.out.println("=========== 부서 등록 ===========");
//			deptService.registerDept(new Dept(11,"개발2팀", " 경기"));
//		}
//		{
//			System.out.println("=========== 부서 수정 ===========");
//			deptService.modifyDept(new Dept(99,"품질관리팀", "제주"));
//			System.out.println(deptService.getDept(99));
//		}
//		{
//			System.out.println("=========== 부서 삭제 ===========");
//			System.out.println(deptService.removeDept(11));
//		}
		
		
		{
			System.out.println("=====  부서명 포함 검색  =====");
			List<Dept> depts = deptService.getDepts("개발");
			for (Dept dept : depts) {
				System.out.println(dept);
			}
		}
	}
}
