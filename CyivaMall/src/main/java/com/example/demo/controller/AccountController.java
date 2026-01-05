package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.AccountDTO;
import com.example.demo.dto.ItemDTO;
import com.example.demo.dto.transaction_historyDTO;
import com.example.demo.service.AccountService;
import com.example.demo.service.ItemService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class AccountController {
	
	private final AccountService accountService;
	private final ItemService itemService;
	
	@GetMapping("/login")
	public String admin() {
		log.info("로그인 페이지 연결");
		return "adminLogin";
	}
	
	@PostMapping("/login")
	public String tryLogin(AccountDTO accountDTO, HttpSession session) {
		log.info("로그인 시도");
		AccountDTO data = accountService.tryAccountLogin(accountDTO.getName(), accountDTO.getPassword());
		
		//아이디가 같은 계정이 없는 경우
		if(data==null) {
			//return "redirect:/adminLogin"; 
			return "adminLogin"; 
		}
		
		//로그인 데이터가 알맞는지 확인
		boolean loginCheck = data.getPassword().equals(accountDTO.getPassword());
		
		/*
		 * log.info(data.getName() +", "+data.getPassword());
		 * log.info(accountDTO.getName() +", "+accountDTO.getPassword());
		 */
		
		
		//로그인 성공시
		if(loginCheck == true) {
			log.info("로그인 성공");
			session.setAttribute("auth", data.getAuth());
			session.setAttribute("user", data.getName());
			session.setAttribute("id", data.getId());
			//관리자 로그인 할경우 관리자 페이지로 이동
			if((session.getAttribute("auth")).toString().equalsIgnoreCase("admin")) {
				return "redirect:/adminPage"; 				
			}
			//사용자 로그인 할경우 마이페이지로 이동
			else {
				return "redirect:/myPage";
			}
			
		}
		else {
			log.info("로그인 실패");
			return "adminLogin"; 
		}
		
	}
	@GetMapping("/adminPage")
	public String adminPage(HttpSession session, Model model) {
		//관리자로 로그인시
		if((session.getAttribute("auth")).toString().equals("admin")) {
			log.info("제조사 페이지 호출");
			// 로그인 성공시
			// 로그인한 제조사의 이름에 맞게 상품 리스트 출력
			
			List<ItemDTO> itemList = itemService.getSerachListManu((session.getAttribute("user")).toString());
			model.addAttribute("itemList", itemList);
			
			return "adminPage";
		}
		else {
			log.info("유저로그인");
			return "redirect:/myPage"; 
		}
	}
	
	//마이페이지 로드시
	@GetMapping("/myPage")
	public String userPage(HttpSession session, Model model) {
		
		//관리자 페이지 로드
		if((session.getAttribute("auth")).equals("admin")) {
			return "redirect:/adminPage";
		}
		
		//사용자 마이페이지 로드
		log.info("유저 로그인 성공, 마이페이지로 이동합니다.");
		List<ItemDTO> itemList = accountService.getPurchaseList((int)(session.getAttribute("id")));
		log.info("data : in : "+(int)(session.getAttribute("id")));
		for (ItemDTO itemDTO : itemList) {
			log.info("data : "+itemDTO);
		}
		log.info("data : out : "+itemList.size());
		model.addAttribute("historyList",itemList);
		model.addAttribute("name", (String)(session.getAttribute("user")));
		return "userPage";
	}
	//구매 버튼 입력시
	@GetMapping("/goPurchase/{id}")
	public String goPurchase(HttpSession session, @PathVariable("id") Integer id) {
		
		transaction_historyDTO his=new transaction_historyDTO();
		his.setItemId(id);
		his.setUserId((int)(session.getAttribute("id")));
		
		accountService.addPurchaseList(his);
		
		return "redirect:/list";
	}
	
	
	//회원가입
	@GetMapping("/addAccount")
	public String addAccount() {
		
		return "addAccount";
	}
	
	//회원가입 진행
	@PostMapping("/addAccount")
	public String addAccounting(AccountDTO accountDTO) {
		
		accountService.addAccount(accountDTO);
		return "redirect:/";
	}
	
	@GetMapping("/historyDelete/{id}")
	public String historyDelete(HttpSession session, @PathVariable("id") Integer id) {
		accountService.deleteHistory(id,(int)(session.getAttribute("id")));
		return "redirect:/myPage";
	}
}
