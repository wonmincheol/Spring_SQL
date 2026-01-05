package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AccountDTO;
import com.example.demo.dto.ItemDTO;
import com.example.demo.dto.transaction_historyDTO;
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
	public List<ItemDTO> getPurchaseList(int id){
		return accountRepository.getPurchaseList(id);
	}
	public void addPurchaseList(transaction_historyDTO his) {
		accountRepository.addPurchaseList(his);
		
	}
	public void addAccount(AccountDTO data) {
		accountRepository.addAccount(data);
		
	}
	public void deleteHistory(Integer id, int i) {
		accountRepository.deleteHistory(id,i);
		
	}
	
	
}
