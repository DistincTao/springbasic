package com.springbasic.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springbasic.persistence.MemberDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MemberDaoTest {
	@Inject
	private MemberDao dao; // Dao 객체를 주입
	
	@Test
	public void getDateTimeTest() {
		System.out.println("현재 시간은 : " + dao.getDate());
	}
}
