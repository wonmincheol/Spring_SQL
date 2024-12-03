package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ItemDTO {
	
	private int id;					// 상품 식별자
	private String name;			// 상품 이름
	private int price;				// 상품 가격
	private String manufacturer;	// 상품 제조사
	private String exp;				// 상품 설명
	
}
