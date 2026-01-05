package com.example.demo.repository;

import java.io.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.AccountDTO;
import com.example.demo.dto.ItemDTO;
import com.example.demo.dto.transaction_historyDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor

public class AccountRepository {

	private final SqlSessionTemplate sql;
	
	//로그인 시도,		이름이 있는지 조회
	public AccountDTO tryAccountLogin(String n, String p) {
		AccountDTO account = sql.selectOne("Account.getAccount",n);
		
		
		
		return account;
	}
	
	// 사용자 마이페이지 데이터 조회(구매내역)
	public List<ItemDTO> getPurchaseList(int id) {
		return sql.selectList("Account.getPurchaseList",id);
	}
	// 사용자 상품 구매
	public void addPurchaseList(transaction_historyDTO his) {
		sql.insert("Account.addPurchase",his);
		
	}

	public void addAccount(AccountDTO data) {
		sql.insert("Account.addAccount",data);
	}

	public void deleteHistory(Integer id, int i) {
		
		Map<String, Object> params = new HashMap<>();
	    params.put("itemId", id);
	    params.put("userId", i);
		sql.delete("Account.deleteHistory", params);
		
	}

}
