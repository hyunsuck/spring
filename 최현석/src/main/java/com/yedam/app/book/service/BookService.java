package com.yedam.app.book.service;

import java.util.List;

public interface BookService {
	public List<BookVO> selectAll();
	public int getLastBookNo();
	public int createInfo(BookVO bookVO);
	public List<BookRentVO> selectRendtAll();
}
