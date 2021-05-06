package com.tttn.quanlynhansu.request;

public class LuongRequest {
	private Integer pageSize;
	private Integer pageNum;
	private Long nhan_vien_id;
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Long getNhan_vien_id() {
		return nhan_vien_id;
	}
	public void setNhan_vien_id(Long nhan_vien_id) {
		this.nhan_vien_id = nhan_vien_id;
	}
	public LuongRequest() {
		super();
	}
	
	
}
