package com.topia.card.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.topia.card.User.UserService;
import com.topia.card.vo.userCareerVO;
import com.topia.card.vo.userEduVO;
import com.topia.card.vo.userInfoVO;
import com.topia.card.vo.userLicenVO;
import com.topia.card.vo.userQualifiVO;
import com.topia.card.vo.userSkillVO;
import com.topia.card.vo.userTrainingVO;
import com.topia.common.CommonUtil;

@Controller
public class UserController {
	@Autowired UserService service;
	
	@RequestMapping(value="/topia/userInsert.do", method = RequestMethod.POST)
	@ResponseBody 
	public String userInsert(userInfoVO infoVo, userCareerVO careerVo, userEduVO eduVo, userLicenVO licenVo,
							userQualifiVO qualifiVo, userSkillVO skillVo, userTrainingVO trainVo) throws IOException {
		HashMap<String, String> result = new HashMap<String, String>();
		CommonUtil commonUtil = new CommonUtil();
		int resultCnt = service.user_insert(infoVo, careerVo, eduVo, licenVo, qualifiVo, skillVo, trainVo);
		
		result.put("success", (resultCnt > 0)?"Y":"N");
		String callbackMsg = commonUtil.getJsonCallBackString(" ",result);
		
		System.out.println("callbackMsg::"+callbackMsg);
		
		return callbackMsg;
	}
	
	//불러오기 버튼 눌렀을 시 user List조회
	@RequestMapping("/topia/userList.do")
	public String loadCard(Model model, userInfoVO infoVo) {
		
		int totalCnt = service.list_totalCnt(infoVo);
		
		List<userInfoVO> list = service.user_list(infoVo);
		
		model.addAttribute("list", list);
		model.addAttribute("totalCnt", totalCnt);
		
		return "userList";
	}
	
	//불러오기 시 연차별 인원보기 조회
	@RequestMapping("/topia/groupList.do")
	public String groupInfo(Model model) {
		
		List<userInfoVO> groupList = service.groupList();
		
		model.addAttribute("groupList", groupList);
		return "groupList";
	}
	
	@RequestMapping("/topia/userDetail.do")
	@ResponseBody 
	public Map<String, Object> userDetail(int userIdx) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		
		userInfoVO userInfo = service.user_detail(userIdx);
		List<userEduVO> userEduList = service.userEdu_detail(userIdx);
		List<userCareerVO> userCareerList = service.userCareer_detail(userIdx);
		List<userLicenVO> userLicenList = service.userLicen_detail(userIdx);
		List<userQualifiVO> userQualifiList = service.userQualifi_detail(userIdx);
		List<userSkillVO> userSkillList = service.userSkill_detail(userIdx);
		List<userTrainingVO> userTrainingList = service.userTraining_detail(userIdx);
		
		map.put("userInfo", userInfo);
		map.put("userEduList", userEduList);
		map.put("userCareerList", userCareerList);
		map.put("userLicenList", userLicenList);
		map.put("userQualifiList", userQualifiList);
		map.put("userSkillList", userSkillList);
		map.put("userTrainingList", userTrainingList);
		
		return map;
	}
	
	@RequestMapping("/topia/userUpdate.do")
	@ResponseBody
	public Map<String, Object> userUpdate(userInfoVO infoVo, userCareerVO careerVo, userEduVO eduVo, userLicenVO licenVo,
										userQualifiVO qualifiVo, userSkillVO skillVo, userTrainingVO trainVo) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		
		int result = service.user_update(infoVo, careerVo, eduVo, licenVo, qualifiVo, skillVo, trainVo);
		
		if( result == 1) {
			map.put("result", "success");
		}else if( result < 1) {
			map.put("result", "fail");
		}
		
		return map;
	}
}
