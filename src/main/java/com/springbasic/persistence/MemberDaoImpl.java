package com.springbasic.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository // 아래의 클래스가 DAO 객체임을 명시
public class MemberDaoImpl implements MemberDao {
	@Inject
	private SqlSession ses; // sqlSessionTemplate 객체 주입

	@Override
	public String getDate() {
		String q = "com.springbasic.mappers.memberMapper" + ".currDate";
//		ses.selectOne(q);
		
		return ses.selectOne(q);
	}

}
