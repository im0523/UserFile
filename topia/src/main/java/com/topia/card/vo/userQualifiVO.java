package com.topia.card.vo;

import java.util.List;

public class userQualifiVO {
	private Integer qualifiIdx;
	private Integer userIdx;
	private String qualifiName;
	private String qualifiGetdate;
	private List<userQualifiVO> qualifiList;
	
	
	public Integer getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(Integer userIdx) {
		this.userIdx = userIdx;
	}
	public List<userQualifiVO> getQualifiList() {
		return qualifiList;
	}
	public void setQualifiList(List<userQualifiVO> qualifiList) {
		this.qualifiList = qualifiList;
	}
	public Integer getQualifiIdx() {
		return qualifiIdx;
	}
	public void setQualifiIdx(Integer qualifiIdx) {
		this.qualifiIdx = qualifiIdx;
	}
	public String getQualifiName() {
		return qualifiName;
	}
	public void setQualifiName(String qualifiName) {
		this.qualifiName = qualifiName;
	}
	public String getQualifiGetdate() {
		return qualifiGetdate;
	}
	public void setQualifiGetdate(String qualifiGetdate) {
		this.qualifiGetdate = qualifiGetdate;
	}
	
}
