package com.topia.card.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topia.card.vo.userCareerVO;
import com.topia.card.vo.userEduVO;
import com.topia.card.vo.userInfoVO;
import com.topia.card.vo.userLicenVO;
import com.topia.card.vo.userQualifiVO;
import com.topia.card.vo.userSkillVO;
import com.topia.card.vo.userTrainingVO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired private UserDAO dao;

	@Override
	public userInfoVO user_list(userInfoVO vo) {
		return null;
	}

	@Override
	public userInfoVO user_detail(int userIdx) {
		return null;
	}

	@Override
	public int user_insert(userInfoVO infoVo, userCareerVO careerVo, userEduVO eduVo, userLicenVO licenVo,
							userQualifiVO qualifiVo, userSkillVO skillVo, userTrainingVO trainVo) {
		
		int result = 0;
		
		result = dao.userInfo_insert(infoVo);
		
		if( result==1 ) {
			for(userEduVO i : eduVo.getEduList()) {
//				System.out.println(i + "//" + i.getEduSchoolName());
				dao.userEdu_insert(i);
			}
			for(userQualifiVO i : qualifiVo.getQualifiList()) {
				dao.userQualifi_insert(i);
			}
//			for(userLicenVO i : licenVo.getLicenList()) {
//				dao.userLicen_insert(i);
//			}
//			for(userCareerVO i : careerVo.getCareerList()) {
//				dao.userCareer_insert(i);
//			}
//			for(userSkillVO i : skillVo.getSkillList()) {
//				dao.userSkill_insert(i);
//			}
//			for(userTrainingVO i : trainVo.getTrainList()) {
//				dao.usereTraining_insert(i);
//			}
		}
		return result;
		
	}

	@Override
	public void user_update(userInfoVO vo) {
		
	}

	@Override
	public void user_delete(int userIdx) {
		
	}
	
}
