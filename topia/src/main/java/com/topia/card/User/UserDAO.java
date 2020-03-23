package com.topia.card.User;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.topia.card.vo.userCareerVO;
import com.topia.card.vo.userEduVO;
import com.topia.card.vo.userInfoVO;
import com.topia.card.vo.userLicenVO;
import com.topia.card.vo.userQualifiVO;
import com.topia.card.vo.userSkillVO;
import com.topia.card.vo.userTrainingVO;

@Repository
public class UserDAO {
	@Autowired private SqlSession sql; 

	public userInfoVO user_list(userInfoVO vo) {
		return null;
	}

	public userInfoVO user_detail(int userIdx) {
		return null;
	}

	public int userInfo_insert(userInfoVO vo) {
		return sql.insert("userInfo.insert", vo);
	}

	public int userEdu_insert(userEduVO vo) {
		return sql.insert("userEdu.insert", vo);
	}
	
	public int userCareer_insert(userCareerVO vo) {
		return sql.insert("userCareer.insert", vo);
	}
	
	public int userLicen_insert(userLicenVO vo) {
		return sql.insert("userLicen.insert", vo);
	}
	
	public int userQualifi_insert(userQualifiVO vo) {
		return sql.insert("userQualifi.insert", vo);
	}
	
	public int userSkill_insert(userSkillVO vo) {
		return sql.insert("userSkill.insert", vo);
	}
	
	public int usereTraining_insert(userTrainingVO vo) {
		return sql.insert("userTraining.insert", vo);
	}
	
	public void user_update(userInfoVO vo) {

	}

	public void user_delete(int userIdx) {

	}




}
