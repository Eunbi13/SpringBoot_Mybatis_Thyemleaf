package com.example.demo.notice;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.BoardVO;
@SpringBootTest
public class NoticeTest {

	@Autowired
	private NoticeMapper mapper;
	@Test
	public void getList() throws Exception{
		List<BoardVO> list = mapper.getList();
		for(BoardVO ar:list) {
			System.out.println(ar);
			
		}
	}
	
}
