package com.topia.common;

public class PageVO {
	private int pageSize = 10;		// 한 페이지당 게시글 수
	private int blockPage = 5;		// 한 블럭당 나타낼 페이지 수
	private int curPage = 1;		// 현재 페이지
	private int curBlock = 1;		// 현재 블럭
	private int listCnt;			// 총 게시글 수
	private int totalPage;			// 총 페이지 수
	private int totalBlock;			// 총 블럭 수
	private int startPage = 1;		// 블럭의 시작페이지
	private int endPage = 1;		// 블럭의 끝페이지
	private int startIndex;			// 쿼리 시작 인덱스
	private int endIndex;			// 쿼리 끝 인덱스 
	private int prevPage;			// 이전 페이지
	private int nextPage;			// 다음 페이지
	
	public PageVO() {}
	
	public PageVO(int listCnt, int curPage) {
		setCurPage(curPage);	// 현재페이지
		
		setStartIndex(curPage);
		setEndIndex(curPage);
		
		setListCnt(listCnt);	// 총 게시물 수
		
		setTotalPage(listCnt);	// 총 페이지 수
		
		setTotalBlock(curPage);	// 총 블럭 수
		
		rangeSetting(curPage);	// 블럭 세팅
	}
	
	public void setTotalPage(int listCnt) {
		this.totalPage = (int) Math.ceil(listCnt*1.0/pageSize);	// 1. 총 페이지 수 = 총 게시글 수 / 한 페이지당 게시글 수
	}
	
	public void setTotalBlock(int totalBlock) {
		this.totalBlock = (int) Math.ceil(totalPage*1.0/blockPage);	// 2. 총 블럭 수 : 총 페이지 수 / 한 블럭당 나타낼 페이지 수
	}
	
	public void rangeSetting(int curPage) {
		setCurBlock(curPage);        
        this.startPage = (curBlock - 1) * blockPage + 1;		// 3. 현재 출력되는 블럭의 시작페이지번호와 끝 페이지 번호 계산
        this.endPage = startPage + blockPage - 1;				// 4. 3번과 동일(현재 블럭의 끝 페이지 번호계산)
        
        if(endPage > totalPage){				// 5. 이 if문은 맨 처음의 페이지번호는 1로 고정이지만 마지막 블럭의 마지막페이지 번호는 
            this.endPage = totalPage;			// 전체 페이지에 따라 달라지기에 총 페이지 수보다 마지막 페이지가 커질 수 없게 막음.
        }
        
	}
	
	public void setCurBlock(int curBlock){
		this.curBlock = (int)((curPage-1)/blockPage) + 1;
	}

	public void setStartIndex(int curPage) {
		this.startIndex = (curPage - 1) * 10 + 1;
	}

	public void setEndIndex(int curPage) {
		this.endIndex = (curPage) * 10;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getBlockPage() {
		return blockPage;
	}

	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getListCnt() {
		return listCnt;
	}

	public void setListCnt(int listCnt) {
		this.listCnt = listCnt;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getCurBlock() {
		return curBlock;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getTotalBlock() {
		return totalBlock;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}
	
	
}
