package com.yedam.app.department.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder // Lombok의 @Builder 어노테이션을 사용하여 빌더 패턴을 적용
@AllArgsConstructor // Lombok의 @AllArgsConstructor 어노테이션을 사용하여 모든 필드를 매개변수로 받는 생성자를 생성
@NoArgsConstructor // Lombok의 @NoArgsConstructor 어노테이션을 사용하여 기본 생성자를 생성
public class DeptVO {
    private Integer departmentId;
    private String departmentName;
    private Integer managerId;
    private Integer locationId;
}