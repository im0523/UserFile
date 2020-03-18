package com.topia.card.User;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
	@Autowired private SqlSession sql; 

	public UserVO user_list(UserVO vo) {
		return null;
	}

	public UserVO user_detail(int userIdx) {
		return null;
	}

	public int user_insert(UserVO vo) {
		return sql.insert("user.userInsert", vo);

	}

	public void user_update(UserVO vo) {

	}

	public void user_delete(int userIdx) {

	}


}
