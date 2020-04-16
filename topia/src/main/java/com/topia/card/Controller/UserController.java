package com.topia.card.Controller;

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
//	private CommonService common;
	
	//사원 등록처리
	@RequestMapping(value="/topia/userInsert.do", method = RequestMethod.POST)
	@ResponseBody 
	public String userInsert(userInfoVO infoVo, userCareerVO careerVo, userEduVO eduVo, userLicenVO licenVo,
							userQualifiVO qualifiVo, userSkillVO skillVo, userTrainingVO trainVo,
							HttpSession ss ) throws IOException {
		
		HashMap<String, String> result = new HashMap<String, String>();
		CommonUtil commonUtil = new CommonUtil();
		CommonServiceImpl common = new CommonServiceImpl();

		String filePath = common.fileUpload(infoVo.getUserFilepathReal(), ss, "card");
		
		infoVo.setUserFilepath(filePath); 

		int resultCnt = service.user_insert(infoVo, careerVo, eduVo, licenVo, qualifiVo, skillVo, trainVo);
		
		result.put("success", (resultCnt > 0)?"Y":"N");
		String callbackMsg = commonUtil.getJsonCallBackString(" ",result);
		
		System.out.println("callbackMsg::"+callbackMsg);
		
		return callbackMsg;
	}
	
	
//	public String fileUpload(MultipartFile file, HttpSession ss, String category) {
//		System.out.println("왔나?");
//		// 업로드 할 서버의 물리적 위치
//		// D://Spring/..../topia/resources
//		String resources = ss.getServletContext().getRealPath("resources");
//		// D://Spring/..../topia/resources/upload
//		String upload = resources + "/" + "upload";
//		// String upload = resources + file.seperator + "upload";
//		
//		// D://Spring/..../topia/resources/upload/card/2020/04/16
//		String folder = makeFolder(category, upload);
//		String uuid = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
//		
//		try {
//			// 생성한 폴더에 업로드한 파일 저장하기
//			file.transferTo(new File(folder, uuid));
//		} catch (Exception e) {
//		}
//
//		// /upload/card/2020/04/16/44asdg_abc.txt 내가 필요한 건 upload 부터니까
//		return folder.substring( resources.length() ) + File.separator + uuid;
////		return folder.substring( resources.length() ) + "/" + uuid;
//	}
//	
//	public String makeFolder(String category, String upload) {
//		StringBuffer folder = new StringBuffer(upload);
//		// D://Spring/..../topia/resources/upload/card
//		folder.append("/" + category);
//		Date now = new Date();
//		// D://Spring/..../topia/resources/upload/card/2020
//		folder.append("/" + new SimpleDateFormat("yyyy/MM/dd").format(now));
//		
//		// 해당 폴더가 있는지 확인하여 없으면 폴더 생성
//		File dir = new File(folder.toString());
//		if( !dir.exists() ) {
//			dir.mkdirs(); // 폴더가 여러개니까 mkdir이 아니라 mkdirs
//		}
//		
//		return folder.toString();
//	}
	
	
	
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
