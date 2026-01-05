package com.example.demo.dto;


import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class transaction_historyDTO {
	
	int id;
	int itemId;
	LocalDateTime time;
	int userId;
	
}
