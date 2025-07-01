package com.yedam.app.dept.mapper;

import java.util.List;

import com.yedam.app.dept.service.DeptVO;

public interface DeptMapper {
	// Mapper 골격
	// 전체조회
	public List<DeptVO> selectAll();
	
	// 단건조회
	public DeptVO selectInfo(DeptVO deptVO);
	
	// 등록
	public int insertInfo(DeptVO deptVO);
}
