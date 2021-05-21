package com.example.demo.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestSchedule {
			//1초 간격에 이 메서드를 실행하고 2초 간격으로 반복해라
	//@Scheduled(fixedRateString = "1000", initialDelayString = "2000")
	public void fixRateScheduleTest()throws Exception{
		System.out.println("fixRageSchedule");
	}
	
	@Scheduled(cron = "* * * * * *")
	public void cronTest()throws Exception{
		System.out.println("Cron");
	}
}
