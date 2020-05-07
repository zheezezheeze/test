package org.parkjieun.test.member.service;

import org.parkjieun.test.member.bean.Member;
import org.parkjieun.test.member.dao.IMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService implements IMemberService {

	@Autowired
	private IMemberRepository dao;

	@Override
	public Member getMember(String m_id) {
		return dao.getMember(m_id);
	}

	@Override
	public boolean isPasswordRight(Member member, String inputPassword) {
		return member.getM_password().equals(inputPassword);
	}

	@Override
	public String getName(String m_id) {
		return dao.getName(m_id);
	}

}
