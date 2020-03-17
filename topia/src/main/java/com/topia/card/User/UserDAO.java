package com.topia.card.User;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO implements UserService {
	@Autowired private SqlSession sql;
	
	@Override
	public UserVO user_list(UserVO vo) {
		return null;
	}

	@Override
	public UserVO user_detail(int userIdx) {
		return null;
	}

	@Override
	public int user_insert(UserVO vo) {
		return sql.insert("user.userInsert", vo);

	}

	@Override
	public void user_update(UserVO vo) {

	}

	@Override
	public void user_delete(int userIdx) {

	}

}
