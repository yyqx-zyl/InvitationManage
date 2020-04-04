package Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Invitation;

public interface InitationMApper {
	/**
	 * 查询所有
	 * @return
	 */
	List<Invitation> getInvList();
	/**
	 * 模糊查询
	 * @param title 页面输入的标题 
	 * @return 与标题相符合的数据集
	 */
	//带参  List<Invitation> findyByTitle(String title);
	//不带参
	List<Invitation> findyByTitle(@Param("title") String title);
	/**删除帖子
	 * @param inviId 帖子id
	 * @return 受影响的行数
	 */
	int deteleInvi(@Param("inviId") int inviId);
	/**总条数
	 * @return
	 */
	int getCount();
	/**
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	List<Invitation> getPageLists(@Param("from") int currPage,@Param("pageSize") int pageSize);
}
