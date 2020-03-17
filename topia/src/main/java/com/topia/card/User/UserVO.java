package com.topia.card.User;

import java.sql.Date;

public class UserVO {
	private int rnum;
	
	private int userIdx;
	private Date userRegisterDate;
	private String userName;
	private String userSocialSecunum;
	private String userSex;
	private String userComp;
	private Date userCompEnterdate;
	private String userDept;
	private String userSpot;
	private String userArmyServ;
	private String userMaritalStatus;
	private Date userArmyServEnter;
	private Date userArmyServLeave;
	private String userArmyServPeriod;
	private String userTelnumWired;
	private String userTelnumWireless;
	private String userEmail;
	private String userZipcode;
	private String userAddress;
//	private UserInfoCareer userInfoCareer;
//	private UserInfoEdu userInfoEdu;
//	private UserInfoLicen userInfoLicen;
//	private UserInfoQualifi userInfoQualifi;
//	private UserInfoSkill userInfoSkill;
//	private UserInfoTraining userInfoTraining;
//	private Image image;
	
	private int careerIdx;
	private String careerCompName;
	private Date careerEnterdate;
	private Date careerLeavedate;
	private String careerSpot;
	private String careerResponsib;
	
	private int eduIdx;
	private String eduSchoolName;
	private String eduStatus;
	private String eduYear;
	private String eduMonth;
	
	private int licenIdx;
	private String licenName;
	private String licenSkillLevel;
	
	private int qualifiIdx;
	private String qualifiName;
	private Date qualifiGetdate;
	
	private int skillIdx;
	private String skillProjectName;
	private Date skillStartdate;
	private Date skillEnddate;
	private String skillCustomerComp;
	private String skillWorkComp;
	private String skillApplied;
	private String skillIndustry;
	private String skillRole;
	private String skillModel;
	private String skillOs;
	private String skillLang;
	private String skillDbms;
	private String skillComm;
	private String skillTool;
	private String skillEtc;
	
	private int trainingIdx;
	private String trainingName;
	private Date trainingStartdate;
	private Date trainingEnddate;
	private String trainingAgency;
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}
	public Date getUserRegisterDate() {
		return userRegisterDate;
	}
	public void setUserRegisterDate(Date userRegisterDate) {
		this.userRegisterDate = userRegisterDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSocialSecunum() {
		return userSocialSecunum;
	}
	public void setUserSocialSecunum(String userSocialSecunum) {
		this.userSocialSecunum = userSocialSecunum;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserComp() {
		return userComp;
	}
	public void setUserComp(String userComp) {
		this.userComp = userComp;
	}
	public Date getUserCompEnterdate() {
		return userCompEnterdate;
	}
	public void setUserCompEnterdate(Date userCompEnterdate) {
		this.userCompEnterdate = userCompEnterdate;
	}
	public String getUserDept() {
		return userDept;
	}
	public void setUserDept(String userDept) {
		this.userDept = userDept;
	}
	public String getUserSpot() {
		return userSpot;
	}
	public void setUserSpot(String userSpot) {
		this.userSpot = userSpot;
	}
	public String getUserArmyServ() {
		return userArmyServ;
	}
	public void setUserArmyServ(String userArmyServ) {
		this.userArmyServ = userArmyServ;
	}
	public String getUserMaritalStatus() {
		return userMaritalStatus;
	}
	public void setUserMaritalStatus(String userMaritalStatus) {
		this.userMaritalStatus = userMaritalStatus;
	}
	public Date getUserArmyServEnter() {
		return userArmyServEnter;
	}
	public void setUserArmyServEnter(Date userArmyServEnter) {
		this.userArmyServEnter = userArmyServEnter;
	}
	public Date getUserArmyServLeave() {
		return userArmyServLeave;
	}
	public void setUserArmyServLeave(Date userArmyServLeave) {
		this.userArmyServLeave = userArmyServLeave;
	}
	public String getUserArmyServPeriod() {
		return userArmyServPeriod;
	}
	public void setUserArmyServPeriod(String userArmyServPeriod) {
		this.userArmyServPeriod = userArmyServPeriod;
	}
	public String getUserTelnumWired() {
		return userTelnumWired;
	}
	public void setUserTelnumWired(String userTelnumWired) {
		this.userTelnumWired = userTelnumWired;
	}
	public String getUserTelnumWireless() {
		return userTelnumWireless;
	}
	public void setUserTelnumWireless(String userTelnumWireless) {
		this.userTelnumWireless = userTelnumWireless;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserZipcode() {
		return userZipcode;
	}
	public void setUserZipcode(String userZipcode) {
		this.userZipcode = userZipcode;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public int getCareerIdx() {
		return careerIdx;
	}
	public void setCareerIdx(int careerIdx) {
		this.careerIdx = careerIdx;
	}
	public String getCareerCompName() {
		return careerCompName;
	}
	public void setCareerCompName(String careerCompName) {
		this.careerCompName = careerCompName;
	}
	public Date getCareerEnterdate() {
		return careerEnterdate;
	}
	public void setCareerEnterdate(Date careerEnterdate) {
		this.careerEnterdate = careerEnterdate;
	}
	public Date getCareerLeavedate() {
		return careerLeavedate;
	}
	public void setCareerLeavedate(Date careerLeavedate) {
		this.careerLeavedate = careerLeavedate;
	}
	public String getCareerSpot() {
		return careerSpot;
	}
	public void setCareerSpot(String careerSpot) {
		this.careerSpot = careerSpot;
	}
	public String getCareerResponsib() {
		return careerResponsib;
	}
	public void setCareerResponsib(String careerResponsib) {
		this.careerResponsib = careerResponsib;
	}
	public int getEduIdx() {
		return eduIdx;
	}
	public void setEduIdx(int eduIdx) {
		this.eduIdx = eduIdx;
	}
	public String getEduSchoolName() {
		return eduSchoolName;
	}
	public void setEduSchoolName(String eduSchoolName) {
		this.eduSchoolName = eduSchoolName;
	}
	public String getEduStatus() {
		return eduStatus;
	}
	public void setEduStatus(String eduStatus) {
		this.eduStatus = eduStatus;
	}
	public String getEduYear() {
		return eduYear;
	}
	public void setEduYear(String eduYear) {
		this.eduYear = eduYear;
	}
	public String getEduMonth() {
		return eduMonth;
	}
	public void setEduMonth(String eduMonth) {
		this.eduMonth = eduMonth;
	}
	public int getLicenIdx() {
		return licenIdx;
	}
	public void setLicenIdx(int licenIdx) {
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
	public int getQualifiIdx() {
		return qualifiIdx;
	}
	public void setQualifiIdx(int qualifiIdx) {
		this.qualifiIdx = qualifiIdx;
	}
	public String getQualifiName() {
		return qualifiName;
	}
	public void setQualifiName(String qualifiName) {
		this.qualifiName = qualifiName;
	}
	public Date getQualifiGetdate() {
		return qualifiGetdate;
	}
	public void setQualifiGetdate(Date qualifiGetdate) {
		this.qualifiGetdate = qualifiGetdate;
	}
	public int getSkillIdx() {
		return skillIdx;
	}
	public void setSkillIdx(int skillIdx) {
		this.skillIdx = skillIdx;
	}
	public String getSkillProjectName() {
		return skillProjectName;
	}
	public void setSkillProjectName(String skillProjectName) {
		this.skillProjectName = skillProjectName;
	}
	public Date getSkillStartdate() {
		return skillStartdate;
	}
	public void setSkillStartdate(Date skillStartdate) {
		this.skillStartdate = skillStartdate;
	}
	public Date getSkillEnddate() {
		return skillEnddate;
	}
	public void setSkillEnddate(Date skillEnddate) {
		this.skillEnddate = skillEnddate;
	}
	public String getSkillCustomerComp() {
		return skillCustomerComp;
	}
	public void setSkillCustomerComp(String skillCustomerComp) {
		this.skillCustomerComp = skillCustomerComp;
	}
	public String getSkillWorkComp() {
		return skillWorkComp;
	}
	public void setSkillWorkComp(String skillWorkComp) {
		this.skillWorkComp = skillWorkComp;
	}
	public String getSkillApplied() {
		return skillApplied;
	}
	public void setSkillApplied(String skillApplied) {
		this.skillApplied = skillApplied;
	}
	public String getSkillIndustry() {
		return skillIndustry;
	}
	public void setSkillIndustry(String skillIndustry) {
		this.skillIndustry = skillIndustry;
	}
	public String getSkillRole() {
		return skillRole;
	}
	public void setSkillRole(String skillRole) {
		this.skillRole = skillRole;
	}
	public String getSkillModel() {
		return skillModel;
	}
	public void setSkillModel(String skillModel) {
		this.skillModel = skillModel;
	}
	public String getSkillOs() {
		return skillOs;
	}
	public void setSkillOs(String skillOs) {
		this.skillOs = skillOs;
	}
	public String getSkillLang() {
		return skillLang;
	}
	public void setSkillLang(String skillLang) {
		this.skillLang = skillLang;
	}
	public String getSkillDbms() {
		return skillDbms;
	}
	public void setSkillDbms(String skillDbms) {
		this.skillDbms = skillDbms;
	}
	public String getSkillComm() {
		return skillComm;
	}
	public void setSkillComm(String skillComm) {
		this.skillComm = skillComm;
	}
	public String getSkillTool() {
		return skillTool;
	}
	public void setSkillTool(String skillTool) {
		this.skillTool = skillTool;
	}
	public String getSkillEtc() {
		return skillEtc;
	}
	public void setSkillEtc(String skillEtc) {
		this.skillEtc = skillEtc;
	}
	public int getTrainingIdx() {
		return trainingIdx;
	}
	public void setTrainingIdx(int trainingIdx) {
		this.trainingIdx = trainingIdx;
	}
	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
	public Date getTrainingStartdate() {
		return trainingStartdate;
	}
	public void setTrainingStartdate(Date trainingStartdate) {
		this.trainingStartdate = trainingStartdate;
	}
	public Date getTrainingEnddate() {
		return trainingEnddate;
	}
	public void setTrainingEnddate(Date trainingEnddate) {
		this.trainingEnddate = trainingEnddate;
	}
	public String getTrainingAgency() {
		return trainingAgency;
	}
	public void setTrainingAgency(String trainingAgency) {
		this.trainingAgency = trainingAgency;
	}
	
}
