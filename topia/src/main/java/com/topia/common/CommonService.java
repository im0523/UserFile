package com.topia.common;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

public interface CommonService {
	//파일 upload 처리
	String fileUpload(MultipartFile file, HttpSession ss, String category);
}
