package com.topia.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CommonServiceImpl implements CommonService {

	@Override
	public String fileUpload(MultipartFile file, HttpSession ss, String category) {
		System.out.println("왔나?");
		// 업로드 할 서버의 물리적 위치
		// D://Spring/..../topia/resources
		String resources = ss.getServletContext().getRealPath("resources");
		// D://Spring/..../topia/resources/upload
		String upload = resources + "/" + "upload";
		// String upload = resources + file.seperator + "upload";
		
		// D://Spring/..../topia/resources/upload/card/2020/04/16
		String folder = makeFolder(category, upload);
		String uuid = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		
		try {
			// 생성한 폴더에 업로드한 파일 저장하기
			file.transferTo(new File(folder, uuid));
		} catch (Exception e) {
		}

		// /upload/card/2020/04/16/44asdg_abc.txt 내가 필요한 건 upload 부터니까
		return folder.substring( resources.length() ) + File.separator + uuid;
//		return folder.substring( resources.length() ) + "/" + uuid;
	}
	
	public String makeFolder(String category, String upload) {
		StringBuffer folder = new StringBuffer(upload);
		// D://Spring/..../topia/resources/upload/card
		folder.append("/" + category);
		Date now = new Date();
		// D://Spring/..../topia/resources/upload/card/2020
		folder.append("/" + new SimpleDateFormat("yyyy/MM/dd").format(now));
		
		// 해당 폴더가 있는지 확인하여 없으면 폴더 생성
		File dir = new File(folder.toString());
		if( !dir.exists() ) {
			dir.mkdirs(); // 폴더가 여러개니까 mkdir이 아니라 mkdirs
		}
		
		return folder.toString();
	}

}
