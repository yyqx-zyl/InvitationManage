package service;

import java.util.List;
import entity.Invitation;

public interface InitationService {
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
	List<Invitation> findyByTitle(String title);
	/**删除指定id的帖子
	 * @param inviId 帖子id
	 * @return 受影响的行数
	 */
	boolean deleteInviById(int inviId);
	/**获得数据总条数
	 * @return 
	 */
	int getCount();
	/**获得分页的数据
	 * @param from 当前页
	 * @param pageSize 每页的数据条数
	 * @return
	 */
	List getPageLists(int from, int pageSize);
}
