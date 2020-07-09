package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.javaex.vo.BoardVo;

public class BoardDao {

	@Autowired
	private SqlSession sqlSession;
	
	//글쓰기
	public int insert (BoardVo boardVo) {
		System.out.println("boardDao:insert");
		int count = sqlSession.insert("board.insert", boardVo);
		System.out.println(count);
		return count;
	}
	
	//수정
	public int update(BoardVo boardVo) {
		return 0;
	}
	
	
	
	
	
	
	
//읽기
	
}
