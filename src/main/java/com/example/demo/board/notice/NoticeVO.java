package com.example.demo.board.notice;

import java.util.List;

import com.example.demo.board.BoardFileVO;
import com.example.demo.board.BoardVO;

import lombok.Data;
@Data
public class NoticeVO extends BoardVO {
	
	private List<BoardFileVO> files;

	public List<BoardFileVO> getFiles() {
		return files;
	}

	public void setFiles(List<BoardFileVO> files) {
		this.files = files;
	}
}
