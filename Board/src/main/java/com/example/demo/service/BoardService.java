package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.BoardDTO;
import com.example.demo.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;
	
	//도서 목록 조회
	public List<BoardDTO> getList(){
		return boardRepository.getList();
		
	}

	//도서 추가 (DB저장)
	public void save(BoardDTO boardDTO) {
		boardRepository.save(boardDTO);
	}
	
	//도서 상세정보 가져오기
	public BoardDTO detail(int id) {
		return boardRepository.detail(id);
	}

	//도서 정보 삭제하기
	public void goDelete(Integer id) {
		// TODO Auto-generated method stub
		boardRepository.goDelete(id);
	}
	//도서 정보 수정하기
	public void goUpdate(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		boardRepository.goUpdate(boardDTO);
		
		
	}
}
