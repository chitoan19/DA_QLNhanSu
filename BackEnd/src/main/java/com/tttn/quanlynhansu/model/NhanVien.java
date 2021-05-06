package com.tttn.quanlynhansu.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "nhan_vien")
public class NhanVien {
	// 1
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nhan_vien_id")
	private long id;
	// 2
	@Column(name = "ho_ten")
	private String ho_ten;
	// 3
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "ngay_sinh")
	private Date ngay_sinh;
	// 4
	@Column(name = "que_quan")
	private String que_quan;
	// 5
	@Column(name = "dia_chi_hien_tai")
	private String dia_chi_hien_tai;
	// 6
	@Column(name = "cmnd")
	private String cmnd;
	// 7
	@Column(name = "gioi_tinh")
	private int gioi_tinh;
	// 8
	@Column(name = "sdt")
	private String sdt;
	// 9
	@Column(name = "email")
	private String email;
	// 10
	@Lob
	@Column(name = "anh", length = 1000)
	private byte[] anh;

	// 12
	@Column(name = "trinh_do_van_hoa")
	private String trinh_do_van_hoa;
	// 13
	@Column(name = "so_nam_kinh_nghiem")
	private int so_nam_kinh_nghiem;
	// 14
	@Column(name = "chuc_vu")
	private String chuc_vu;
	// 15
	@Column(name = "ngay_ket_nap_doan")
	private Date ngay_ket_nap_doan;
	// 16
	@Column(name = "ngay_ket_nap_dang")
	private Date ngay_ket_nap_dang;
	// 17
	@Column(name = "bi_danh")
	private String bi_danh;
	// 18
	@Column(name = "dan_toc")
	private String dan_toc;
	// 19
	@Column(name = "ton_giao")
	private String ton_giao;
	// 20
	@Column(name = "thanh_phan_ban_than")
	private String thanh_phan_ban_than;
	// 21
	@Column(name = "noi_dang_ky_hktt")
	private String noi_dang_ky_hktt;
	// 22
	@Column(name = "ma_so_thue")
	private String ma_so_thue;
	// 23
	@Column(name = "phong_ban_id")
	private Long phong_ban_id;
	// 14
	@Column(name = "chuc_danh")
	private String chuc_danh;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHo_ten() {
		return ho_ten;
	}

	public void setHo_ten(String ho_ten) {
		this.ho_ten = ho_ten;
	}

	public Date getNgay_sinh() {
		return ngay_sinh;
	}

	public void setNgay_sinh(Date ngay_sinh) {
		this.ngay_sinh = ngay_sinh;
	}

	public String getQue_quan() {
		return que_quan;
	}

	public void setQue_quan(String que_quan) {
		this.que_quan = que_quan;
	}

	public String getDia_chi_hien_tai() {
		return dia_chi_hien_tai;
	}

	public void setDia_chi_hien_tai(String dia_chi_hien_tai) {
		this.dia_chi_hien_tai = dia_chi_hien_tai;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public int isGioi_tinh() {
		return gioi_tinh;
	}

	public void setGioi_tinh(int gioi_tinh) {
		this.gioi_tinh = gioi_tinh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getAnh() {
		return anh;
	}

	public void setAnh(byte[] anh) {
		this.anh = anh;
	}

	public String getTrinh_do_van_hoa() {
		return trinh_do_van_hoa;
	}

	public void setTrinh_do_van_hoa(String trinh_do_van_hoa) {
		this.trinh_do_van_hoa = trinh_do_van_hoa;
	}

	public int getSo_nam_kinh_nghiem() {
		return so_nam_kinh_nghiem;
	}

	public void setSo_nam_kinh_nghiem(int so_nam_kinh_nghiem) {
		this.so_nam_kinh_nghiem = so_nam_kinh_nghiem;
	}

	public Date getNgay_ket_nap_doan() {
		return ngay_ket_nap_doan;
	}

	public void setNgay_ket_nap_doan(Date ngay_ket_nap_doan) {
		this.ngay_ket_nap_doan = ngay_ket_nap_doan;
	}

	public Date getNgay_ket_nap_dang() {
		return ngay_ket_nap_dang;
	}

	public void setNgay_ket_nap_dang(Date ngay_ket_nap_dang) {
		this.ngay_ket_nap_dang = ngay_ket_nap_dang;
	}

	public String getBi_danh() {
		return bi_danh;
	}

	public void setBi_danh(String bi_danh) {
		this.bi_danh = bi_danh;
	}

	public String getDan_toc() {
		return dan_toc;
	}

	public void setDan_toc(String dan_toc) {
		this.dan_toc = dan_toc;
	}

	public String getTon_giao() {
		return ton_giao;
	}

	public void setTon_giao(String ton_giao) {
		this.ton_giao = ton_giao;
	}

	public String getThanh_phan_ban_than() {
		return thanh_phan_ban_than;
	}

	public void setThanh_phan_ban_than(String thanh_phan_ban_than) {
		this.thanh_phan_ban_than = thanh_phan_ban_than;
	}

	public String getNoi_dang_ky_hktt() {
		return noi_dang_ky_hktt;
	}

	public void setNoi_dang_ky_hktt(String noi_dang_ky_hktt) {
		this.noi_dang_ky_hktt = noi_dang_ky_hktt;
	}

	public Long getPhong_ban_id() {
		return phong_ban_id;
	}

	public void setPhong_ban_id(Long phong_ban_id) {
		this.phong_ban_id = phong_ban_id;
	}

	public String getChuc_vu() {
		return chuc_vu;
	}

	public void setChuc_vu(String chuc_vu) {
		this.chuc_vu = chuc_vu;
	}

	public String getChuc_danh() {
		return chuc_danh;
	}

	public void setChuc_danh(String chuc_danh) {
		this.chuc_danh = chuc_danh;
	}

	public String getMa_so_thue() {
		return ma_so_thue;
	}

	public void setMa_so_thue(String ma_so_thue) {
		this.ma_so_thue = ma_so_thue;
	}

	public NhanVien() {
		super();
	}

}
