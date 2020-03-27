package com.topia.card.User;

import java.util.List;

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
	public List<userInfoVO> user_list(userInfoVO vo) {
		return dao.user_list(vo);
	}

	@Override
	public userInfoVO user_detail(int userIdx) {
		return dao.userInfo_detail(userIdx);
	}
	
	@Override
	public List<userEduVO> userEdu_detail(int userIdx) {
		return dao.userEdu_detail(userIdx);
	}

	@Override
	public List<userCareerVO> userCareer_detail(int userIdx) {
		return dao.userCareer_detail(userIdx);
	}

	@Override
	public List<userLicenVO> userLicen_detail(int userIdx) {
		return dao.userLicen_detail(userIdx);
	}

	@Override
	public List<userQualifiVO> userQualifi_detail(int userIdx) {
		return dao.userQualifi_detail(userIdx);
	}

	@Override
	public List<userSkillVO> userSkill_detail(int userIdx) {
		return dao.userSkill_detail(userIdx);
	}
	
	@Override
	public List<userTrainingVO> userTraining_detail(int userIdx) {
		return dao.userTraining_detail(userIdx);
	}

	@Override
	public int user_insert(userInfoVO infoVo, userCareerVO careerVo, userEduVO eduVo, userLicenVO licenVo,
							userQualifiVO qualifiVo, userSkillVO skillVo, userTrainingVO trainVo) {
		
		int result = 0;
		
		result = dao.userInfo_insert(infoVo);
		
		if( result==1 ) {
			for(userEduVO i : eduVo.getEduList()) {
//				System.out.println(i + "//" + i.getEduSchoolName());
				if(i.getEduSchoolName() != null) {
					dao.userEdu_insert(i);
				}
			}
			for(userQualifiVO i : qualifiVo.getQualifiList()) {
				if(i.getQualifiName() != null) {
					dao.userQualifi_insert(i);
				}
			}
			for(userLicenVO i : licenVo.getLicenList()) {
				if(i.getLicenName() != null) {
					dao.userLicen_insert(i);
				}
			}
			for(userCareerVO i : careerVo.getCareerList()) {
				if(i.getCareerCompName() != null) {
					dao.userCareer_insert(i);
				}
			}
			for(userSkillVO i : skillVo.getSkillList()) {
				if(i.getSkillProjectName() != null) {
					dao.userSkill_insert(i);
				}
			}
			for(userTrainingVO i : trainVo.getTrainList()) {
				if(i.getTrainingName() != null) {
					dao.usereTraining_insert(i);
				}
			}
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
