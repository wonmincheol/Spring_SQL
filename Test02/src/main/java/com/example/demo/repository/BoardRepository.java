package com.example.demo.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.BoardDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor

public class BoardRepository {

	private final SqlSessionTemplate sql;
	
	public List<BoardDTO> getList(){
		return sql.selectList("Board.getList");
	}
	
}
