package com.topia.card.User;

import java.util.List;

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

	// 불러오기 list 출력
	public List<userInfoVO> user_list(userInfoVO vo) {
		return sql.selectList("userInfo.userList", vo);
	}

	// 한 명의 user profile detail 조회
	public userInfoVO userInfo_detail(int userIdx) {
		return sql.selectOne("userInfo.userInfoList", userIdx);
	}

	public List<userCareerVO> userCareer_detail(int userIdx) {
		return sql.selectList("userCareer.userCareerList", userIdx);
	}

	public List<userEduVO> userEdu_detail(int userIdx) {
		return sql.selectList("userEdu.userEduList", userIdx);
	}

	public List<userLicenVO> userLicen_detail(int userIdx) {
		return sql.selectList("userLicen.userLicenList", userIdx);
		
	}

	public List<userQualifiVO> userQualifi_detail(int userIdx) {
		return sql.selectList("userQualifi.userQualifiList", userIdx);
	}

	public List<userSkillVO> userSkill_detail(int userIdx) {
		return sql.selectList("userSkill.userSkillList", userIdx);
	}

	public List<userTrainingVO> userTraining_detail(int userIdx) {
		return sql.selectList("userTraining.userTrainingList", userIdx);
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
