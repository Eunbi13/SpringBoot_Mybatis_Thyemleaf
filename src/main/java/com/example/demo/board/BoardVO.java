package com.example.demo.board;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
@Getter
@Setter
@ToString				 //toString override
@NoArgsConstructor		 // default 생성자
@AllArgsConstructor		 //모든 매개변수가 있는 생성자를 자동으로 생성
@RequiredArgsConstructor //필수 매개변수만 있는 생성자를 생성
@EqualsAndHashCode		 //hash, equals 메서드
*/
@Data //lombok의 모든 annotation 선언과 같음
public class BoardVO {
	private Long num;
	private String title;
	private String writer;
	private String contents;
	private Date regDate;
	private Long hit;
}
