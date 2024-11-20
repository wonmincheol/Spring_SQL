package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.BoardDTO;
import com.example.demo.service.BoardService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;
	//도서목록 조회
	@GetMapping("/list")
	public String getList(Model model) {
		List<BoardDTO> bookList = boardService.getList();
		model.addAttribute("bookList", bookList);
		return "bookList";
	}
	
	//도서추가(페이지 호출)
	@GetMapping("/addBook")
	public String addBook() {
		System.out.println("도서 추가 페이지 연결 성공");
		return "addBook";
	}
	
	//도서 추가(DB 저장)
	@PostMapping("/addBook")
	public void save(BoardDTO boardDTO) {
		boardService.save(boardDTO);
		
	}
	
	
	//도서 상세정보 가져오기
	@GetMapping("/{id}")
	public String detail(@PathVariable("id") Integer id, Model model) {
		BoardDTO boardDTO = boardService.detail(id);
		model.addAttribute("bookDetail", boardDTO);
		return "detailBook";
	}
	
	
	
	//도서 정보 삭제하기
	@GetMapping("/goDelete/{id}")
	public String goDelete(@PathVariable("id") Integer id) {
		boardService.goDelete(id);
		return "redirect:/list";
	}
	
	//도서 정보 수정하면 호출
	@GetMapping("/goUpdate/{id}")
	public String getMethodName(@PathVariable("id") Integer id, Model model) {
		BoardDTO boardDTO = boardService.detail(id);
		model.addAttribute("bookDetail", boardDTO);
		return "updateBook";
	}
	
	//도서 정보 수정하기
	@PostMapping("/goUpdate/{id}")
	public String goUpdate(BoardDTO boardDTO, Model model) {
		
		boardService.goUpdate(boardDTO);//update  요청 및 수행
		
		BoardDTO dto = boardService.detail(boardDTO.getBookid());
		
		model.addAttribute("bookDetail",dto);
		return "detailBook";
		
	}
	
	
	
	
	
	/*
	 * public String postMethodName(@RequestBody String entity) { //TODO: process
	 * POST request
	 * 
	 * return entity; }
	 */
	
	
}
