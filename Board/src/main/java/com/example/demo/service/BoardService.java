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
	
}
