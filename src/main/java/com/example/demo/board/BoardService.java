package com.example.demo.board;

import java.util.List;

import com.example.demo.util.Pager;

public interface BoardService {
		//list
		public List<BoardVO> getList(Pager pager)throws Exception;
		//select
		public BoardVO getSelect(BoardVO boardVO)throws Exception;
		//insert
		public Long setInsert(BoardVO boardVO)throws Exception;
		//update
		public Long setUpdate(BoardVO boardVO)throws Exception;
		//delete
		public Long setDelete(BoardVO boardVO)throws Exception;
}
