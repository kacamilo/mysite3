package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	@Autowired
	private SqlSession sqlSession;

	// 가입
	public int insert(UserVo userVo) {
		System.out.println("userDao:insert");
		int count = sqlSession.insert("user.insert", userVo);
		System.out.println(count);
		return count;
	}

	// 로그인
	public UserVo selectUser(UserVo userVo) {
		System.out.println("userDao:login");
		UserVo authUser = sqlSession.selectOne("user.selectUser", userVo);

		return authUser;
	}

	// 수정
	public int modify(UserVo userVo) {
		System.out.println("userDao:modify");
		return sqlSession.update("user.modify", userVo);
	}

	// 아이디값 받아오기
	public UserVo selectId(int no) {
		System.out.println("UserDao:selected");

		return sqlSession.selectOne("user.selectId", no);
	}

}
