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

	@Override
	public void writeReply(ReplyVo replyVo) throws Exception {
		replyDao.writeReply(replyVo);
	}

	@Override
	public void updateReply(ReplyVo replyVo) throws Exception {
		replyDao.updateReply(replyVo);
	}

	@Override
	public void deleteReply(ReplyVo replyVo) throws Exception {
		replyDao.deleteReply(replyVo);
	}

	@Override
	public ReplyVo selectReply(int rno) throws Exception {
		return replyDao.selectReply(rno);
	}

	
	
}
