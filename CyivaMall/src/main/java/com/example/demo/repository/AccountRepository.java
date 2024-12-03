package com.example.demo.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.AccountDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor

public class AccountRepository {

	private final SqlSessionTemplate sql;
	
	//로그인 시도,		이름이 있는지 조회
	public boolean tryAccountLogin(String n, String p) {
		AccountDTO account = sql.selectOne("Account.getAccount",n);
		boolean check = account.getPassword().equals(p);
		
		return check;
	}

}