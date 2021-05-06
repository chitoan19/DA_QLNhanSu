package com.tttn.quanlynhansu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="qua_trinh_hoat_dong")
public class QuaTrinhHoatDong {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="khoang_thoi_gian")
	private String khoang_thoi_gian;
	
	@Column(name="cong_viec")
	private String cong_viec;
	
	@Column(name="dia_diem")
	private String dia_diem;
	
	@Column(name="chuc_vu_nam_giu")
	private String chuc_vu_nam_giu;
	
	@Column(name="nhan_vien_id")
	private Long nhan_vien_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKhoang_thoi_gian() {
		return khoang_thoi_gian;
	}

	public void setKhoang_thoi_gian(String khoang_thoi_gian) {
		this.khoang_thoi_gian = khoang_thoi_gian;
	}

	public String getCong_viec() {
		return cong_viec;
	}

	public void setCong_viec(String cong_viec) {
		this.cong_viec = cong_viec;
	}

	public String getDia_diem() {
		return dia_diem;
	}

	public void setDia_diem(String dia_diem) {
		this.dia_diem = dia_diem;
	}

	public String getChuc_vu_nam_giu() {
		return chuc_vu_nam_giu;
	}

	public void setChuc_vu_nam_giu(String chuc_vu_nam_giu) {
		this.chuc_vu_nam_giu = chuc_vu_nam_giu;
	}

	public Long getNhan_vien_id() {
		return nhan_vien_id;
	}

	public void setNhan_vien_id(Long nhan_vien_id) {
		this.nhan_vien_id = nhan_vien_id;
	}

	public QuaTrinhHoatDong(Long id, String khoang_thoi_gian, String cong_viec, String dia_diem, String chuc_vu_nam_giu,
			Long nhan_vien_id) {
		super();
		this.id = id;
		this.khoang_thoi_gian = khoang_thoi_gian;
		this.cong_viec = cong_viec;
		this.dia_diem = dia_diem;
		this.chuc_vu_nam_giu = chuc_vu_nam_giu;
		this.nhan_vien_id = nhan_vien_id;
	}

	public QuaTrinhHoatDong() {
		super();
	}
	
	
}
