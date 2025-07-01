package com.yedam.app.dept.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor // @Builder 시 생략되므로 명시적으로 추가
public class DeptVO {
	// employee_id => employeeId => setEmployeeId
	private Integer departmentId;
	private String departmentName;
	private Integer managerId;
	private Integer locationId;

	
}
 