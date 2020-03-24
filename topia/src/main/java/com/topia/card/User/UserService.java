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
	//CRUD
	List<userInfoVO> user_list(userInfoVO vo);		//불러오기 userList 조회
	userInfoVO user_detail(int userIdx);
	int user_insert(userInfoVO infoVo, userCareerVO careerVo, userEduVO eduVo, userLicenVO licenVo,
					userQualifiVO qualifiVo, userSkillVO skillVo, userTrainingVO trainVo);
	void user_update(userInfoVO vo);
	void user_delete(int userIdx);
}
