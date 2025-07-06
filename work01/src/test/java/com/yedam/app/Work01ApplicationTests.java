package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.department.mapper.DeptMapper;
import com.yedam.app.department.service.DeptVO;

@SpringBootTest
class Work01ApplicationTests {

	@Autowired
	private DeptMapper deptMapper;

	@Test
	public void selectAll() {
		List<DeptVO> list = deptMapper.selectAll();
		for (DeptVO dept : list) {
			System.out.println(dept.getDepartmentName());
		}

		assertTrue(!list.isEmpty());
	}

	@Test
	public void selectOne() {
		DeptVO dept = DeptVO.builder().departmentId(10).build(); // departmentId 10인 부서 조회
		DeptVO findVO = deptMapper.selectInfo(dept);
		System.out.println(findVO);

		 assertEquals("Administration", findVO.getDepartmentName()); 
	}

	@Test
	public void insertSelectKey() {
		DeptVO dept = DeptVO.builder().departmentName("Administration")
					                  .managerId(200)
					                  .locationId(1700)
					                  .build();
		int result = deptMapper.insertInfo(dept);
		System.out.println("생성된 부서 번호: " + dept.getDepartmentId());
		assertEquals(1, result); // insertInfo 메서드가 1을 반환하면 성공
	}

}
