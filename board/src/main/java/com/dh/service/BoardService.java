package com.dh.service;

import java.util.List;

import com.dh.entity.BoardDto;
import com.dh.vo.CriteriaVo;

public interface BoardService {

	//게시글 작성
	public void write(BoardDto boardDto) throws Exception;

	//게시글 목록
	public List<BoardDto> list(CriteriaVo cri) throws Exception;	

	//게시물 총갯수
	public int listCount() throws Exception;
	
	//게시글 내용 조회
	public BoardDto read(int bno) throws Exception;

	//게시글 수정
	public void update(BoardDto boardDto) throws Exception;
	
	//게시글 삭제
	public void delete(int bno) throws Exception;
}

