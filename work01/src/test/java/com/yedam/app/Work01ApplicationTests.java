package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.dept.service.DeptVO;

@SpringBootTest
class Work01ApplicationTests {

	 @Autowired // 필드주입 : 테스트용
	    private DeptMapper deptMapper;

	    @Test // 해당 메서드를 테스트하겠다고 선언!
	    public void selectAll() {
	        List<DeptVO> list = deptMapper.selectAll();
	        for(DeptVO dept : list) {
	            System.out.println(dept.getDepartmentName());
	        }
	        assertTrue(!list.isEmpty());
	    }

	    @Test
	    public void selectOne() {
	        DeptVO dept = DeptVO.builder() 
			        		.departmentId(10)
			                .build();

	        DeptVO findVO = deptMapper.selectInfo(dept);
	        System.out.println(findVO);
	        assertEquals("Administration", findVO.getDepartmentName()); 
	    }

	    @Test
	    public void insertSelectkey() {
	        DeptVO dept = DeptVO.builder()
	                .departmentName("IT Development")
	                .managerId(100)
	                .locationId(1700)
	                .build();
	        int result = deptMapper.insertInfo(dept);
	        System.out.println("부서번호 : " + dept.getDepartmentId());
	        assertEquals(1, result);
	    }

}