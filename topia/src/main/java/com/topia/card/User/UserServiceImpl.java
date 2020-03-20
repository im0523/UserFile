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
		
		int result = 0;
		
		result = dao.userInfo_insert(vo);
		
		if( result==1 ) {
			dao.userEdu_insert(vo);
			dao.userCareer_insert(vo);
			dao.userLicen_insert(vo);
			dao.userQualifi_insert(vo);
			dao.userSkill_insert(vo);
			dao.usereTraining_insert(vo);
		}
		return result;
		
	}

	@Override
	public void user_update(UserVO vo) {
		
	}

	@Override
	public void user_delete(int userIdx) {
		
	}
	
}
