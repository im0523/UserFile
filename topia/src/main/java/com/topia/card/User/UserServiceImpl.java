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

	//불러오기 list 조회
	@Override
	public List<userInfoVO> user_list(userInfoVO vo) {
		return dao.user_list(vo);
	}

	//불러오기 totalCnt 조회
	@Override
	public int list_totalCnt(userInfoVO infoVo) {
		return dao.list_totalCnt(infoVo);
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
				if(i.getEduSchoolName().equals("") == false) {
					dao.userEdu_insert(i);
				}
			}
			for(userQualifiVO i : qualifiVo.getQualifiList()) {
				if(i.getQualifiName().equals("") == false) {
					dao.userQualifi_insert(i);
				}
			}
			for(userLicenVO i : licenVo.getLicenList()) {
				if(i.getLicenName().equals("") == false) {
					dao.userLicen_insert(i);
				}
			}
			for(userCareerVO i : careerVo.getCareerList()) {
				if(i.getCareerCompName().equals("") == false) {
					dao.userCareer_insert(i);
				}
			}
			for(userSkillVO i : skillVo.getSkillList()) {
				if(i.getSkillProjectName().equals("") == false) {
					dao.userSkill_insert(i);
				}
			}
			for(userTrainingVO i : trainVo.getTrainList()) {
				if(i.getTrainingName().equals("") == false) {
					dao.usereTraining_insert(i);
				}
			}
		}
		return result;
		
	}

	//불러오기 후 update 처리
	@Override
	public int user_update(userInfoVO infoVo, userCareerVO careerVo, userEduVO eduVo, userLicenVO licenVo,
							userQualifiVO qualifiVo, userSkillVO skillVo, userTrainingVO trainVo) {
		int result = dao.userInfo_update(infoVo);

		dao.userEdu_delete(infoVo.getUserIdx());
		dao.userCareer_delete(infoVo.getUserIdx());
		dao.userQualifi_delete(infoVo.getUserIdx());
		dao.userLicen_delete(infoVo.getUserIdx());
		dao.userSkill_delete(infoVo.getUserIdx());
		dao.userTraining_delete(infoVo.getUserIdx());
		
		if( result == 1 ) {
//			if(eduVo.getEduList().size() > 0) {
				for(userEduVO i : eduVo.getEduList()) {
//					System.out.println(eduVo.getEduList());
					if(i.getEduSchoolName() != null) {
						i.setUserIdx(infoVo.getUserIdx());
						dao.userEdu_insert(i);
					}
				}
//			}
				for(userCareerVO i : careerVo.getCareerList()) {
					if(i.getCareerCompName() != null) {
						i.setUserIdx(infoVo.getUserIdx());
						dao.userCareer_insert(i);
					}
				}
				for(userQualifiVO i : qualifiVo.getQualifiList()) {
					if(i.getQualifiName() != null) {
						i.setUserIdx(infoVo.getUserIdx());
						dao.userQualifi_insert(i);
					}
				}
				for(userLicenVO i : licenVo.getLicenList()) {
					if(i.getLicenName() != null) {
						i.setUserIdx(infoVo.getUserIdx());
						dao.userLicen_insert(i);
					}
				}
				for(userSkillVO i : skillVo.getSkillList()) {
					if(i.getSkillProjectName() != null) {
						i.setUserIdx(infoVo.getUserIdx());
						dao.userSkill_insert(i);
					}
				}
				for(userTrainingVO i : trainVo.getTrainList()) {
					if(i.getTrainingName() != null) {
						i.setUserIdx(infoVo.getUserIdx());
						dao.usereTraining_insert(i);
					}
				}
		}
		
		return result;
	}


}
