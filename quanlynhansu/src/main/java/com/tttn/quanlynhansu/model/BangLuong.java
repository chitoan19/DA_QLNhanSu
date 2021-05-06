package com.tttn.quanlynhansu.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bang_luong")
public class BangLuong {
	@Id
	@Column(name="bang_luong_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="thuong")
	private double thuong;
	
	@Column(name="khau_tru")
	private double khau_tru;
	
	@Column(name="luong_co_ban")
	private double luong_co_ban;
	
	@Column(name="luong_lam_them_gio")
	private double luong_lam_them_gio;
	
	@Column(name="ngay_tinh_luong")
	private Date ngay_tinh_luong;
	
	@Column(name="ghi_chu")
	private String ghi_chu;
	
	@Column(name="nhan_vien_id")
	private Long nhan_vien_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getThuong() {
		return thuong;
	}

	public void setThuong(double thuong) {
		this.thuong = thuong;
	}

	public double getKhau_tru() {
		return khau_tru;
	}

	public void setKhau_tru(double khau_tru) {
		this.khau_tru = khau_tru;
	}

	public double getLuong_co_ban() {
		return luong_co_ban;
	}

	public void setLuong_co_ban(double luong_co_ban) {
		this.luong_co_ban = luong_co_ban;
	}

	public double getLuong_lam_them_gio() {
		return luong_lam_them_gio;
	}

	public void setLuong_lam_them_gio(double luong_lam_them_gio) {
		this.luong_lam_them_gio = luong_lam_them_gio;
	}

	public Date getNgay_tinh_luong() {
		return ngay_tinh_luong;
	}

	public void setNgay_tinh_luong(Date ngay_tinh_luong) {
		this.ngay_tinh_luong = ngay_tinh_luong;
	}

	public String getGhi_chu() {
		return ghi_chu;
	}

	public void setGhi_chu(String ghi_chu) {
		this.ghi_chu = ghi_chu;
	}

	public Long getNhan_vien_id() {
		return nhan_vien_id;
	}

	public void setNhan_vien_id(Long nhan_vien_id) {
		this.nhan_vien_id = nhan_vien_id;
	}

	public BangLuong(Long id, double thuong, double khau_tru, double luong_co_ban, double luong_lam_them_gio,
			Date ngay_tinh_luong, String ghi_chu, Long nhan_vien_id) {
		super();
		this.id = id;
		this.thuong = thuong;
		this.khau_tru = khau_tru;
		this.luong_co_ban = luong_co_ban;
		this.luong_lam_them_gio = luong_lam_them_gio;
		this.ngay_tinh_luong = ngay_tinh_luong;
		this.ghi_chu = ghi_chu;
		this.nhan_vien_id = nhan_vien_id;
	}

	public BangLuong() {
		super();
	}
	
	
}


