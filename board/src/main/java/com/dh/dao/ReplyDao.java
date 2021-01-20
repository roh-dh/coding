package com.dh.dao;

import java.util.List;

import com.dh.vo.ReplyVo;

public interface ReplyDao {
	
	//댓글 목록 조회
	public List<ReplyVo> readReply(int bno) throws Exception;
	
	//댓글 등록
	public void writeReply(ReplyVo replyVo) throws Exception;
	
	//댓글 수정
	public void updateReply(ReplyVo replyVo) throws Exception;
	
	//댓글삭제
	public void deleteReply(ReplyVo replyVo) throws Exception;
	
	//선택된 댓글 조회
	public ReplyVo selectReply(int rno) throws Exception;
}
