package com.topia.card.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired private UserDAO dao;

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
		return dao.user_insert(vo);
		
	}

	@Override
	public void user_update(UserVO vo) {
		
	}

	@Override
	public void user_delete(int userIdx) {
		
	}
	
}
