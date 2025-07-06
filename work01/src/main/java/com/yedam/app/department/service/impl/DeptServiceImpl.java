package com.yedam.app.department.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.department.mapper.DeptMapper;
import com.yedam.app.department.service.DeptService;
import com.yedam.app.department.service.DeptVO;

@Service // 얘 까먹지 말기. 놓치기 쉬움.
public class DeptServiceImpl implements DeptService {
    private final DeptMapper deptMapper;
    
    @Autowired
    public DeptServiceImpl(DeptMapper deptMapper) {
        this.deptMapper = deptMapper;
    }

    @Override
    public List<DeptVO> findAllList() {
        return deptMapper.selectAll();
    }

    @Override
    public DeptVO findInfoById(DeptVO deptVO) {
        return deptMapper.selectInfo(deptVO);
    }

    @Override
    public int createInfo(DeptVO deptVO) {
        int result = deptMapper.insertInfo(deptVO);
        return result == 1 ? deptVO.getDepartmentId() : -1;
    }

    @Override
    public Map<String, Object> modifyInfo(DeptVO deptVO) {
        Map<String, Object> map = new HashMap<>();
        boolean isSuccessed = false;

        int result = deptMapper.updateInfo(deptVO.getDepartmentId(), deptVO);
        if (result == 1) {
            isSuccessed = true;
        }
        map.put("result", isSuccessed);
        map.put("target", deptVO);
        return map;
    }

    @Override
    public Map<String, Object> removeInfo(int deptId) {
        Map<String, Object> map = new HashMap<>();
        int result = deptMapper.deleteInfo(deptId);

        if (result == 1) {
            map.put("departmentId", deptId);
        }
        return map; 
    }

}
