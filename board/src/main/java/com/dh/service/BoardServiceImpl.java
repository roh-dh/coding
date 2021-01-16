package com.dh.service;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.dh.dao.BoardDao;
import com.dh.entity.BoardDto;
import com.dh.vo.CriteriaVo;
import com.dh.vo.SearchCriteria;

@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDao boardDao;
	
	@Override
	public void write(BoardDto boardDto) throws Exception {
		boardDao.write(boardDto);
	}

	@Override
	public BoardDto read(int bno) throws Exception {
		return boardDao.read(bno);
	}

	@Override
	public void update(BoardDto boardDto) throws Exception {
		boardDao.update(boardDto);
	}

	@Override
	public void delete(int bno) throws Exception {
		boardDao.delete(bno);
	}

	@Override
	public List<BoardDto> list(SearchCriteria scri) throws Exception {
		return boardDao.list(scri);
	}

	@Override
	public int listCount(SearchCriteria scri) throws Exception {
		return boardDao.ListCount(scri);
	}

	
}
