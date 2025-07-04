package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

import lombok.RequiredArgsConstructor;

@Controller // ( <= route와 같음 ) DispatherServlet 이 활용한 정보를 등록하는 Bean
// route : 사용자의 요청 (endpoint)와 그에 대한 처리 (ex : /api/products는 엔드포인트(endpoint) 라고 부르고, 이 엔드포인트에 사용자가 요청을 보냈다면, 그때 요청이 발생한 거)
// URI + HTTP METHOD (겟,포스트,풋,딜리트) => Service => Response(View or Data)

@RequiredArgsConstructor // final로 선언되있는걸 기준으로 생성자를 만들어줌 lombok 기반
public class EmpController {
	// 해당 컨트롤러에서 제공하는 서비스 목록
	private final EmpService empService; // final 로 생성된건 무조건 생성자 만들어짐
	
	// GET : 조회, 빈페이지, 데이터조작(삭제)
	// POST : 데이터조작(등록, 수정, 삭제)
	
	// 완전히 옛날방식임
	
	// 전체조회 : GET
	@GetMapping("empList") // 1) URI + METHOD
	public String empList(Model model) {
		// 2) 수행 기능 => Service : 돌려주는, 넘겨받는 데이터
		List<EmpVO> list = empService.findAllList(); // 조회결과 => list 에 담김
		// 2-1) View에 전달할 데이터 담기
		model.addAttribute("emps", list); // model => 화면에 데이터를 전달할때 사용
		// 3) 응답 형태 : View
		return "emp/list"; // classpath:/template/    emp/list     .html    페이지를 기능별로 모울려고 진행 emp가 폴더생성
//                                 (priefix)          (return)    (suffix)
	}
	
	// 단건조회 : GET => QueryString
	@GetMapping("empInfo")
	public String empInfo(EmpVO empVO, Model model) { // 1. empVO 쓰는이유 아래에서 요구함                   a 이 값(매개변수)이 들어오면
		EmpVO findVO = empService.findInfoById(empVO);// 2. findInfoById 가 요구하는것 : 객체이기때문에       b 이 기능들을 수행하고
		model.addAttribute("emp", findVO);      
		return "emp/info";//                                                                          c 이값을 돌려준다
	}
	
	// 등록 - 페이지 : GET
	@GetMapping("empinsert")
	public String empInsertForm() {
		
		return "emp/insert";
	}
	
	
	// 등록 - 처리 : POST (등록시 AJAX 잘안함 이유 중복저장 때문에) => 그래서 등록시 <form/> 태그에 sumbit 사용 폼태그는 제이슨 처리X / 인코딩 방식? QueryString 
	@PostMapping("empInsert")
	public String empInsertProcess(EmpVO empVO) {
		int eid = empService.createInfo(empVO);
		String url = null;
		if(eid > -1) {
			// 정상적으로 등록
			url = "redirect:empInfo?employeeId=" + eid; // 리다이렉트 걸어서 empInfo 로 넘김 empInfo 는 조건이 필요함. 조건 : 매개변수 중 EmpVO 필드 가 필요 
		}else {
			// 등록되지 않은 경우
			url = "redirect:empList";
		}
		
		return url;
	}
	
	
	// 수정 - 페이지 : GET <=> 단건조회     코드 거의같음
	@GetMapping("empUpdate")
	public String empUpdateForm(EmpVO empVO, Model model) {
		EmpVO findVO = empService.findInfoById(empVO);
		model.addAttribute("emp", findVO);      
		return "emp/update";
	}
	
	// 수정 - 처리 : POST + AJAX + JSON 기반으로 해서 처리
	@PostMapping("empUpdate")
	@ResponseBody // AJAX 를 이용해서 동작할수 있는 이노테이션  
	public Map<String, Object> empUpdateProcess(@RequestBody EmpVO empVO) {// @RequestBody => 사용자에게 받는건 JSON 포멧을 쓰겠다 선언
		return empService.modifyInfo(empVO);
	}
	
	// 삭제 - 처리 : GET => QueryString 방식으로 진행 :: 프라이머리 키만 넘겨주면 되니까 GET 인데 중요한 정보가 포함되어 있을경우 POST
	@GetMapping("empDelete")
	public String empDelete(Integer employeeId) {
		empService.removeInfo(employeeId);
		return "redirect:empList"; // 삭제를 했으니까 전체조회 페이지로 돌림 ( 삭재내역 사용자 에게 안보이게 하기위해 )
	}
	
}