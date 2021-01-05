package com.dh.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dh.entity.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao{

	@Inject
	private SqlSession sqlSession;
	
	@Override
	public void write(BoardDto boardDto) throws Exception {
		sqlSession.insert("board.insert",boardDto);
	}

	@Override
	public List<BoardDto> list() throws Exception {
		return sqlSession.selectList("board.list");
	}

	
}
