package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardDTO {
	
	private int bookid;
	private String bookname;
	private String publisher;
	private int price;
	
}
