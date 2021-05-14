package com.example.demo.aop.transfer;

import org.springframework.stereotype.Component;

@Component
public class Transfer {
	
	public void takeSubway() {
		System.out.println("지하철 탑승");
		System.out.println("넷플시청");
	}
	
	public void takeBus() {
		System.out.println("버스 탑승");
		System.out.println("음악듣기");
	}
	
}
