package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;


@Service
public class PhoneService {

	//필드
	@Autowired
	private PhoneDao phoneDao;
	
	//생성자
	
	//메소드 gs
	
	//메소드 일반
	public List<PersonVo> getPersonList() {
		return phoneDao.getPersonList();
	}

	public int personInsert(PersonVo personVo) {
		int count = phoneDao.personInsert(personVo);
		
		return count;
	}

	public int personDelete(int personId) {
		int count = phoneDao.personDelete(personId);
		
		return count;		
	}

	public PersonVo getPerson(int personId) {
		return phoneDao.getPerson(personId);
	}

	public int personUpdate(PersonVo personVo) {
		int count = phoneDao.personUpdate(personVo);
		
		return count;
	}
	
	
}
