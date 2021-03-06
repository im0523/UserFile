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

	// 불러오기 totalCnt 출력
	public int list_totalCnt(userInfoVO infoVo) {
		return sql.selectOne("userInfo.totalCnt", infoVo);
	}
	
	// 한 명의 user profile detail 조회 - userInfo
	public userInfoVO userInfo_detail(int userIdx) {
		return sql.selectOne("userInfo.userInfoList", userIdx);
	}

	// 한 명의 user profile detail 조회 - userCareer
	public List<userCareerVO> userCareer_detail(int userIdx) {
		return sql.selectList("userCareer.userCareerList", userIdx);
	}

	// 한 명의 user profile detail 조회 - userEdu
	public List<userEduVO> userEdu_detail(int userIdx) {
		return sql.selectList("userEdu.userEduList", userIdx);
	}

	// 한 명의 user profile detail 조회 - userLicen
	public List<userLicenVO> userLicen_detail(int userIdx) {
		return sql.selectList("userLicen.userLicenList", userIdx);
		
	}

	// 한 명의 user profile detail 조회 - userQualifi
	public List<userQualifiVO> userQualifi_detail(int userIdx) {
		return sql.selectList("userQualifi.userQualifiList", userIdx);
	}

	// 한 명의 user profile detail 조회 - userSkill
	public List<userSkillVO> userSkill_detail(int userIdx) {
		return sql.selectList("userSkill.userSkillList", userIdx);
	}

	// 한 명의 user profile detail 조회 - userTraining
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

	public int userInfo_update(userInfoVO vo) {
		return sql.update("userInfo.update", vo);
	}

	// 수정저장 눌렀을 때 delete 처리 - edu
	public void userEdu_delete(Integer userIdx) {
		sql.delete("userEdu.delete", userIdx);
	}

	// 수정저장 눌렀을 때 delete 처리 - career
	public void userCareer_delete(Integer userIdx) {
		sql.delete("userCareer.delete", userIdx);
	}

	// 수정저장 눌렀을 때 delete 처리 - qualifi
	public void userQualifi_delete(Integer userIdx) {
		sql.delete("userQualifi.delete", userIdx);
	}

	// 수정저장 눌렀을 때 delete 처리 - licen
	public void userLicen_delete(Integer userIdx) {
		sql.delete("userLicen.delete", userIdx);
	}

	// 수정저장 눌렀을 때 delete 처리 - skill
	public void userSkill_delete(Integer userIdx) {
		sql.delete("userSkill.delete", userIdx);
	}

	// 수정저장 눌렀을 때 delete 처리 - training
	public void userTraining_delete(Integer userIdx) {
		sql.delete("userTraining.delete", userIdx);
	}

	//연차별 인원조회 불러오기
	public List<userInfoVO> groupList() {
		return sql.selectList("userInfo.groupList");
	}

}
