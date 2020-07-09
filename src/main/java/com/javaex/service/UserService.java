package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	// UserDao를 불러올거야
	@Autowired
	private UserDao userDao;

	// 회원가입
	public int join(UserVo userVo) {
		System.out.println("userService:join");

		return userDao.insert(userVo);

	}

	// 로그인
	public UserVo login(UserVo userVo) {
		System.out.println("userService:login");

		UserVo authUser = userDao.selectUser(userVo);

		return authUser;
		// 줄여서 쓴다면 return userDao.selectUser(userVo)
	}
	
	//리스트
	public UserVo List (UserVo userVo) {
		userVo.getId();
		userVo.getName();
		
		return userVo ;
	}
	

	// 회원수정
	public int modify(UserVo userVo) {
		System.out.println("userService:modify");
		
		return userDao.update(userVo);
	}

	
	// 로그아웃
	public UserVo logout(UserVo userVo) {
		System.out.println("userService:logout");

		UserVo authUser = userDao.selectUser(userVo);
		return authUser;
	}
	
}
