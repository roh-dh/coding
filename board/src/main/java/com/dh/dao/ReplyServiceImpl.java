package com.dh.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.dh.vo.ReplyVo;

@Service
public class ReplyServiceImpl implements ReplyService {

@Inject
private ReplyDao replyDao;

	@Override
	public List<ReplyVo> readReply(int bno) throws Exception {
		return replyDao.readReply(bno);
	}

	
	
}
