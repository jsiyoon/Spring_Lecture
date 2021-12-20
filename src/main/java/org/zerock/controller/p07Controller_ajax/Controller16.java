package org.zerock.controller.p07Controller_ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.controller.p05Controller.bean.Bean10;
import org.zerock.controller.p05Controller.bean.Bean12;
import org.zerock.domain.project1.BoardVO;
import org.zerock.domain.project1.MemberVO;
import org.zerock.mapper.project1.BoardMapper;
import org.zerock.mapper.project1.MemberMapper;

import lombok.Setter;

@Controller
@RequestMapping("/cont16")
public class Controller16 {
	
	@Setter(onMethod_ = @Autowired)
	private MemberMapper memberMapper;
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;
	
	@RequestMapping("/met01")
	@ResponseBody
	public String method01() {
		return "hello Controller";
	}
	
	//json활용
	@RequestMapping("/met02")
	@ResponseBody
	public String method02() {
		Bean10 b = new Bean10();
		b.setContactName("donald");
		b.setCustomerName("trump");
		
		//가장 많이 쓴는 표현법
		//JavaScript Object Notation : JSON
		return "{\"contactName\" : \"donald\", \"customerName\" : \"trump\"}";
	}
	
	//json자동응답 - Bean10사용
	@RequestMapping("/met03")
	@ResponseBody
	public Bean10 method03() {
		Bean10 b = new Bean10();
		b.setContactName("seoul");
		b.setCustomerName("jeju");
		return b;
	}
	
	//json자동응답 - Bean12사용
	@RequestMapping("/met04")
	@ResponseBody
	public Bean12 method04() {
		Bean12 b = new Bean12();
		b.setId(30);
		b.setLname("donald");
		b.setFname("trump");
		return b;
	}
	
	//json자동응답 - MemberVO, memberMapper사용
	@RequestMapping("/met05")
	@ResponseBody
	public MemberVO method05() {
		MemberVO member = memberMapper.select("myid");
		return member;
	}
	
	//json자동응답 - BoardVO, boardrMapper사용
	@RequestMapping("/met06")
	@ResponseBody
	public BoardVO method06() {
		BoardVO board = boardMapper.read(507);
		return board;
	}
	
	//json자동응답(List로 여러개 출력) - BoardVO, boardMapper사용
	@RequestMapping("/met07")
	@ResponseBody
	public List<BoardVO> method07() {
		List<BoardVO> list = boardMapper.getListPage(0, 3);
		return list;
	}
	
	//json자동응답(List로 여러개 출력) - MemberVO, memberMapper사용
	@RequestMapping("/met08")
	@ResponseBody
	public List<MemberVO> method08(){
		List<MemberVO> list = memberMapper.listPage(0, 3);
		return list;
	}
}
