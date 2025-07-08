package com.yedam.app.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.book.service.BookRentVO;
import com.yedam.app.book.service.BookService;
import com.yedam.app.book.service.BookVO;

@SpringBootTest
class BookServiceTest {
	@Autowired
	private BookService bookService;
	
	@Test
	void bookSelectAll() {
		List<BookVO> list = bookService.selectAll();
		for (BookVO bookVO : list) {
			System.out.println("  "+bookVO);
		}
		
		assertTrue(!list.isEmpty());
	}
	
	@Test
	void lastBookNo() {
		int num = bookService.getLastBookNo();
		System.out.println("  lastBookNumber = "+num);
		assertTrue(num != 0);
	}
	
	@Test
	void bookRentSelectAll() {
		List<BookRentVO> list = bookService.selectRendtAll();
		for (BookRentVO rentVO : list) {
			System.out.println("  "+rentVO);
		}
		
		assertTrue(!list.isEmpty());
	}
}
