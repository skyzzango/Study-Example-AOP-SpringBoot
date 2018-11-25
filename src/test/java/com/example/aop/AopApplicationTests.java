package com.example.aop;

import com.example.aop.board.service.BoardService;
import com.example.aop.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AopApplicationTests {

	@Autowired
	private BoardService boardService;

	@Autowired
	private UserService userService;

	@Test
	public void findBoards() throws Exception {
		assertThat(boardService.getBoards().size()).isEqualTo(100);
	}

	@Test
	public void findUsers() throws Exception {
		assertThat(userService.getUsers().size()).isEqualTo(100);
	}
}
