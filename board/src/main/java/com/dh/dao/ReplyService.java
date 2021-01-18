package com.dh.dao;

import java.util.List;

import com.dh.vo.ReplyVo;

public interface ReplyService {

	public List<ReplyVo> readReply(int bno) throws Exception;
	
}
