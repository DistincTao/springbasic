package com.springbasic.persistence;

import java.util.List;

import com.springbasic.dto.MemberDto;
import com.springbasic.vo.MemberVo;

public interface MemberDao {
	public abstract String getDate();
	public abstract MemberVo selectMemberByUserId(String userId);
	public abstract void InsertMember(MemberDto dto);
	public abstract List<MemberVo> selectAllMember();

	
}
