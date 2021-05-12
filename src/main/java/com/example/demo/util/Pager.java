package com.example.demo.util;

public class Pager {
	private Long curPage;
	private Long perPage;
	
	private Long startNow;
	
	public void makeRow() {
		//curPage가 1이면 startRow=0 2면 10
		
		this.startNow = (this.getCurPage()-1)*this.getPerPage();
	}

	public Long getCurPage() {
		if(curPage == null||curPage==0){
			this.curPage=1L;
		}
		return curPage;
	}

	public void setCurPage(Long curPage) {
		if(curPage == null||curPage==0){
			this.curPage=1L;
		}else {
			this.curPage=curPage;
		}
	}

	public Long getPerPage() {
		if(this.perPage==null||this.perPage==0) {
			this.perPage=10L;
		}
		return perPage;
	}

	public void setPerPage(Long perPage) {
		if(this.perPage==null||this.perPage==0) {
			this.perPage=10L;
		}else {
			this.perPage = perPage;
		}
	}

	public Long getStartNow() {
		return startNow;
	}

	public void setStartNow(Long startNow) {
		this.startNow = startNow;
	}
	
	
}
