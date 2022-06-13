package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	//전화번호 리스트
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("PhoneController->list()");
		
		//Dao를 통해서 personlist(주소)를 가져온다
		PhoneDao phoneDao = new PhoneDao();
		List<PersonVo> personList = phoneDao.getPersonList();
		
		//ds 데이터 보내기 -> request.attribute에 넣는다
		//model : 데이터를 담아서 옮겨주는 객체 (request.setAttribute가 하는 일을 함)
		model.addAttribute("personList", personList);
		
		
		return "/WEB-INF/views/list.jsp";
	}
	
	//전화번호 등록
	@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute PersonVo personVo) {
		
		System.out.println("PhoneController->write()");
		
		//파라미터 꺼내기, vo에 넣기 -> DispacherServlet이 해줌
		//*Vo에서의 이름과 파라미터의 이름이 같아야 함*
		
		System.out.println(personVo);
		
		//dao로 저장하기
		PhoneDao phoneDao = new PhoneDao();
		int count = phoneDao.personInsert(personVo);
		System.out.println(count);
		
		//return은 foward가 기본이기때문에 redirect:이라고 써야 리다이렉트함
		return "redirect:/list";
	}
	
/*
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
		
		//return은 foward가 기본이기때문에 redirect:이라고 써야 리다이렉트함
		return "redirect:/list";
	}
*/
	
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
