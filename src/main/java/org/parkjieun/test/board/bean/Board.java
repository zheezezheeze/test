package org.parkjieun.test.board.bean;

public class Board {
	private int b_num;
	private String b_title;
	private String b_content;
	private int b_count;
	private String b_password;
	private String m_id;
	
	public Board() {
	}

	public Board(int b_num, String b_title, String b_content, int b_count, String b_password, String m_id) {
		this.b_num = b_num;
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_count = b_count;
		this.b_password = b_password;
		this.m_id = m_id;
	}

	public int getB_num() {
		return b_num;
	}
	
	public void setB_num(int b_num) {
		this.b_num = b_num;
	}
	
	public String getB_title() {
		return b_title;
	}
	
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	
	public String getB_content() {
			return b_content;
	}
	
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	
	public int getB_count() {
		return b_count;
	}
	
	public void setB_count(int b_count) {
		this.b_count = b_count;
	}
	
	public String getB_password() {
		return b_password;
	}

	public void setB_password(String b_password) {
		this.b_password = b_password;
	}

	public String getM_id() {
		return m_id;
	}
	
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	@Override
	public String toString() {
		return "Board [b_num=" + b_num + ", b_title=" + b_title + ", b_content=" + b_content + ", b_count=" + b_count
				+ ", m_id=" + m_id + "]";
	}
	
}
