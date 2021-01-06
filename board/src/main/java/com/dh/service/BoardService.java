package com.dh.service;

import java.util.List;

import com.dh.entity.BoardDto;

public interface BoardService {

	//게시글 작성
	public void write(BoardDto boardDto) throws Exception;

	//게시글 목록
	public List<BoardDto> list() throws Exception;	

	//게시글 내용 조회
	public BoardDto read(int bno) throws Exception;

}

