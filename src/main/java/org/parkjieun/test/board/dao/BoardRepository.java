package org.parkjieun.test.board.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.parkjieun.test.board.bean.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardRepository implements IBoardRepository {
	private static final String boardMapper = "temp.boardMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public Board getABoard(int b_num) {
		return sqlSession.selectOne(boardMapper + ".getABoard", b_num);
	}

	@Override
	public Board[] getBoards() {
		return sqlSession.selectList(boardMapper + ".getBoards").toArray(new Board[0]);
	}

	@Override
	public int getCount(int b_num) {
		return sqlSession.selectOne(boardMapper + ".getCount");
	}

	@Override
	public int insertBoard(Board board) {
		return sqlSession.insert(boardMapper + ".insertBoard", board);
	}

	@Override
	public int updatePassword(int b_num, String newPassword) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("newPassword", newPassword);
		map.put("b_num", b_num);
		return sqlSession.update(boardMapper + ".updatePassword", map);
	}

	@Override
	public int updateCount(int b_num, int countValue) {
		HashMap<String , Integer> map = new HashMap<String, Integer>();
		map.put("countValue", countValue);
		map.put("b_num", b_num);
		return sqlSession.update(boardMapper + ".updateCountValue", map);
	}
	
}
