package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountDTO {
	
	private int id;					// 관리자 식별자(id)
	private String name;			// 관리자 이름
	private String password;		// 관리자 비밀번호
	private String auth;			// 관리자 권한(admin or user)
	
}
