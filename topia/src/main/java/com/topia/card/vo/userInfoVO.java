package com.topia.card.vo;

public class userInfoVO {
	private Integer totalCnt;
	private Integer no;
	
	private Integer userIdx;
	private String userRegisterDate;
	private String userName;
	private String userSocialSecunum;
	private String userSex;
	private String userComp;
	private String userCompEnterdate;
	private String userDept;
	private String userSpot;
	private String userArmyServ;
	private String userMaritalStatus;
	private String userArmyServEnter;
	private String userArmyServLeave;
	private String userArmyServPeriod;
	private String userTelnumWired;
	private String userTelnumWireless;
	private String userEmail;
	private String userZipcode;
	private String userAddress;
	private Integer careerDate;
	
	//검색조건
	private String userListSearchPeriod;	//검색조건 (이름, 회사, 부서별)
	private String userListSearchWord;	//키워드
	private String userCareerLength;	//경력 기준
	private String genderSelect;		//성별 기준
	private String qualifiSelect;		//자격증 기준
	private int userInfoDataSize;		// 리스트 보여질 갯수(10, 20개)
	
	//연차별 인원조회시
	private String groupListDate;			
	private String groupListCnt;
	
	//paging
	private int startIndex;
	private int endIndex;
	private int curPage;

	
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getUserInfoDataSize() {
		return userInfoDataSize;
	}
	public void setUserInfoDataSize(int userInfoDataSize) {
		this.userInfoDataSize = userInfoDataSize;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getQualifiSelect() {
		return qualifiSelect;
	}
	public void setQualifiSelect(String qualifiSelect) {
		this.qualifiSelect = qualifiSelect;
	}
	public String getGroupListDate() {
		return groupListDate;
	}
	public void setGroupListDate(String groupListDate) {
		this.groupListDate = groupListDate;
	}
	public String getGroupListCnt() {
		return groupListCnt;
	}
	public void setGroupListCnt(String groupListCnt) {
		this.groupListCnt = groupListCnt;
	}
	public String getGenderSelect() {
		return genderSelect;
	}
	public void setGenderSelect(String genderSelect) {
		this.genderSelect = genderSelect;
	}
	public String getUserCareerLength() {
		return userCareerLength;
	}
	public void setUserCareerLength(String userCareerLength) {
		this.userCareerLength = userCareerLength;
	}
	public String getUserListSearchPeriod() {
		return userListSearchPeriod;
	}
	public void setUserListSearchPeriod(String userListSearchPeriod) {
		this.userListSearchPeriod = userListSearchPeriod;
	}
	public String getUserListSearchWord() {
		return userListSearchWord;
	}
	public void setUserListSearchWord(String userListSearchWord) {
		this.userListSearchWord = userListSearchWord;
	}
	public Integer getCareerDate() {
		return careerDate;
	}
	public void setCareerDate(Integer careerDate) {
		this.careerDate = careerDate;
	}
	public Integer getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(Integer totalCnt) {
		this.totalCnt = totalCnt;
	}
	public Integer getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(Integer userIdx) {
		this.userIdx = userIdx;
	}
	public String getUserRegisterDate() {
		return userRegisterDate;
	}
	public void setUserRegisterDate(String userRegisterDate) {
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
	public String getUserCompEnterdate() {
		return userCompEnterdate;
	}
	public void setUserCompEnterdate(String userCompEnterdate) {
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
	public String getUserArmyServEnter() {
		return userArmyServEnter;
	}
	public void setUserArmyServEnter(String userArmyServEnter) {
		this.userArmyServEnter = userArmyServEnter;
	}
	public String getUserArmyServLeave() {
		return userArmyServLeave;
	}
	public void setUserArmyServLeave(String userArmyServLeave) {
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
	
	
}
