package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AccountDTO;
import com.example.demo.repository.AccountRepository;

import lombok.RequiredArgsConstructor;





@Service
@RequiredArgsConstructor
public class AccountService {
	private final AccountRepository accountRepository;
	
	//관리자 로그인 시도
	public AccountDTO tryAccountLogin(String n, String p) {
		return accountRepository.tryAccountLogin(n,p);
	}

	
	
}
