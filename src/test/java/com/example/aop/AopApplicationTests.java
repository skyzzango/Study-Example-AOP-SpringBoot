package com.example.aop;

import com.example.aop.board.service.BoardService;
import com.example.aop.history.domain.History;
import com.example.aop.history.domain.HistoryRepository;
import com.example.aop.user.domain.User;
import com.example.aop.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AopApplicationTests {

	@Autowired
	private BoardService boardService;

	@Autowired
	private UserService userService;

	@Autowired
	private HistoryRepository historyRepository;

	@Test
	public void findBoards() throws Exception {
		assertThat(boardService.getBoards().size()).isEqualTo(100);
	}

	@Test
	public void findUsers() throws Exception {
		assertThat(userService.getUsers().size()).isEqualTo(100);
	}

	@Test
	public void updateUsers() throws Exception {
		List<User> users = userService.getUsers();
		users.forEach(System.out::println);
		for (int i = 0; i < 5; i++) {
			User user = users.get(i);
			user.setEmail("jojoldu@gmail.com");
			userService.update(user);
		}

		List<History> histories = historyRepository.findAll();
		histories.forEach(System.out::println);
		assertThat(histories.size()).isEqualTo(5);
		assertThat(histories.get(0).getUserIdx()).isEqualTo(1L);
		assertThat(histories.get(1).getUserIdx()).isEqualTo(2L);
	}
}
