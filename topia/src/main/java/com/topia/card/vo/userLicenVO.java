package com.topia.card.vo;

import java.util.List;

public class userLicenVO {
	private Integer licenIdx;
	private Integer userIdx;
	private String licenName;
	private String licenSkillLevel;
	private List<userInfoVO> licenList;
	
	
	public Integer getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(Integer userIdx) {
		this.userIdx = userIdx;
	}
	public List<userInfoVO> getLicenList() {
		return licenList;
	}
	public void setLicenList(List<userInfoVO> licenList) {
		this.licenList = licenList;
	}
	public Integer getLicenIdx() {
		return licenIdx;
	}
	public void setLicenIdx(Integer licenIdx) {
		this.licenIdx = licenIdx;
	}
	public String getLicenName() {
		return licenName;
	}
	public void setLicenName(String licenName) {
		this.licenName = licenName;
	}
	public String getLicenSkillLevel() {
		return licenSkillLevel;
	}
	public void setLicenSkillLevel(String licenSkillLevel) {
		this.licenSkillLevel = licenSkillLevel;
	}
	
	
}
