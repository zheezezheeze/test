package org.parkjieun.test.board.service;

import org.parkjieun.test.board.bean.Board;

public interface IBoardService {
	Board getABoard(int b_num);
	boolean isPasswordRight(Board board, String inputPassword);
	Board[] getBoards();
	int insertBoard(Board board);
	int updatePassword(int b_num, String newPassword);
	int updateCount(int b_num);
}
