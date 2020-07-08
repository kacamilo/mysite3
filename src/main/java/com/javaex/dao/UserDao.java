package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	@Autowired
	private SqlSession sqlSession;
	public int insert(UserVo userVo) {
		System.out.println("userDao:insert");
		int count  = sqlSession.insert("user.insert", userVo);
		System.out.println(count);
		return count;
	}
	
	
	public UserVo selectUser(UserVo userVo) {
		System.out.println("userDao:login");
		UserVo authUser = sqlSession.selectOne("user.selectUser", userVo);
		
		return authUser;
		
	}

}
