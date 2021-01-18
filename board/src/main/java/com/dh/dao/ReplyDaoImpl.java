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


	
}
