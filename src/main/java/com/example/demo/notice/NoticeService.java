package com.example.demo.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.board.BoardService;
import com.example.demo.board.BoardVO;
@Service
public class NoticeService implements BoardService {
	@Autowired
	private NoticeMapper noticeMapper;
	
	@Override
	public List<BoardVO> getList() throws Exception {
		// TODO Auto-generated method stub
		return noticeMapper.getList();
	}
	@Override
	public BoardVO getSelect(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Long setInsert(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Long setUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Long setDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
