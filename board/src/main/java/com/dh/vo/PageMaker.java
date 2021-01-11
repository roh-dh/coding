package com.dh.vo;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {

	private int totalCount;	//게시글 총 갯수
	private int startPage; // 10개의 페이지중 첫번째
	private int endPage; // 10개의 페이지중 마지막
	private boolean prev; // 페이지 이전 버튼
	private boolean next; // 페이지 다음 버튼
	private int displayPageNum = 10; //보여지는 페이지 개수
	private CriteriaVo cri; //페이지 정보 객체
	
	public void setCri(CriteriaVo cri) {
		this.cri = cri;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	
	public int getStartPage() {
		return startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	
	public boolean isPrev() {
		return prev;
	}
	
	public boolean isNext() {
		return next;
	}
	
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	
	public CriteriaVo getCri() {
		return cri;
	}
	 
	private void calcData() {
		//1~10page는 마지막 페이지가 10으로 고정되어야함 , 11~20page는 마지막 페이지가 20으로 고정되어야함
		endPage = (int) (Math.ceil(cri.getPage() / (double)displayPageNum) * displayPageNum);
		startPage = (endPage - displayPageNum) + 1; 
	  
		// [이전] 132 133 134의  134번 처럼  찐 마지막 페이지 번호 = 총 게시글 갯수 / 페이지당 게시글 갯수로 나누고 올림하면 됨 딱 떨어짐   
		int tempEndPage = (int) (Math.ceil(totalCount / (double)cri.getPerPageNum()));
		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		//이전 버튼 생성 여부 = 시작페이지가  1이 아니면  생기면 된다.
		prev = startPage == 1 ? false : true;		
		//다음 버튼 생성 여부 =  마지막페이지 *페이지당 게시글수 >= 총페이지 갯수 안생기면되고 아니면 생기면 됨
		next = endPage * cri.getPerPageNum() >= totalCount ? false : true;
	}
	
//	makeQuery() : 이 메소드는 스프링에서 지원 해주는 객체를 가지고 있습니다 UriComponent라는 객체입니다. 
//	이 놈은<a href="/list?page=2&perPageNum=10"> 을 작성할 때 파라미터를 동적으로 넘겨줄 수 있는 객체입니다.	
	public String makeQuery(int page) {
		UriComponents uriComponents =
		UriComponentsBuilder.newInstance()
						    .queryParam("page", page)
							.queryParam("perPageNum", cri.getPerPageNum())
							.build();
		   
		return uriComponents.toUriString();
	}
/*	Criteria cri: 위에서 만든 page와 perPageNum을 가지고 있는 객체
	int totalCount: 전체 게시글 수
	int startPage: 시작 페이지, 현재 페이지가 12쪽이면 11쪽이 startPage 현재 페이지가 28쪽이면 21쪽이 startPage가 됩니다.
	int endPage: 마지막 페이지
	boolean prev: [이전] 버튼의 생성 조건이 되는 필드
	boolean next: [다음] 버튼의 생성 조건이 되는 필드
*/	
}