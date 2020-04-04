package Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Reply;

/**
 * @author Zylyyqx
 * 2020年4月4日
 */
public interface ReplyMapper {

	/**获取到当前帖子的回复信息
	 * @param inviId 帖子id
	 * @return 回复信息集合
	 */
	List<Reply> getReplyList(@Param("inviId") int inviId);

	/**添加回复
	 * @param r 回复信息
	 * @return 受影响的行数
	 */
	int saveReply(Reply r);
	/**删除相关帖子的回复信息
	 * @param inviId 帖子id
	 * @return 受影响行数
	 */
	int deleteRlay(@Param("inviId") int inviId);

}
