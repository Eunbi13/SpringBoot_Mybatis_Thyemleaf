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

	public Long getRef() {
		return ref;
	}

	public void setRef(Long ref) {
		this.ref = ref;
	}

	public Long getStep() {
		return step;
	}

	public void setStep(Long step) {
		this.step = step;
	}

	public Long getDepth() {
		return depth;
	}

	public void setDepth(Long depth) {
		this.depth = depth;
	}

	public List<BoardFileVO> getFiles() {
		return files;
	}

	public void setFiles(List<BoardFileVO> files) {
		this.files = files;
	}
}
