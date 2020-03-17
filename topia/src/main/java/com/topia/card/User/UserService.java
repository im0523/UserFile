package com.topia.card.User;

public interface UserService {
	//CRUD
	UserVO user_list(UserVO vo);
	UserVO user_detail(int userIdx);
	int user_insert(UserVO vo);
	void user_update(UserVO vo);
	void user_delete(int userIdx);
}
