package com.example.demo.notice;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.BoardVO;
import com.example.demo.board.notice.NoticeMapper;
@SpringBootTest
public class NoticeTest {

	@Autowired
	private NoticeMapper mapper;
	
	void getList() throws Exception{
//		List<BoardVO> list = mapper.getList();
//		for(BoardVO ar:list) {
//			System.out.println(ar);
//		}
//		assertNotNull(list);
	}
	@Test
	void setInsertTest()throws Exception{
		for(int i =0; i<100; i++) {
			BoardVO vo = new BoardVO();
			vo.setTitle("title"+1);
			vo.setWriter("writer"+1);
			vo.setContents("contents"+1);
			mapper.setInsert(vo);
			Thread.sleep(500);
		}
		System.out.println("fin");
	}
}
