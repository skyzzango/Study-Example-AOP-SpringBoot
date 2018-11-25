package com.example.aop.board.service;

import com.example.aop.board.domain.Board;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {

	List<Board> getBoards();
}
