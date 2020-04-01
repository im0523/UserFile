package com.topia.card.User;

import java.util.List;

import com.topia.card.vo.userCareerVO;
import com.topia.card.vo.userEduVO;
import com.topia.card.vo.userInfoVO;
import com.topia.card.vo.userLicenVO;
import com.topia.card.vo.userQualifiVO;
import com.topia.card.vo.userSkillVO;
import com.topia.card.vo.userTrainingVO;

public interface UserService {
	
	List<userInfoVO> user_list(userInfoVO vo);		//불러오기 userList 조회
	int list_totalCnt(userInfoVO infoVo);		//불러오기 totalCnt 조회
	
	//한 사람에 대한 불러오기 상세조회
	userInfoVO user_detail(int userIdx);			//한 명의 user profile detail 조회
	List<userEduVO> userEdu_detail(int userIdx);	//한 명의 edu detail 조회
	List<userCareerVO> userCareer_detail(int userIdx);	//한 명의 career detail 조회
	List<userLicenVO> userLicen_detail(int userIdx);	//한 명의 licen detail 조회
	List<userQualifiVO> userQualifi_detail(int userIdx);	//한 명의 qualifi detail 조회
	List<userSkillVO> userSkill_detail(int userIdx);		//한 명의 skill detail 조회
	List<userTrainingVO> userTraining_detail(int userIdx);	//한 명의 training detail 조회
	
	int user_insert(userInfoVO infoVo, userCareerVO careerVo, userEduVO eduVo, userLicenVO licenVo,
					userQualifiVO qualifiVo, userSkillVO skillVo, userTrainingVO trainVo);
	
	//불러오기 후 update 처리
	int user_update(userInfoVO infoVo, userCareerVO careerVo, userEduVO eduVo, userLicenVO licenVo,
			userQualifiVO qualifiVo, userSkillVO skillVo, userTrainingVO trainVo);

}
