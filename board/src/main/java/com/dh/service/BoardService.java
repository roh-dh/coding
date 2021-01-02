package com.dh.service;

import com.dh.entity.BoardDto;

public interface BoardService {

	//게시글 작성
	public void write(BoardDto boardDto) throws Exception;
	
}
