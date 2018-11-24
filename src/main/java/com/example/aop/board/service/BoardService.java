package com.example.aop.board.service;

import com.example.aop.board.domain.Board;
import com.example.aop.board.domain.BoardPerformance;
import com.example.aop.board.domain.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService extends BoardPerformance {

	@Autowired
	private BoardRepository repository;

	@Override
	public List<Board> findAll() {
		return repository.findAll();
	}
}
