package com.yedam.app.book.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yedam.app.book.mapper.BookMapper;
import com.yedam.app.book.service.BookRentVO;
import com.yedam.app.book.service.BookService;
import com.yedam.app.book.service.BookVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
	private final BookMapper bookMapper;
	
	@Override
	public List<BookVO> selectAll() {
		return bookMapper.selectAll();
	}
	
	@Override
	public int getLastBookNo() {
		return bookMapper.getMaxBookNo();
	}
	
	@Override
	public int createInfo(BookVO bookVO) {
		int result = bookMapper.insertInfo(bookVO);
		return result == 1 ? bookVO.getBookNo() : -1;
	}
	
	@Override
	public List<BookRentVO> selectRendtAll() {
		return bookMapper.selectRendtAll();
	}
}
