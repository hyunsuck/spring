package com.yedam.app.book.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookVO {
	private Integer bookNo;
	private String bookName;
	private String bookCovering;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date bookDate;
	private Integer bookPrice;
	private String bookPublisher;
	private String bookInfo;
}