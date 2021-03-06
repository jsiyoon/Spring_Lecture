package org.zerock.mapper.project1;

import java.util.List;

import org.zerock.domain.project1.ReplyVO;

public interface ReplyMapper {
	public List<ReplyVO> list(Integer boardId);

	public int insert(ReplyVO reply);

	public ReplyVO selectById(Integer id);

	public int update(ReplyVO newReply);

	public int delete(Integer id);

	public void deleteByBoardId(Integer boardid);

	public int deleteByMemberId(String memberId);
	
	
}
