package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.ItemDTO;
import com.example.demo.service.ItemService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequiredArgsConstructor
public class ItemController {

	private final ItemService itemService;
	//상품목록 조회
	@GetMapping("/list")
	public String getList(Model model) {
	    List<ItemDTO> itemList = itemService.getList();
	    model.addAttribute("itemList", itemList);
	    return "itemList";
	}
	
	//상품 추가 페이지 호출
	@GetMapping("/addItem")
	public String addItem() {
		System.out.println("상품 추가 페이지 추가");
		return "addItem";
	}

	//상품 추가(DB 저장)
	@PostMapping("/addItem") 
	public void save(ItemDTO itemDTO) {
		itemService.save(itemDTO);
	 
	}
	
	//상품 상세정보 가져오기
	@GetMapping("/{id}") 
	public String detail(@PathVariable("id") Integer id, Model model, HttpSession session) { 
		ItemDTO itemDTO = itemService.detail(id);
		model.addAttribute("detailItem", itemDTO); 
		
		// 권한이 관리자인가? && 조회한 아이템의 제조사가 로그인한 제조사랑 동일한가?
		if(		session.getAttribute("auth").toString().equalsIgnoreCase("admin") 
				&& 
				session.getAttribute("user").toString().equalsIgnoreCase(itemDTO.getManufacturer())) 
		{
			//관리자 권한으로 로그인시
			return "detailItemAdmin";
		}
		else {
			//비 관리자 권한으로 로그인시
			return "detailItem"; 
				
		}
		
	}
	
	
	//상품 정보 삭제하기
	@GetMapping("/goDelete/{id}") 
	public String goDelete(@PathVariable("id") Integer id) {
		itemService.goDelete(id); 
		return "redirect:/list"; 
	}
	  
	//상품 정보 수정하면 호출
	@GetMapping("/goUpdate/{id}") 
	public String getMethodName(@PathVariable("id")	Integer id, Model model) { 
		ItemDTO itemDTO = itemService.detail(id);
		model.addAttribute("detailItem", itemDTO);
		return "updateItem"; 
	}
	  
	//상품 정보 수정하기
@PostMapping("/goUpdate/{id}") 
	public String goUpdate(ItemDTO itemDTO, Model model) {
	  
		itemService.goUpdate(itemDTO);//update 요청 및 수행
	  
		ItemDTO dto = itemService.detail(itemDTO.getId());
		  
		model.addAttribute("detailItem",dto); 
		return "detailItem";
		  
	}
	//상품 검색
	@GetMapping("/searchPage")
	public String goSerachPage(@RequestParam("t")	String t, Model model) {
		System.out.println("상품 검색 페이지");
		List<ItemDTO> itemList = itemService.getSerachList(t);
	    model.addAttribute("itemList", itemList);
		return "searchItem";
	}
	
	
	
}
