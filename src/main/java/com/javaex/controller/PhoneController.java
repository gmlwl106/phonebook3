package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.PhoneService;
import com.javaex.vo.PersonVo;

@Controller
public class PhoneController {
	
	//필드
	@Autowired
	private PhoneService phoneService;
	
	//생성자
	
	//메소드 gs
	
	//메소드 일반
	//전화번호 리스트
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("PhoneController->list()");
		
		//Service를 통해서 personlist(주소)를 가져온다
		List<PersonVo> personList = phoneService.getPersonList();
		
		//ds 데이터 보내기 -> request.attribute에 넣는다
		//model : 데이터를 담아서 옮겨주는 객체 (request.setAttribute가 하는 일을 함)
		model.addAttribute("personList", personList);
		
		
		return "list";
	}
	
	//전화번호 등록폼
	@RequestMapping(value="/writeForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("PhoneController->writeForm()");
		
		return "writeForm";
	}
	
	//전화번호 등록
	@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute PersonVo personVo) {
		
		System.out.println("PhoneController->write()");
		
		//파라미터 꺼내기, vo에 넣기 -> DispacherServlet이 해줌
		//*Vo에서의 이름과 파라미터의 이름이 같아야 함*
		System.out.println(personVo);
		
		//Service로 저장하기
		int count = phoneService.personInsert(personVo);
		System.out.println(count);
		
		//return은 foward가 기본이기때문에 redirect:이라고 써야 리다이렉트함
		return "redirect:/list";
	}
	
	//전화번호 삭제
	@RequestMapping(value="/delete/{personId}", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@PathVariable("personId") int personId) {
		System.out.println("PhoneController->delete()");
		
		//Service를 이용해서 삭제
		phoneService.personDelete(personId);
		
		return "redirect:/list";
	}
	
	//전화번호 수정폼
	// 파라미터 여러개 일때 /modifyForm/{personId}/{name}
	//						@PathVariable("personId") int personId, @PathVariable("name") String name
	@RequestMapping(value="/modifyForm/{personId}", method= {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(@PathVariable("personId") int personId, Model model) {
		System.out.println("PhoneController->modifyForm()");
		
		//Service를 이용해서 personVo를 찾아옴
		PersonVo personVo = phoneService.getPerson(personId);
		
		model.addAttribute("personVo", personVo);
		
		return "modifyForm";
	}
	
	//전화번호 수정
	@RequestMapping(value="/modify", method= {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController->modify()");
		
		phoneService.personUpdate(personVo);
		
		return "redirect:/list";
	}
	
	
	
	
	
	
	
	
	
	/*
	@RequestMapping(value="/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam("personId") int personId) {
		System.out.println("PhoneController->delete()");
		
		//Dao를 이용해서 삭제
		phoneDao.personDelete(personId);
		
		return "redirect:/list";
	}
	*/

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
		int count = phoneDao.personInsert(personVo);
		System.out.println(count);
		
		//return은 foward가 기본이기때문에 redirect:이라고 써야 리다이렉트함
		return "redirect:/list";
	}
*/
	
	//테스트
	//value:키값(주소) method:get/post 방식 설정 (동시설정 가능)
	//@RequestMapping("/test") <--간단버전(get,post)
	@RequestMapping(value="/test", method= {RequestMethod.GET, RequestMethod.POST})
	public String test() {
		System.out.println("PhoneController->test");
		
		return "test";
	}
	
	
	

}
