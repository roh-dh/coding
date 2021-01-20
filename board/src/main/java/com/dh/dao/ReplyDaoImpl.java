package com.dh.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dh.vo.ReplyVo;

@Repository
public class ReplyDaoImpl implements ReplyDao{

@Inject	
SqlSession sqlsession;

@Override
public List<ReplyVo> readReply(int bno) throws Exception {

	return sqlsession.selectList("reply.readReply", bno);
}

@Override
public void writeReply(ReplyVo replyVo) throws Exception {
	sqlsession.insert("reply.writeReply", replyVo);	
}

@Override
public void updateReply(ReplyVo replyVo) throws Exception {
	sqlsession.update("reply.updateReply", replyVo);
}

@Override
public void deleteReply(ReplyVo replyVo) throws Exception {
	sqlsession.delete("reply.deleteReply", replyVo);
}

@Override
public ReplyVo selectReply(int rno) throws Exception {
	return sqlsession.selectOne("reply.selectReply", rno);
}


	
}
