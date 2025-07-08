package com.yedam.app.book.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.book.service.BookRentVO;
import com.yedam.app.book.service.BookService;
import com.yedam.app.book.service.BookVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookController {
	private final BookService bookService;
	
	@GetMapping("bookList")
	public String bookList(Model model) {
		List<BookVO> list = bookService.selectAll();
		model.addAttribute("books", list);
		
		return "book/list";
	}
	
	@GetMapping("bookInsert")
	public String bookInsertForm(Model model) {
		int lastNum = bookService.getLastBookNo() + 1;
		model.addAttribute("bno", lastNum);
		
		return "book/insert";
	}
	
	@PostMapping("bookInsert")
	public String bookInsertProcess(BookVO bookVO) {
		System.out.println(bookVO);
		bookService.createInfo(bookVO);
		
		return "redirect:bookList";
	}
	
	@GetMapping("rentList")
	public String bookRentList(Model model) {
		List<BookRentVO> list = bookService.selectRendtAll();
		model.addAttribute("rents", list);
		
		return "book/rent/List";
	}
}
