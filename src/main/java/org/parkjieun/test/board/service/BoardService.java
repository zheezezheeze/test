package org.parkjieun.test.board.service;

import org.parkjieun.test.board.bean.Board;
import org.parkjieun.test.board.dao.IBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService implements IBoardService {
	
	@Autowired
	private IBoardRepository dao;
	
	@Override
	public Board getABoard(int b_num) {
		return dao.getABoard(b_num);
	}

	@Override
	public boolean isPasswordRight(Board board, String inputPassword) {
		return board.getB_password().equals(inputPassword);
	}

	@Override
	public Board[] getBoards() {
		return dao.getBoards();
	}

	@Override
	public int insertBoard(Board board) {
		return dao.insertBoard(board);
	}

	@Override
	public int updatePassword(int b_num, String newPassword) {
		return dao.updatePassword(b_num, newPassword);
	}

	@Override
	public int updateCount(int b_num) {
		Board board = dao.getABoard(b_num);
		int countValue = (int)board.getB_count() + 1;
		return dao.updateCount(b_num, countValue);
	}
	

}
