package service.impl;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import Dao.ReplyMapper;
import commons.MyBatisUtils;
import entity.Reply;
import service.ReplyService;
/**
 * @author Zylyyqx
 * 2020年4月4日
 */
public class ReplyServiceImpl extends MyBatisUtils implements ReplyService {

	SqlSession sqlSession;
	//查看相关帖的回复
	@Override
	public List<Reply> getReplyList(int inviId) {
		sqlSession=createSqlSession();
		List<Reply> list=sqlSession.getMapper(ReplyMapper.class).getReplyList(inviId);
		close(sqlSession);
		return list;
	}
	//添加回复
	@Override
	public boolean saveReply(Reply r) {
		sqlSession=createSqlSession();
		int num=sqlSession.getMapper(ReplyMapper.class).saveReply(r);
		if (num>0) {
			sqlSession.commit();
			return true;
		}
		close(sqlSession);
		return false;
	}
	@Override
	public boolean deleteRlay(int inviId) {
		sqlSession=createSqlSession();
		int num=sqlSession.getMapper(ReplyMapper.class).deleteRlay(inviId);
		if (num>0) {
			sqlSession.commit();
			return true;
		}
		close(sqlSession);
		return false;
	}

}
