package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.AccountDTO;
import com.example.demo.service.AccountService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class AccountController {
	
	private final AccountService accountService;
	
	
	@GetMapping("/login")
	public String admin() {
		log.info("로그인 페이지 연결");
		return "adminLogin";
	}
	
	@PostMapping("/login")
	public String tryLogin(AccountDTO accountDTO) {
		log.info("로그인 시도");
		AccountDTO data = accountService.tryAccountLogin(accountDTO.getName(), accountDTO.getPassword());
		
		if(data==null) {
			//return "redirect:/adminLogin"; 
			return "adminLogin"; 
		}
		
		boolean loginCheck = data.getPassword().equals(accountDTO.getPassword());
		
		log.info(data.getName() +", "+data.getPassword());
		log.info(accountDTO.getName() +", "+accountDTO.getPassword());
		
		
		
		//로그인 성공시
		if(loginCheck == true) {
			log.info("로그인 성공");
			
			return "redirect:/adminPage"; 
		}
		else {
			log.info("로그인 실패");
			return "adminLogin"; 
		}
		
	}
	@GetMapping("/adminPage")
	public String adminPage() {
		log.info("제조사 페이지 호출");
		// 로그인 성공시
		// 로그인한 제조사의 이름에 맞게 상품 리스트 출력
		return "adminPage";
	}
	
	
}
