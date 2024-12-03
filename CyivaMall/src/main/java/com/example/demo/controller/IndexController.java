package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class IndexController {
	@GetMapping("/")
	public String index() {
		log.info("index 컨트롤러 연결 성공");
		return "index";
	}
	
	@GetMapping("/admin")
	public String admin() {
		log.info("로그인 페이지 연결");
		return "adminLogin";
	}
}
