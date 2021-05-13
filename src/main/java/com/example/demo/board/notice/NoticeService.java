package com.example.demo.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.board.BoardFileVO;
import com.example.demo.board.BoardService;
import com.example.demo.board.BoardVO;
import com.example.demo.util.FileManager;
import com.example.demo.util.Pager;
@Service
public class NoticeService implements BoardService {
	@Autowired
	private NoticeMapper noticeMapper;
	@Autowired
	private FileManager fileManager;
	
	@Override
	public List<BoardVO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		pager.makeRow();
		Long totalCount = noticeMapper.getTotalCount(pager);
		pager.makeNum(totalCount);
		return noticeMapper.getList(pager);
	}
	@Override
	public BoardVO getSelect(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		noticeMapper.setHitUpdate(boardVO);
		return noticeMapper.getSelect(boardVO);
	}
	@Override
	public Long setInsert(BoardVO boardVO, MultipartFile [] files) throws Exception {
		// TODO Auto-generated method stub
		Long result = noticeMapper.setInsert(boardVO);
		//file
		String filePath = "uploa"
				+ "d/notice/";
		for(MultipartFile f: files) {
			if(f.getSize()==0) { continue; }
			String fileName = fileManager.save(f, filePath);
			BoardFileVO boardFileVO = new BoardFileVO();
			boardFileVO.setFileName(fileName);
			boardFileVO.setOriName(f.getOriginalFilename());
			boardFileVO.setNum(boardVO.getNum());
			System.out.println(fileName);
			noticeMapper.setFileInsert(boardFileVO);
		}

		return result;
	}
	@Override
	public Long setUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeMapper.setUpdate(boardVO);
	}
	@Override
	public Long setDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return noticeMapper.setDelete(boardVO);
	}
}
