package com.dh.dao;

import java.util.List;

import com.dh.vo.ReplyVo;

public interface ReplyDao {

	public List<ReplyVo> readReply(int bno) throws Exception;
		
}
