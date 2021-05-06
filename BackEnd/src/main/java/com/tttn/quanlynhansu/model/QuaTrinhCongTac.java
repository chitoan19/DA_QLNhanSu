package com.tttn.quanlynhansu.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="qua_trinh_cong_tac")
public class QuaTrinhCongTac {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="ten_co_quan")
	private String ten_co_quan;
	
	@Column(name="dia_chi_noi_lam_viec")
	private String dia_chi_lam_viec;
	
	@Column(name="ngay_bat_dau")
	private Date ngay_bat_dau;

	@Column(name="ngay_ket_thuc")
	private Date ngay_ket_thuc;
	
	@Column(name="nhan_vien_id")
	private Long nhan_vien_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNhan_vien_id() {
		return nhan_vien_id;
	}

	public void setNhan_vien_id(Long nhan_vien_id) {
		this.nhan_vien_id = nhan_vien_id;
	}

	public QuaTrinhCongTac(Long id, String ten_co_quan, String dia_chi_lam_viec, Date ngay_bat_dau, Date ngay_ket_thuc,
			Long nhan_vien_id) {
		super();
		this.id = id;
		this.ten_co_quan = ten_co_quan;
		this.dia_chi_lam_viec = dia_chi_lam_viec;
		this.ngay_bat_dau = ngay_bat_dau;
		this.ngay_ket_thuc = ngay_ket_thuc;
		this.nhan_vien_id = nhan_vien_id;
	}

	public String getTen_co_quan() {
		return ten_co_quan;
	}

	public void setTen_co_quan(String ten_co_quan) {
		this.ten_co_quan = ten_co_quan;
	}

	public String getDia_chi_lam_viec() {
		return dia_chi_lam_viec;
	}

	public void setDia_chi_lam_viec(String dia_chi_lam_viec) {
		this.dia_chi_lam_viec = dia_chi_lam_viec;
	}

	public Date getNgay_bat_dau() {
		return ngay_bat_dau;
	}

	public void setNgay_bat_dau(Date ngay_bat_dau) {
		this.ngay_bat_dau = ngay_bat_dau;
	}

	public Date getNgay_ket_thuc() {
		return ngay_ket_thuc;
	}

	public void setNgay_ket_thuc(Date ngay_ket_thuc) {
		this.ngay_ket_thuc = ngay_ket_thuc;
	}

	public QuaTrinhCongTac() {
		super();
	}
	
	
}
