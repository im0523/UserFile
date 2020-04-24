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
//		System.out.println(infoVo.getUserIdx());
		if( result==1 ) {
			for(userEduVO i : eduVo.getEduList()) {
//				System.out.println(i + "//" + i.getEduSchoolName());
				if(i.getEduSchoolName() != null && i.getEduStatus() != null && i.getEduYear() != null && i.getEduMonth() != null) {
					if(!i.getEduSchoolName().equals("") || !i.getEduStatus().equals("") || !i.getEduYear().equals("") || !i.getEduMonth().equals("")) {
						i.setUserIdx(infoVo.getUserIdx());
						dao.userEdu_insert(i);
					}
				}
			}
			for(userQualifiVO i : qualifiVo.getQualifiList()) {
				if(i.getQualifiName() != null && i.getQualifiGetdate() != null) {
					if(!i.getQualifiName().equals("") || !i.getQualifiGetdate().equals("")) {
						i.setUserIdx(infoVo.getUserIdx());
						dao.userQualifi_insert(i);
					}
				}
			}
			for(userLicenVO i : licenVo.getLicenList()) {
				if(i.getLicenName() != null && i.getLicenSkillLevel() != null) {
					if(!i.getLicenName().equals("") || !i.getLicenSkillLevel().equals("")) {
						i.setUserIdx(infoVo.getUserIdx());
						dao.userLicen_insert(i);
					}
				}
			}
			for(userCareerVO i : careerVo.getCareerList()) {
				if(i.getCareerCompName() != null && i.getCareerEnterdate() != null && i.getCareerLeavedate() != null && i.getCareerSpot() != null && i.getCareerResponsib() != null) {
					if(!i.getCareerCompName().equals("") || !i.getCareerEnterdate().equals("") || !i.getCareerLeavedate().equals("") || !i.getCareerSpot().equals("") || !i.getCareerResponsib().equals("")) {
						i.setUserIdx(infoVo.getUserIdx());
						dao.userCareer_insert(i);
					}
				}
			}
			for(userSkillVO i : skillVo.getSkillList()) {
				if(i.getSkillProjectName() != null && i.getSkillStartdate() != null && i.getSkillEnddate() != null && i.getSkillCustomerComp() != null && i.getSkillWorkComp() != null
						&& i.getSkillIndustry() != null && i.getSkillApplied() != null && i.getSkillRole() != null && i.getSkillModel() != null && i.getSkillOs() != null && i.getSkillLang() != null
						&& i.getSkillDbms() != null && i.getSkillTool() != null && i.getSkillComm() != null && i.getSkillEtc() != null) {
					if(!i.getSkillProjectName().equals("") || !i.getSkillStartdate().equals("") || !i.getSkillEnddate().equals("") || !i.getSkillCustomerComp().equals("") || !i.getSkillWorkComp().equals("")
						|| !i.getSkillIndustry().equals("") || !i.getSkillApplied().equals("")	|| !i.getSkillRole().equals("") || !i.getSkillModel().equals("") || !i.getSkillOs().equals("") || !i.getSkillLang().equals("")
						|| !i.getSkillDbms().equals("") || !i.getSkillTool().equals("") || !i.getSkillComm().equals("") || !i.getSkillEtc().equals("")) {
						i.setUserIdx(infoVo.getUserIdx());
						dao.userSkill_insert(i);
					}
				}
			}
			for(userTrainingVO i : trainVo.getTrainList()) {
				if(i.getTrainingName() != null && i.getTrainingStartdate() != null && i.getTrainingEnddate() != null & i.getTrainingAgency() != null) {
					if(!i.getTrainingName().equals("") || !i.getTrainingStartdate().equals("") || !i.getTrainingEnddate().equals("") || !i.getTrainingAgency().equals("")) {
						i.setUserIdx(infoVo.getUserIdx());
						dao.usereTraining_insert(i);
					}
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
					if(i.getEduSchoolName() != null && i.getEduStatus() != null && i.getEduYear() != null && i.getEduMonth() != null) {
						if(!i.getEduSchoolName().equals("") || !i.getEduStatus().equals("") || !i.getEduYear().equals("") || !i.getEduMonth().equals("")) {
							i.setUserIdx(infoVo.getUserIdx());
							dao.userEdu_insert(i);
						}
					}
				}
//			}
				for(userCareerVO i : careerVo.getCareerList()) {
					if(i.getCareerCompName() != null && i.getCareerEnterdate() != null && i.getCareerLeavedate() != null && i.getCareerSpot() != null && i.getCareerResponsib() != null) {
						if(!i.getCareerCompName().equals("") || !i.getCareerEnterdate().equals("") || !i.getCareerLeavedate().equals("") || !i.getCareerSpot().equals("") || !i.getCareerResponsib().equals("")) {
							i.setUserIdx(infoVo.getUserIdx());
							dao.userCareer_insert(i);
						}
					}
				}
				for(userQualifiVO i : qualifiVo.getQualifiList()) {
					if(i.getQualifiName() != null && i.getQualifiGetdate() != null) {
						if(!i.getQualifiName().equals("") || !i.getQualifiGetdate().equals("")) {
							i.setUserIdx(infoVo.getUserIdx());
							dao.userQualifi_insert(i);
						}
					}
				}
				for(userLicenVO i : licenVo.getLicenList()) {
					if(i.getLicenName() != null && i.getLicenSkillLevel() != null) {
						if(!i.getLicenName().equals("") || !i.getLicenSkillLevel().equals("")) {
							i.setUserIdx(infoVo.getUserIdx());
							dao.userLicen_insert(i);
						}
					}
				}
				for(userSkillVO i : skillVo.getSkillList()) {
					if(i.getSkillProjectName() != null && i.getSkillStartdate() != null && i.getSkillEnddate() != null && i.getSkillCustomerComp() != null && i.getSkillWorkComp() != null
							&& i.getSkillIndustry() != null && i.getSkillApplied() != null && i.getSkillRole() != null && i.getSkillModel() != null && i.getSkillOs() != null && i.getSkillLang() != null
							&& i.getSkillDbms() != null && i.getSkillTool() != null && i.getSkillComm() != null && i.getSkillEtc() != null) {
						if(!i.getSkillProjectName().equals("") || !i.getSkillStartdate().equals("") || !i.getSkillEnddate().equals("") || !i.getSkillCustomerComp().equals("") || !i.getSkillWorkComp().equals("")
								|| !i.getSkillIndustry().equals("") || !i.getSkillApplied().equals("")	|| !i.getSkillRole().equals("") || !i.getSkillModel().equals("") || !i.getSkillOs().equals("") || !i.getSkillLang().equals("")
								|| !i.getSkillDbms().equals("") || !i.getSkillTool().equals("") || !i.getSkillComm().equals("") || !i.getSkillEtc().equals("")) {
								i.setUserIdx(infoVo.getUserIdx());
								dao.userSkill_insert(i);
						}
					}
				}
				for(userTrainingVO i : trainVo.getTrainList()) {
					if(i.getTrainingName() != null && i.getTrainingStartdate() != null && i.getTrainingEnddate() != null & i.getTrainingAgency() != null) {
						if(!i.getTrainingName().equals("") || !i.getTrainingStartdate().equals("") || !i.getTrainingEnddate().equals("") || !i.getTrainingAgency().equals("")) {
							i.setUserIdx(infoVo.getUserIdx());
							dao.usereTraining_insert(i);
						}
					}
				}
		}
		
		return result;
	}

	//연차별 인원정보 불러오기
	@Override
	public List<userInfoVO> groupList() {
		return dao.groupList();
	}


}
