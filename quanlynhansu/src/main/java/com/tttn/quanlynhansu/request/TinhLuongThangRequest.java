package com.tttn.quanlynhansu.request;

public class TinhLuongThangRequest {
	private Integer pageSize;
	private Integer pageNum;
	private Integer thang;
	private Integer nam;
	private Long nhan_vien_id;
	public TinhLuongThangRequest() {
		super();
	}
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
	public Integer getThang() {
		return thang;
	}
	public void setThang(Integer thang) {
		this.thang = thang;
	}
	public Integer getNam() {
		return nam;
	}
	public void setNam(Integer nam) {
		this.nam = nam;
	}
	public Long getNhan_vien_id() {
		return nhan_vien_id;
	}
	public void setNhan_vien_id(Long nhan_vien_id) {
		this.nhan_vien_id = nhan_vien_id;
	}
	
}
