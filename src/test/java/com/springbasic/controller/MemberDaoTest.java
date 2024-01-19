package com.springbasic.controller;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springbasic.persistence.MemberDao;
import com.springbasic.vo.MemberVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MemberDaoTest {
	@Inject
	private MemberDao dao; // Dao 객체를 주입
	
	@Test
	public void getDateTimeTest() {
		System.out.println("현재 시간은 : " + dao.getDate());
	}
	
	@Test
	public void selectMemberByUserIdTest() {
		System.out.println("결과 : " + dao.selectMemberByUserId("wanda"));
	}

//	@Test
//	public void insertMemberTest() {
//		
//		MemberDto dto = new MemberDto("steve", "!234Qwer","steve@distinctao.com", null, 1, 100, null, null, null);
//		
//		dao.InsertMember(dto);
//	}
	
	@Test
	public void selectAllMembers() {
		List<MemberVo> list = dao.selectAllMember();
		
		for (MemberVo vo : list) {
			System.out.println(vo.toString());
		}
			
	}	
	
}
