package com.topia.card.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

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
	
	@RequestMapping("/topia/userList.do")
	public String loadCard(Model model, userInfoVO infoVo) {
		
		List<userInfoVO> list = service.user_list(infoVo);
		
		model.addAttribute("list", list);
		
		return "userList";
	}
}
