package org.zerock.service.project1;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.project1.BoardVO;
import org.zerock.domain.project1.PageInfoVO;
import org.zerock.mapper.project1.BoardMapper;
import org.zerock.mapper.project1.FileMapper;
import org.zerock.mapper.project1.ReplyMapper;

import lombok.Setter;

//서비스내에 Component포함, 서비스 역할하는것은 Service Annotation붙여주는것이 좋음.
@Service
public class BoardService {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper replyMapper;
	
	@Setter(onMethod_ = @Autowired)
	private FileMapper fileMapper;
	
	private String staticRoot = "C:\\Users\\jjc90\\Desktop\\course\\fileupload\\board\\";
	
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
	@Transactional
	public boolean remove(Integer id) {
		//1. 게시물 달린 댓글 지우기
		replyMapper.deleteByBoardId(id);
		
		//2.파일지우기
		//file system에서 삭제
		String[] files = fileMapper.selectNamesByBoardId(id);
		
		if(files != null) {
			for(String file : files) {
				String path = staticRoot + id + "\\" + file;
				File target = new File(path);
				if(target.exists()) {
					target.delete();
				}
			}
		}
		
		//db에서 삭제
		fileMapper.deleteByBoardId(id);
		
		//3. 게시물 지우기
		return mapper.delete(id) == 1;
	}
	
	//여러개 받아오기 - list
	public List<BoardVO> getList(){
		return mapper.getList();
	}

	public List<BoardVO> getListPage(Integer page, Integer numberPerPage) {
		//sql에서 사용할 record 시작번호(0-index)
		Integer from = (page-1) * 10;
		return mapper.getListPage(from, numberPerPage);
	}

	public PageInfoVO getPageInfo(Integer page, Integer numberPerPage) {
		//총 게시불 수
		Integer countRows = mapper.getCountRows();
		
		//마지막 페이지 번호
		Integer lastPage = (countRows-1) / numberPerPage + 1;
		
		//페이지네이션 가장 왼쪽 번호
		Integer leftPageNumber = (page-1) / 10 * 10 + 1;
		
		//페이지네이션 가장 오른쪽 번호
		Integer rightPageNumber = (page-1) / 10 * 10 + 10;
		
		//가장 마지막 페이지 넘어가지 않도록
		rightPageNumber = rightPageNumber > lastPage ? lastPage : rightPageNumber;
		
		//이전 페이지 버튼 존재 유무
		Boolean hasPrevButton = leftPageNumber != 1;
		
		//다음 페이지 버튼 존재 유무
		Boolean hasNextButton = rightPageNumber != lastPage;
		
		PageInfoVO pageInfo = new PageInfoVO();
		
		pageInfo.setLastPage(lastPage);
		pageInfo.setCountRows(countRows);
		pageInfo.setCurrentPage(page);
		pageInfo.setLeftPageNumber(leftPageNumber);
		pageInfo.setRightPageNumber(rightPageNumber);
		pageInfo.setHasPrevButton(hasPrevButton);
		pageInfo.setHasNextButton(hasNextButton);
		
		return pageInfo;
	}

	@Transactional
	public void register(BoardVO board, MultipartFile[] files) throws IllegalStateException, IOException {
		register(board);
		
		//write files
		String basePath = staticRoot + board.getId();
		if(files[0].getSize() > 0) {
			//files있을 때만 폴더생성
			//1.새 게시물 id 이름의 folder만들기
			File newFolder = new File(basePath);
			newFolder.mkdirs();
		}
		
		//2.위 폴더에 files쓰기
		for(MultipartFile file : files) {
			
			if(file != null && file.getSize() > 0) {
				//2.1파일 작성, FILE SYSTEM
				String path = basePath + "\\" + file.getOriginalFilename();
				file.transferTo(new File(path));
				
				//2.2 insert into File, DATABASE
				fileMapper.insert(board.getId(), file.getOriginalFilename());
			}
		}
	}

	public String[] getFileNamesByBoardId(Integer id) {
		return fileMapper.selectNamesByBoardId(id);
	}

	@Transactional
	public boolean modify(BoardVO board, String[] removeFile, MultipartFile[] files) throws IllegalStateException, IOException {
		modify(board);
		
		String basePath = staticRoot + board.getId();
		//파일 삭제
		if(removeFile != null) {
			for(String removeFileName : removeFile) {
				//file system에서 삭제
				String path = basePath + "\\" + board.getId();
				File target = new File(path);
				
				if(target.exists()) {
					target.delete();
				}
				//db table에서 삭제
				fileMapper.delete(board.getId(), removeFileName);
			}
		}
		
		//새 파일 추가
		if(files[0].getSize() > 0) {
			//files있을 때만 폴더생성
			//1.새 게시물 id 이름의 folder만들기
			File newFolder = new File(basePath);
			newFolder.mkdirs();
		}
		
		for(MultipartFile file : files) {
			if(file != null && file.getSize() > 0) {
				//1.write file to fileSystem
				File newFile = new File(staticRoot + "\\" + board.getId() + "\\" + file.getOriginalFilename());
				
				if(!newFile.exists()) {
					//2.db파일명 insert
					fileMapper.insert(board.getId(), file.getOriginalFilename());
				}

				file.transferTo(newFile);
			}
		}
		
		return false;
	}
}
