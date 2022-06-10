package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
public class PhoneController {
	
	//필드
	
	//생성자
	
	//메소드 gs
	
	//메소드 일반
	
	//전화번호 등록
	@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@RequestParam("name") String name,
						@RequestParam("hp") String hp,
						@RequestParam("company") String company) {
		
		System.out.println("PhoneController->write()");
		
		//vo에 넣기
		PersonVo personVo = new PersonVo(name, hp, company);
		
		//dao로 저장하기
		PhoneDao phoneDao = new PhoneDao();
		int count = phoneDao.personInsert(personVo);
		System.out.println(count);
		
		return "";
	}
	
	//전화번호 등록폼
	@RequestMapping(value="/writeForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("PhoneController->writeForm()");
		
		return "/WEB-INF/views/writeForm.jsp";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//테스트
	//value:키값(주소) method:get/post 방식 설정 (동시설정 가능)
	//@RequestMapping("/test") <--간단버전(get,post)
	@RequestMapping(value="/test", method= {RequestMethod.GET, RequestMethod.POST})
	public String test() {
		System.out.println("PhoneController->test");
		
		return "/WEB-INF/views/test.jsp";
	}
	
	
	

}
