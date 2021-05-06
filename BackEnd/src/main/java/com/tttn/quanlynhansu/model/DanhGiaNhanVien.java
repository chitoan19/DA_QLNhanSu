package com.tttn.quanlynhansu.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="danh_gia_nhan_vien")
public class DanhGiaNhanVien {
	//1
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//2
	@Column(name="khen_thuong")
	private String khen_thuong;
	
	//3
	@Column(name="ky_luat")
	private String ky_luat;
	
	//4
	@Column(name="ngay_danh_gia")
	private Date ngay_danh_gia;
	
	//5
	@Column(name="nhan_vien_id")
	private Long nhan_vien_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKhen_thuong() {
		return khen_thuong;
	}

	public void setKhen_thuong(String khen_thuong) {
		this.khen_thuong = khen_thuong;
	}

	public String getKy_luat() {
		return ky_luat;
	}

	public void setKy_luat(String ky_luat) {
		this.ky_luat = ky_luat;
	}

	public Date getNgay_danh_gia() {
		return ngay_danh_gia;
	}

	public void setNgay_danh_gia(Date ngay_danh_gia) {
		this.ngay_danh_gia = ngay_danh_gia;
	}

	public Long getNhan_vien_id() {
		return nhan_vien_id;
	}

	public void setNhan_vien_id(Long nhan_vien_id) {
		this.nhan_vien_id = nhan_vien_id;
	}

	public DanhGiaNhanVien(Long id, String khen_thuong, String ky_luat, Date ngay_danh_gia, Long nhan_vien_id) {
		super();
		this.id = id;
		this.khen_thuong = khen_thuong;
		this.ky_luat = ky_luat;
		this.ngay_danh_gia = ngay_danh_gia;
		this.nhan_vien_id = nhan_vien_id;
	}

	public DanhGiaNhanVien() {
		super();
	}
	
	
}
