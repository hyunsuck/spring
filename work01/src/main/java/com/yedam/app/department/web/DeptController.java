package com.yedam.app.department.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.department.service.DeptService;
import com.yedam.app.department.service.DeptVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DeptController {
    private final DeptService deptService;
    
    // 전체 조회
    @GetMapping("deptList")
    public String deptList(Model model) {
        List<DeptVO> list = deptService.findAllList();
        model.addAttribute("depts", list);
        return "dept/list";
    }

    // 단건 조회
    @GetMapping("deptInfo")
    public String deptInfo(DeptVO deptVO, Model model) {
        DeptVO result = deptService.findInfoById(deptVO);
        model.addAttribute("dept", result);
        return "dept/info";
    }

    // 등록 페이지
    @GetMapping("deptInsert")
    public String deptInsert() {
        return "dept/insert"; // view 이름 반환
    }

    // 등록 처리
    @PostMapping("deptInsert")
    public String deptInsertProcess(DeptVO deptVO) {
        int deptId = deptService.createInfo(deptVO);
        if (deptId > -1) {
            return "redirect:deptInfo?deptId=" + deptId; // 등록 후 해당 부서 정보 페이지로 리다이렉트
        }
        return "redirect:deptList"; // 등록 실패 시 목록으로 리다이렉트
    }

    // 수정 페이지
    @GetMapping("deptUpdate")
    public String deptUpdate(DeptVO deptVO, Model model) {
        DeptVO result = deptService.findInfoById(deptVO);
        model.addAttribute("dept", result);
        return "dept/update";
    }

    // 수정 처리
    @PostMapping("deptUpdate")
    public Map<String, Object> deptUpdateProcess(DeptVO deptVO) {
        return deptService.modifyInfo(deptVO);
    }

    // 삭제
    @GetMapping("deptDelete")
    public String deptDelete(Integer deptId) {
        deptService.removeInfo(deptId);
        return "redirect:deptList";
    }
}
