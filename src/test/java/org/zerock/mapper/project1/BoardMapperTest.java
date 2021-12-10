package org.zerock.mapper.project1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.project1.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTest {

	@Autowired
	public BoardMapper mapper;
	
	/*assert : 값이 조건을 만족하는지 아닌지 check*/
	@Test
	public void mapperTest() {
		assertNotNull(mapper);
	}
	
	//insert
	@Test
	public void insertTest() {
		BoardVO vo = new BoardVO();
		vo.setTitle("test용 제목");
		vo.setContent("test용 본문");
		vo.setWriter("tester");
		
		int cnt = mapper.insert(vo);
		
		assertEquals(1, cnt);
	}

	//insert&Select
	@Test
	public void insertAndSelectTest() {
		BoardVO vo = new BoardVO();
		vo.setTitle("test용 제목" + Math.random());
		vo.setContent("테스트 용 본문" + Math.random());
		vo.setWriter("tester");
		
		mapper.insert(vo);
		
		assertNotNull(vo.getId());
		assertNotEquals(0, vo.getId().intValue());
		
		BoardVO lastInserted = mapper.read(vo.getId());
		
		assertEquals(vo.getTitle(), lastInserted.getTitle());
		assertEquals(vo.getContent(), lastInserted.getContent());
		assertEquals(vo.getWriter(), lastInserted.getWriter());
	}
	
	//update
	@Test
	public void updateTest() {
		BoardVO vo = new BoardVO();
		vo.setTitle("test용 제목" + Math.random());
		vo.setContent("테스트 용 본문" + Math.random());
		vo.setWriter("tester");
		
		mapper.insert(vo);
		
		assertNotNull(vo.getId());
		assertNotEquals(0, vo.getId().intValue());
		
		String newTitle = "update용 제목" + Math.random();
		String newContent = "update용 본문" + Math.random();
		
		vo.setTitle(newTitle);
		vo.setContent(newContent);
		
		mapper.update(vo);
		
		BoardVO updateVO = mapper.read(vo.getId());
		
		assertEquals(newTitle, updateVO.getTitle());
		assertEquals(newContent, vo.getContent());
	}
	
	//insert하자마자 Delete
	@Test
	public void insertAndDeleteTest() {
		BoardVO vo = new BoardVO();
		vo.setTitle("삭제용 제목");
		vo.setContent("삭제용 본문");
		vo.setWriter("tester");
		
		int cnt = mapper.insert(vo);
		
		assertEquals(1,cnt);
		
		cnt = mapper.delete(vo.getId());
		
		assertEquals(1, cnt);
		
		BoardVO deleted = mapper.read(vo.getId());
		assertNull(deleted);
	}
	
	//list테스트
	@Test
	public void getListTest() {
		List<BoardVO> list = mapper.getList();
		assertNotNull(list);
		assertTrue(list.size() > 0);
		
		BoardVO vo = new BoardVO();
		vo.setTitle("list 테스트용");
		vo.setContent("list 테스트용 본문");
		vo.setWriter("tester");
		
		mapper.insert(vo);
		
		List<BoardVO> list2 = mapper.getList();
		
		assertEquals(list.size() + 1, list2.size());
		
		for(BoardVO item : list2) {
			assertNotNull(item.getId());
			assertNotNull(item.getTitle());
			assertNotNull(item.getContent());
			assertNotNull(item.getWriter());
			assertNotNull(item.getInserted());
			assertNotNull(item.getUpdated());
		}
	}
}
