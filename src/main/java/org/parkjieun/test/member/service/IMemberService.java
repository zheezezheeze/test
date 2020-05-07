package org.parkjieun.test.member.service;

import org.parkjieun.test.member.bean.Member;

public interface IMemberService {
	Member getMember(String m_id);
	boolean isPasswordRight(Member member, String inputPassword);
	String getName(String m_id);
}
