package org.zerock.service.project1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.project1.BoardVO;
import org.zerock.mapper.project1.BoardMapper;

import lombok.Setter;

//서비스내에 Component포함, 서비스 역할하는것은 Service Annotation붙여주는것이 좋음.
@Service
public class BoardService {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	//insert
	public boolean register(BoardVO board) {
		return mapper.insert(board) == 1;
	}
	
	//get
	public BoardVO get(Integer id) {
		return mapper.read(id);
	}
	
	//modify
	public boolean modify(BoardVO board) {
		return mapper.update(board) == 1;
	}
	
	//remove
	public boolean remove(Integer id) {
		return mapper.delete(id) == 1;
	}
	
	//여러개 받아오기 - list
	public List<BoardVO> getList(){
		return mapper.getList();
	}
}
