package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	// 글쓰기
	public int write (BoardVo boardVo) {
		System.out.println("boardService:write");
		return boardDao.insert(boardVo);
	}
	
	// 게시글 수정
	public int modify(BoardVo boardVo) {
		System.out.println("boardService:modify");
		
		return boardDao.update(boardVo);
	}
}
