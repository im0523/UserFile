package com.topia.card.Controller;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.topia.card.User.UserServiceImpl;
import com.topia.card.User.UserVO;
import com.topia.common.CommonUtil;

@Controller
public class UserController {
	@Autowired UserServiceImpl service;

	@ResponseBody @RequestMapping("/userInsert.do")
	public String userInsert(UserVO vo, Model model) throws IOException {
		HashMap<String, String> result = new HashMap<String, String>();
		CommonUtil commonUtil = new CommonUtil();
		
		int resultCnt = service.user_insert(vo);
		
		result.put("success", (resultCnt > 0)?"Y":"N");
		String callbackMsg = commonUtil.getJsonCallBackString(" ",result);
		
		System.out.println("callbackMsg::"+callbackMsg);
		
		return callbackMsg;
	}
}
