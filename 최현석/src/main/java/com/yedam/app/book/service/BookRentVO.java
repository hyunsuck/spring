package com.yedam.app.book.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookRentVO {
	private Integer bookNo;
	private String bookName;
	private Integer sumRentPrice;
	private Integer countBookNo;
}
