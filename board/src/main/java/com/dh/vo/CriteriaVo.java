package com.dh.vo;



public class CriteriaVo {
	private int page; 			// 페이지 번호
	private int perPageNum; 	// 페이지당 게시글 갯수
	private int rowStart; 		// 페이지 한 행의 첫번째 게시물 rowNum
	private int rowEnd; 		// 페이지 한 행의 마지막 게시물 rowNum
	
	public CriteriaVo() {		
		this.page = 1; 			// 페이지 1 로 초기화
		this.perPageNum = 10;	// 페이지당 게시글 10개
	}
	
	public void setPage(int page) {
		if (page <= 0) {		// 0이하 숫자가 들어가면(이상한값이 들어오면)
			this.page = 1;		// 1페이지가 나오게 설정
			return;
		}
		this.page = page;
	}
	
	public void setPerPageNum(int perPageNum) {		
		if (perPageNum <= 0 || perPageNum > 100) { 	// 페이지당 게시글 숫자가 0이하이거나 100개이상 이면
			this.perPageNum = 10;					// 페이지당 게시글 숫자가 10개나오도록 설정
			return;
		}
		this.perPageNum = perPageNum;
	}
	
	public int getPage() {
		return page;
	}
	
	public int getPageStart() {
		return (this.page - 1) * perPageNum; 		// 현재 페이지당 게시글 수를 곱하여 현재 페이지의 시작 													
	}												// 현재 페이지의 시작 게시글 ROWNUM수를 구하는것
	
	public int getPerPageNum() {
		return this.perPageNum;						
	}
	
	public int getRowStart() {
		rowStart = ((page - 1) * perPageNum) + 1;
		return rowStart;
	}
	
	public int getRowEnd() {
		rowEnd = rowStart + perPageNum - 1;
		return rowEnd;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", rowStart=" + rowStart + ", rowEnd=" + rowEnd
				+ "]";
	}


	
	
}
