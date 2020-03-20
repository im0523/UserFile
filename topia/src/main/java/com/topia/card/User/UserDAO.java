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

	public int userInfo_insert(UserVO vo) {
		return sql.insert("userInfo.insert", vo);
	}

	public int userEdu_insert(UserVO vo) {
		return sql.insert("userEdu.insert", vo);
	}
	
	public int userCareer_insert(UserVO vo) {
		return sql.insert("userCareer.insert", vo);
	}
	
	public int userLicen_insert(UserVO vo) {
		return sql.insert("userLicen.insert", vo);
	}
	
	public int userQualifi_insert(UserVO vo) {
		return sql.insert("userQualifi.insert", vo);
	}
	
	public int userSkill_insert(UserVO vo) {
		return sql.insert("userSkill.insert", vo);
	}
	
	public int usereTraining_insert(UserVO vo) {
		return sql.insert("userTraining.insert", vo);
	}
	
	public void user_update(UserVO vo) {

	}

	public void user_delete(int userIdx) {

	}




}
