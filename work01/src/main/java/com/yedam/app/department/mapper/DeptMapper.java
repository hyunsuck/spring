package com.yedam.app.department.mapper;

import java.util.List;

import com.yedam.app.department.service.DeptVO;

public interface DeptMapper {
    // Mapper 골격
    // 전체 조회
    public List<DeptVO> selectAll();

    // 단건 조회
    public DeptVO selectInfo(DeptVO deptVO);

    // 등록
    public int insertInfo(DeptVO deptVO);

    // 수정
    public int updateInfo(int deptId, DeptVO deptVO);

    // 삭제
    public int deleteInfo(int deptId);
}
