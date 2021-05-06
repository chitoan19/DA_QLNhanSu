package com.tttn.quanlynhansu.request;

import java.util.Date;

public class AuthRequest {
	private Integer pageSize;
	private Integer pageNum;
	private String ten_dang_nhap;
	private String mat_khau;
	private int quyen;
	private int trang_thai;
	private Date tu_ngay;
	private Date den_ngay;
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	
	public int getQuyen() {
		return quyen;
	}
	public void setQuyen(int quyen) {
		this.quyen = quyen;
	}
	public int getTrang_thai() {
		return trang_thai;
	}
	public void setTrang_thai(int trang_thai) {
		this.trang_thai = trang_thai;
	}
	public Date getTu_ngay() {
		return tu_ngay;
	}
	public void setTu_ngay(Date tu_ngay) {
		this.tu_ngay = tu_ngay;
	}
	public Date getDen_ngay() {
		return den_ngay;
	}
	public void setDen_ngay(Date den_ngay) {
		this.den_ngay = den_ngay;
	}
	public String getTen_dang_nhap() {
		return ten_dang_nhap;
	}
	public void setTen_dang_nhap(String ten_dang_nhap) {
		this.ten_dang_nhap = ten_dang_nhap;
	}
	public String getMat_khau() {
		return mat_khau;
	}
	public void setMat_khau(String mat_khau) {
		this.mat_khau = mat_khau;
	}
	
	
}
