package com.springbasic.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.springbasic.dto.MemberDto;
import com.springbasic.vo.MemberVo;

@Repository // 아래의 클래스가 DAO 객체임을 명시
public class MemberDaoImpl implements MemberDao {
	private static String ns = "com.springbasic.mappers.memberMapper";
	
	@Inject
	private SqlSession ses; // sqlSessionTemplate 객체 주입

	@Override
	public String getDate() {
		String q = ns + ".currDate";
//		ses.selectOne(q);
		
		return ses.selectOne(q);
	}

	@Override
	public MemberVo selectMemberByUserId(String userId) {
		
		String q = ns + ".viewMemberByUserId";
	
		return ses.selectOne(q, userId);
	}

	@Override
	public void InsertMember(MemberDto dto) {
		String q = ns + ".inputMemberWithoutImg";
		ses.selectOne(q, dto);
		
	}

	@Override
	public List<MemberVo> selectAllMember() {
		String q = ns + ".getAllMembers";
		
		return ses.selectList(q);
	}

}
