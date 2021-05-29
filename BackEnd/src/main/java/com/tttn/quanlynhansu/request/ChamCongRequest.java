package com.tttn.quanlynhansu.request;

import java.util.Date;
import java.util.List;

public class ChamCongRequest {
	private Integer pageSize;
	private Integer pageNum;
	private Date ngay_thang;
	private Integer thang;
	private Integer nam;
	private Long nhan_vien_id;
	private String nguoi_cham;
	private List<Long> listIdnv;
	
	
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
	public Date getNgay_thang() {
		return ngay_thang;
	}
	public void setNgay_thang(Date ngay_thang) {
		this.ngay_thang = ngay_thang;
	}
	public Long getNhan_vien_id() {
		return nhan_vien_id;
	}
	public void setNhan_vien_id(Long nhan_vien_id) {
		this.nhan_vien_id = nhan_vien_id;
	}
	public ChamCongRequest() {
		super();
	}
	public List<Long> getListIdnv() {
		return listIdnv;
	}
	public void setListIdnv(List<Long> listIdnv) {
		this.listIdnv = listIdnv;
	}
	public String getNguoi_cham() {
		return nguoi_cham;
	}
	public void setNguoi_cham(String nguoi_cham) {
		this.nguoi_cham = nguoi_cham;
	}
	
}
