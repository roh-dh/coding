package com.dh.dao;

import java.util.List;

import com.dh.entity.BoardDto;

public interface BoardDao {
	
	//게시글 작성
	public void write(BoardDto boardDto) throws Exception;
	
	//게시글 목록
	public List<BoardDto> list() throws Exception;
}