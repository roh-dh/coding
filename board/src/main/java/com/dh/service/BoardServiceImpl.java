package com.dh.service;


import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.dh.dao.BoardDao;
import com.dh.entity.BoardDto;

@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDao boardDao;
	
	@Override
	public void write(BoardDto boardDto) throws Exception {
		boardDao.write(boardDto);
	}

}
