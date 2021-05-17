package com.example.demo.board.qna;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.BoardMapper;
import com.example.demo.board.BoardVO;
@Mapper
public interface QnaMapper extends BoardMapper{
	public Long setRefUpdate(BoardVO boardVO) throws Exception;
	public Long setReplyUpdate(BoardVO boardVO)throws Exception;
	public Long setReplyInsert(BoardVO boardVO) throws Exception;
}
