package com.example.demo.error;

import java.sql.SQLException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

	@ExceptionHandler(NullPointerException.class)
	public String getNull(Model model) {
		model.addAttribute("msg","null발생");
		return "error/500";
	}
	
	@ExceptionHandler(SQLException.class)
	public String getSql(Model model) {
		model.addAttribute("msg","DB문제발생");
		return "error/500";
	}
	
	@ExceptionHandler(Exception.class)
	public String getException(Model model) {
		model.addAttribute("msg","Exception 발생");
		return "error/500";
	}
	
	@ExceptionHandler(Throwable.class)
	public String getThrowable(Model model) {
		model.addAttribute("msg","관리자에게 발생 문의");
		return "error/500";
	}
	
	@ExceptionHandler(MyException.class)
	public String getMy(Model model, Exception exception) {
		model.addAttribute("msg", exception.getMessage());
		return "error/500";
	}
}
