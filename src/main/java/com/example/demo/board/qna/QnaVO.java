package com.example.demo.board.qna;

import java.util.List;

import com.example.demo.board.BoardFileVO;
import com.example.demo.board.BoardVO;

import lombok.Data;
@Data
public class QnaVO extends BoardVO{
	private Long ref;
	private Long step;
	private Long depth;
	
	private List<BoardFileVO> files;
}
