package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ItemDTO;
import com.example.demo.repository.ItemRepository;

import lombok.RequiredArgsConstructor;





@Service
@RequiredArgsConstructor
public class ItemService {
	private final ItemRepository itemRepository;
	
	//상품 목록 조회
	public List<ItemDTO> getList(){
		return itemRepository.getList();
		
	}

	//상품 추가
	public void save(ItemDTO itemDTO) {
		itemRepository.save(itemDTO);
		
	}
	
	//상품 상세 내역 조회
	public ItemDTO detail(Integer id) {
		// TODO Auto-generated method stub
		return itemRepository.detail(id);
	}

	//상품 정보 삭제하기
	public void goDelete(Integer id) {
		itemRepository.goDelete(id);
	}
	//상품 정보 수정하기
	public void goUpdate(ItemDTO ItemDTO) {
		itemRepository.goUpdate(ItemDTO);
		
		
	}
	//상품 검색 목록
	public List<ItemDTO> getSerachList(String t) {
		// TODO Auto-generated method stub
		return itemRepository.getSearchList(t);
	}

	public List<ItemDTO> getSerachListManu(String t) {
		return itemRepository.getSearchListManu(t);
	}
	
}
