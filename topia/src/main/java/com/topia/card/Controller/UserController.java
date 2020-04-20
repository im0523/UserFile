package com.topia.card.Controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.topia.card.User.UserService;
import com.topia.card.vo.userCareerVO;
import com.topia.card.vo.userEduVO;
import com.topia.card.vo.userInfoVO;
import com.topia.card.vo.userLicenVO;
import com.topia.card.vo.userQualifiVO;
import com.topia.card.vo.userSkillVO;
import com.topia.card.vo.userTrainingVO;
import com.topia.common.CommonServiceImpl;
import com.topia.common.CommonUtil;
import com.topia.common.PageVO;

@Controller
public class UserController {
	@Autowired private UserService service;
	
	//사원 등록처리
	@RequestMapping(value="/topia/userInsert.do", method = RequestMethod.POST)
	@ResponseBody 
	public String userInsert(userInfoVO infoVo, userCareerVO careerVo, userEduVO eduVo, userLicenVO licenVo,
							userQualifiVO qualifiVo, userSkillVO skillVo, userTrainingVO trainVo,
							HttpSession ss ) throws IOException {
		
		HashMap<String, String> result = new HashMap<String, String>();
		CommonUtil commonUtil = new CommonUtil();
		CommonServiceImpl common = new CommonServiceImpl();

		if( infoVo.getUserFilepathReal().getSize() > 0 ) {
			String filePath = common.fileUpload(infoVo.getUserFilepathReal(), ss, "card");
			infoVo.setUserFilepath(filePath); 
		}
		
		int resultCnt = service.user_insert(infoVo, careerVo, eduVo, licenVo, qualifiVo, skillVo, trainVo);
		
		result.put("success", (resultCnt > 0)?"Y":"N");
		String callbackMsg = commonUtil.getJsonCallBackString(" ",result);
		
		System.out.println("callbackMsg::"+callbackMsg);
		
		return callbackMsg;
	}
	
	
	
	//불러오기 버튼 눌렀을 시 user List조회
	@RequestMapping("/topia/userList.do")
	public String loadCard(Model model, userInfoVO infoVo, @RequestParam(defaultValue = "1") int curPage) {
		
		int totalCnt = service.list_totalCnt(infoVo);
		
		PageVO page = new PageVO(totalCnt, curPage, infoVo.getUserInfoDataSize());
		infoVo.setStartIndex(page.getStartIndex());
		infoVo.setEndIndex(page.getEndIndex());
		
		//전체 리스트 출력
		List<userInfoVO> list = service.user_list(infoVo);
		
		model.addAttribute("list", list);
		model.addAttribute("page", page);
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
	
	//불러오기 시 한 명의 사원에 대한 detail 정보 뿌리기
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
	
	//
	@RequestMapping("/topia/userUpdate.do")
	@ResponseBody
	public Map<String, Object> userUpdate(userInfoVO infoVo, userCareerVO careerVo, userEduVO eduVo, userLicenVO licenVo,
										userQualifiVO qualifiVo, userSkillVO skillVo, userTrainingVO trainVo,
										HttpSession ss, int deleteImg) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		CommonServiceImpl common = new CommonServiceImpl();

		// 기존 이미지가 첨부되어 있을 경우, 기존 파일을 삭제하기 위한 처리
		userInfoVO old = service.user_detail(infoVo.getUserIdx());
		String uuid = ss.getServletContext().getRealPath("resources") + old.getUserFilepath();
		
		System.out.println("deleteImg"+deleteImg);
		// 추가하려는 파일이 있을 때
		if( infoVo.getUserFilepathReal().getSize() > 0 ) {	//첨부하려는 파일이 있을 때
			File f = new File(uuid);	// 먼저 기존에 저장되어 있는 파일의 물리적 주소를 받아와
			f.delete();		//삭제시키고
			
			//파일 업로드 하는 처리
			String filePath = common.fileUpload(infoVo.getUserFilepathReal(), ss, "card");
			infoVo.setUserFilepath(filePath);
		// 파일을 첨부하지 않을 때
		}else {
			// 원래 첨부된 파일을 그대로 사용하는 경우
			if( deleteImg == 1) {
				infoVo.setUserFilepath(old.getUserFilepath());
			}else {
				// 기존에 있던 파일을 삭제하고 파일을 첨부하지 않을 때
				File f = new File(uuid);
				if( f.exists() ) f.delete();
			}
		}
		
		int result = service.user_update(infoVo, careerVo, eduVo, licenVo, qualifiVo, skillVo, trainVo);
		
		if( result == 1) {
			map.put("result", "success");
		}else if( result < 1) {
			map.put("result", "fail");
		}
		
		return map;
	}
}
