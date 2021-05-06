package com.tttn.quanlynhansu.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="tai_khoan")
public class TaiKhoan {
	@Column(name="id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="ten_dang_nhap")
	private String ten_dang_nhap;
	
	@Column(name="mat_khau")
	private String mat_khau;
	
	@Column(name="quyen")
	private int quyen;
	
	@Column(name="trang_thai")
	private int trang_thai;
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name="ngay_tao")
	private Date ngay_tao;
	
	@Column(name="nhan_vien_id")
	private Long nhan_vien_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getNgay_tao() {
		return ngay_tao;
	}

	public void setNgay_tao(Date ngay_tao) {
		this.ngay_tao = ngay_tao;
	}

	public Long getNhan_vien_id() {
		return nhan_vien_id;
	}

	public void setNhan_vien_id(Long nhan_vien_id) {
		this.nhan_vien_id = nhan_vien_id;
	}

	public TaiKhoan() {
	}
}
