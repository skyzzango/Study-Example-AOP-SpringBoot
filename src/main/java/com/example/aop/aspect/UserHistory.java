package com.example.aop.aspect;

import com.example.aop.history.domain.History;
import com.example.aop.history.domain.HistoryRepository;
import com.example.aop.user.domain.User;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component // @Bean과 동일하게 Spring Bean 등록 어노테이션
public class UserHistory {

	@Autowired
	private HistoryRepository historyRepository;

	@Pointcut("execution(* com.example.aop.user.service.UserService.update(*)) && args(user)")
	public void updateUser(User user){}

	@AfterReturning("updateUser(user)")
	public void saveHistory(User user){
		historyRepository.save(new History(user.getIdx()));
	}
}
