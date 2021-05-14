package com.example.demo.aop.transfer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class TransferTest {
	@Autowired
	private Transfer transfer;
	@Autowired
	private Card card;
	@Test
	void test() {
//		card.cardCheck();
//		transfer.takeBus();
//		card.cardCheck();
//		card.cardCheck();
//		transfer.takeSubway();
//		card.cardCheck();
//		OOP한계
		
		transfer.takeBus();
		transfer.takeSubway();
		
	}

}
