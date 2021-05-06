package com.tttn.quanlynhansu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="thong_tin_gia_dinh")
public class ThongTinGiaDinh {
	//1
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//2
	@Column(name="ho_ten_nguoi_than")
	private String ho_ten_nguoi_than;
	//3
	@Column(name="quan_he")
	private String quan_he;
	//4
	@Column(name="nghe_nghiep")
	private String nghe_nghiep;
	//5
	@Column(name="tuoi")
	private int tuoi;
	//6
	@Column(name="noi_lam_viec")
	private String noi_lam_viec;
	//7
	@Column(name="noi_o_hien_nay")
	private String noi_o_hien_nay;
	//8
	@Column(name="ghi_chu")
	private String ghi_chu;
	//9
	@Column(name="nhan_vien_id")
	private Long nhan_vien_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHo_ten_nguoi_than() {
		return ho_ten_nguoi_than;
	}

	public void setHo_ten_nguoi_than(String ho_ten_nguoi_than) {
		this.ho_ten_nguoi_than = ho_ten_nguoi_than;
	}

	public String getQuan_he() {
		return quan_he;
	}

	public void setQuan_he(String quan_he) {
		this.quan_he = quan_he;
	}

	public String getNghe_nghiep() {
		return nghe_nghiep;
	}

	public void setNghe_nghiep(String nghe_nghiep) {
		this.nghe_nghiep = nghe_nghiep;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public String getNoi_lam_viec() {
		return noi_lam_viec;
	}

	public void setNoi_lam_viec(String noi_lam_viec) {
		this.noi_lam_viec = noi_lam_viec;
	}

	public String getNoi_o_hien_nay() {
		return noi_o_hien_nay;
	}

	public void setNoi_o_hien_nay(String noi_o_hien_nay) {
		this.noi_o_hien_nay = noi_o_hien_nay;
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

	public ThongTinGiaDinh(Long id, String ho_ten_nguoi_than, String quan_he, String nghe_nghiep, int tuoi,
			String noi_lam_viec, String noi_o_hien_nay, String ghi_chu, Long nhan_vien_id) {
		super();
		this.id = id;
		this.ho_ten_nguoi_than = ho_ten_nguoi_than;
		this.quan_he = quan_he;
		this.nghe_nghiep = nghe_nghiep;
		this.tuoi = tuoi;
		this.noi_lam_viec = noi_lam_viec;
		this.noi_o_hien_nay = noi_o_hien_nay;
		this.ghi_chu = ghi_chu;
		this.nhan_vien_id = nhan_vien_id;
	}

	public ThongTinGiaDinh() {
		super();
	}
	
	
}
