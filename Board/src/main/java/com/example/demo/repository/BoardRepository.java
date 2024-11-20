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

	public void save(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		sql.insert("Board.save", boardDTO);
	}

	//도서 상세정보 가져오기
	public BoardDTO detail(int id) {
		// TODO Auto-generated method stub
		return sql.selectOne("Board.detail",id);
	}

	//도서 정보 삭제하기
	public void goDelete(Integer id) {
		// TODO Auto-generated method stub
		sql.delete("Board.goDelete",id);
		
	}
	public void goUpdate(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		sql.update("Board.goUpdate", boardDTO);
		
	}
}
