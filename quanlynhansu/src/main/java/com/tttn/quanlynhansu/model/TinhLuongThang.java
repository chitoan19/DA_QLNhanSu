package com.tttn.quanlynhansu.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tinh_luong_thang")
public class TinhLuongThang {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "so_ngay_cong")
	private int so_ngay_cong;

	@Column(name = "so_ngay_nghi_phep")
	private int so_ngay_nghi_phep;

	@Column(name = "so_gio_lam_them")
	private int so_gio_lam_them;
	
	@Column(name = "so_ngay_di_muon")
	private int so_ngay_di_muon;

	@Column(name = "thang")
	private Integer thang;

	@Column(name = "nam")
	private Integer nam;

	@Column(name = "khau_tru")
	private long khau_tru;

	@Column(name = "thuong")
	private long thuong;

	@Column(name = "nguoi_cham_cong")
	private String nguoi_cham_cong;

	@Column(name = "ghi_chu")
	private String ghi_chu;

	@Column(name = "nhan_vien_id")
	private Long nhan_vien_id;
	public Integer getNam() {
		return nam;
	}

	public void setNam(Integer nam) {
		this.nam = nam;
	}

	public void setKhau_tru(long khau_tru) {
		this.khau_tru = khau_tru;
	}

	public void setThuong(long thuong) {
		this.thuong = thuong;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSo_ngay_cong() {
		return so_ngay_cong;
	}

	public void setSo_ngay_cong(int so_ngay_cong) {
		this.so_ngay_cong = so_ngay_cong;
	}

	public int getSo_ngay_nghi_phep() {
		return so_ngay_nghi_phep;
	}

	public void setSo_ngay_nghi_phep(int so_ngay_nghi_phep) {
		this.so_ngay_nghi_phep = so_ngay_nghi_phep;
	}

	public int getSo_gio_lam_them() {
		return so_gio_lam_them;
	}

	public void setSo_gio_lam_them(int so_gio_lam_them) {
		this.so_gio_lam_them = so_gio_lam_them;
	}

	public int getSo_ngay_di_muon() {
		return so_ngay_di_muon;
	}

	public void setSo_ngay_di_muon(int so_ngay_di_muon) {
		this.so_ngay_di_muon = so_ngay_di_muon;
	}

	public Integer getThang() {
		return thang;
	}

	public void setThang(Integer thang) {
		this.thang = thang;
	}

	public double getKhau_tru() {
		return khau_tru;
	}

	public void setKhau_tru(Long khau_tru) {
		this.khau_tru = khau_tru;
	}

	public double getThuong() {
		return thuong;
	}

	public void setThuong(Long thuong) {
		this.thuong = thuong;
	}

	public String getNguoi_cham_cong() {
		return nguoi_cham_cong;
	}

	public void setNguoi_cham_cong(String nguoi_cham_cong) {
		this.nguoi_cham_cong = nguoi_cham_cong;
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

	public TinhLuongThang(Long id, int so_ngay_cong, int so_ngay_nghi_phep, int so_gio_lam_them, int so_ngay_di_muon,
			Long khau_tru, Long thuong, String nguoi_cham_cong, String ghi_chu, Long nhan_vien_id) {
		super();
		this.id = id;
		this.so_ngay_cong = so_ngay_cong;
		this.so_ngay_nghi_phep = so_ngay_nghi_phep;
		this.so_gio_lam_them = so_gio_lam_them;
		this.so_ngay_di_muon = so_ngay_di_muon;
		this.khau_tru = khau_tru;
		this.thuong = thuong;
		this.nguoi_cham_cong = nguoi_cham_cong;
		this.ghi_chu = ghi_chu;
		this.nhan_vien_id = nhan_vien_id;
	}

	public TinhLuongThang() {
		super();
	}
}
