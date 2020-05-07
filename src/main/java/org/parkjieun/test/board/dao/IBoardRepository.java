package org.parkjieun.test.board.dao;

import org.parkjieun.test.board.bean.Board;

public interface IBoardRepository {
	Board getABoard(int b_num);
	Board[] getBoards();
	int getCount(int b_num);
	int insertBoard(Board board);
	int updatePassword(int b_num, String newPassword);
	int updateCount(int b_num, int countValue);
}
