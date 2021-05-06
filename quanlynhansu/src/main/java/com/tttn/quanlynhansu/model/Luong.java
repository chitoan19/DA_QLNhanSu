package com.tttn.quanlynhansu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="luong")
public class Luong {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="luong_co_ban")
	private Long luong_co_ban;
	
	@Column(name="phu_cap_thang")
	private Long phu_cap;
	
	@Column(name="muc_luong_lam_them_gio")
	private Long muc_luong_lam_them_gio;
	
	@Column(name="nhan_vien_id")
	private Long nhan_vien_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getLuong_co_ban() {
		return luong_co_ban;
	}

	public void setLuong_co_ban(Long luong_co_ban) {
		this.luong_co_ban = luong_co_ban;
	}

	public double getPhu_cap() {
		return phu_cap;
	}

	public void setPhu_cap(Long phu_cap) {
		this.phu_cap = phu_cap;
	}

	public double getMuc_luong_lam_them_gio() {
		return muc_luong_lam_them_gio;
	}

	public void setMuc_luong_lam_them_gio(Long muc_luong_lam_them_gio) {
		this.muc_luong_lam_them_gio = muc_luong_lam_them_gio;
	}

	public Long getNhan_vien_id() {
		return nhan_vien_id;
	}

	public void setNhan_vien_id(Long nhan_vien_id) {
		this.nhan_vien_id = nhan_vien_id;
	}

	public Luong(Long id, Long luong_co_ban, Long phu_cap, Long muc_luong_lam_them_gio, Long nhan_vien_id) {
		super();
		this.id = id;
		this.luong_co_ban = luong_co_ban;
		this.phu_cap = phu_cap;
		this.muc_luong_lam_them_gio = muc_luong_lam_them_gio;
		this.nhan_vien_id = nhan_vien_id;
	}

	public Luong() {
		super();
	}

	
}


