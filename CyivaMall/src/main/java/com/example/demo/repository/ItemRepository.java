package com.example.demo.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.ItemDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor

public class ItemRepository {

	private final SqlSessionTemplate sql;
	
	//상품 목록 조회
	public List<ItemDTO> getList(){
		return sql.selectList("Item.getList");
	}
	
	//상품 추가
	public void save(ItemDTO itemDTO) {
		sql.insert("Item.save", itemDTO);
		
	}

	//상품 상세 내역 조회
	public ItemDTO detail(Integer id) {
		return sql.selectOne("Item.detail",id);
	}



	//상품 정보 삭제하기
	public void goDelete(Integer id) {
		// TODO Auto-generated method stub
		sql.delete("Item.goDelete",id);
		
	}
	//상품 수정
	public void goUpdate(ItemDTO ItemDTO) {
		// TODO Auto-generated method stub
		sql.update("Item.goUpdate", ItemDTO);
		
	}
	//상품 검색 목록 
	public List<ItemDTO> getSearchList(String t) {
		// TODO Auto-generated method stub
		return sql.selectList("Item.searchItem",t);
	}

	public List<ItemDTO> getSearchListManu(String t) {
		// TODO Auto-generated method stub
		return sql.selectList("Item.searchItemManu",t);
	}
	
	
	
}
