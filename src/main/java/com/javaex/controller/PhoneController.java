package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PhoneController {
	
	//필드
	
	//생성자
	
	//메소드 gs
	
	//메소드 일반
	//테스트
	//value:키값(주소) method:get/post 방식 설정 (동시설정 가능)
	//@RequestMapping("/test") <--간단버전(get,post)
	@RequestMapping(value="/test", method= {RequestMethod.GET, RequestMethod.POST})
	public String test() {
		System.out.println("PhoneController->test");
		
		return "/WEB-INF/views/test.jsp";
	}
	
	
	

}
