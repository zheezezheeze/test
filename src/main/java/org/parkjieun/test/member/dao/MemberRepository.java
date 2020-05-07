package org.parkjieun.test.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.parkjieun.test.member.bean.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository implements IMemberRepository {
	private static final String memberMapper = "temp.memberMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public Member getMember(String m_id) {
		return sqlSession.selectOne(memberMapper + ".getMember", m_id);
	}

	@Override
	public String getName(String m_id) {
		return sqlSession.selectOne(memberMapper + ".getName", m_id);
	}

}
