package service.impl;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import Dao.InitationMApper;
import commons.MyBatisUtils;
import entity.Invitation;
import entity.Reply;
import service.InitationService;
import service.ReplyService;

public class InitationServiceImpl extends MyBatisUtils implements InitationService {
	private SqlSession sqlSession;
	// 创建一个操作回复表的接口对象
	private ReplyService rs = new ReplyServiceImpl();
	//查看相关帖子
	@Override
	public List<Invitation> getInvList() {
		sqlSession=createSqlSession();
		List<Invitation> list=sqlSession.getMapper(InitationMApper.class).getInvList();
		sqlSession.close();
		return list;
	}
	//模糊查询
	@Override
	public List<Invitation> findyByTitle(String title) {
		sqlSession=createSqlSession();
		List<Invitation> list=sqlSession.getMapper(InitationMApper.class).findyByTitle(title);
		sqlSession.close();
		return list;
	}
	//删除帖子
	@Override
	public boolean deleteInviById(int inviId) {
		sqlSession=createSqlSession();
		//获得该帖子的回复信息
		List<Reply> list=rs.getReplyList(inviId);
		//如果回复信息是空的
		if (list.isEmpty()) {
			//就直接删除帖子
			int num=sqlSession.getMapper(InitationMApper.class).deteleInvi(inviId);
			if (num>0) {
				sqlSession.commit();
				return true;
			}else {
				sqlSession.rollback();
			}
		}else {//如果帖子里有回复 先删除回复信息
			boolean rnum=rs.deleteRlay(inviId);
			if (rnum) {
				//再删除帖子
				int num=sqlSession.getMapper(InitationMApper.class).deteleInvi(inviId);
				if (num>0) {
					sqlSession.commit();
					return true;
				}else {
					sqlSession.rollback();
				}
			}
		}
		close(sqlSession);
		return false;
	}
	//获得数据总条数
	@Override
	public int getCount() {
		sqlSession=createSqlSession();
		int num=sqlSession.getMapper(InitationMApper.class).getCount();
		close(sqlSession);
		return num;
	}
	
	@Override
	public List getPageLists(int currPage, int pageSize) {
		sqlSession = MyBatisUtils.createSqlSession();
		List<Invitation> pageLists = sqlSession.getMapper(InitationMApper.class).getPageLists(currPage,pageSize);
		close(sqlSession);
		return pageLists;
	}
	
	
	

}
