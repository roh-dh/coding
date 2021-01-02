package com.dh.dao;

import com.dh.entity.BoardDto;

public interface BoardDao {

	public void write(BoardDto boardDto) throws Exception;
}