package com.yedam.app.book.mapper;

import java.util.List;

import com.yedam.app.book.service.BookRentVO;
import com.yedam.app.book.service.BookVO;

public interface BookMapper {
	public List<BookVO> selectAll();
	public int getMaxBookNo();
	public int insertInfo(BookVO bookVO);
	public List<BookRentVO> selectRendtAll();
}
