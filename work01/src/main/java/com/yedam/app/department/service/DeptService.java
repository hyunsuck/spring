package com.yedam.app.department.service;

import java.util.List;
import java.util.Map;

public interface DeptService {
    // 전체 부서정보 조회
    public List<DeptVO> findAllList();

    // 부서정보 단건 조회
    public DeptVO findInfoById(DeptVO deptVO);

    // 부서정보 단건 등록
    public int createInfo(DeptVO deptVO);

    // 부서정보 단건 수정
    public Map<String, Object> modifyInfo(DeptVO deptVO);

    // 부서정보 단건 삭제
    public Map<String, Object> removeInfo(int deptId);
    
}
