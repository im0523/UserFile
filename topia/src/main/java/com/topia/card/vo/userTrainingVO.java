package com.topia.card.vo;

import java.util.List;

public class userTrainingVO {
	private Integer trainingIdx;
	private Integer userIdx;
	private String trainingName;
	private String trainingStartdate;
	private String trainingEnddate;
	private String trainingAgency;
	private List<userInfoVO> trainList;
	public Integer getTrainingIdx() {
		return trainingIdx;
	}
	public void setTrainingIdx(Integer trainingIdx) {
		this.trainingIdx = trainingIdx;
	}
	public Integer getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(Integer userIdx) {
		this.userIdx = userIdx;
	}
	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
	public String getTrainingStartdate() {
		return trainingStartdate;
	}
	public void setTrainingStartdate(String trainingStartdate) {
		this.trainingStartdate = trainingStartdate;
	}
	public String getTrainingEnddate() {
		return trainingEnddate;
	}
	public void setTrainingEnddate(String trainingEnddate) {
		this.trainingEnddate = trainingEnddate;
	}
	public String getTrainingAgency() {
		return trainingAgency;
	}
	public void setTrainingAgency(String trainingAgency) {
		this.trainingAgency = trainingAgency;
	}
	public List<userInfoVO> getTrainList() {
		return trainList;
	}
	public void setTrainList(List<userInfoVO> trainList) {
		this.trainList = trainList;
	}
	
}
