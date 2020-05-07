package org.parkjieun.test.member.dao;

import org.parkjieun.test.member.bean.Member;

public interface IMemberRepository {
	Member getMember(String m_id);
	String getName(String m_id);
}
