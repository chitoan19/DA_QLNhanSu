package com.tttn.quanlynhansu.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="qua_trinh_dao_tao")
public class QuaTrinhDaoTao {
	//1
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//2
	@Column(name="ten_noi_dao_tao")
	private String ten_noi_dao_tao;
	//3
	@Column(name="dia_chi_noi_dao_tao")
	private String dia_chi;
	//4
	@Column(name="trinh_do_dao_tao")
	private String trinh_do_dao_tao;
	//5
	@Column(name="ngay_bat_dau")
	private Date ngay_bat_dau;
	//6
	@Column(name="ngay_ket_thuc")
	private Date ngay_ket_thuc;
	//7
	@Column(name="ghi_chu")
	private String ghi_chu;
	//8
	@Column(name="nhan_vien_id")
	private Long nhan_vien_id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTen_noi_dao_tao() {
		return ten_noi_dao_tao;
	}
	public void setTen_noi_dao_tao(String ten_noi_dao_tao) {
		this.ten_noi_dao_tao = ten_noi_dao_tao;
	}
	public String getDia_chi() {
		return dia_chi;
	}
	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}
	public String getTrinh_do_dao_tao() {
		return trinh_do_dao_tao;
	}
	public void setTrinh_do_dao_tao(String trinh_do_dao_tao) {
		this.trinh_do_dao_tao = trinh_do_dao_tao;
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
	public QuaTrinhDaoTao(Long id, String ten_noi_dao_tao, String dia_chi, String trinh_do_dao_tao, Date ngay_bat_dau,
			Date ngay_ket_thuc, String ghi_chu, Long nhan_vien_id) {
		super();
		this.id = id;
		this.ten_noi_dao_tao = ten_noi_dao_tao;
		this.dia_chi = dia_chi;
		this.trinh_do_dao_tao = trinh_do_dao_tao;
		this.ngay_bat_dau = ngay_bat_dau;
		this.ngay_ket_thuc = ngay_ket_thuc;
		this.ghi_chu = ghi_chu;
		this.nhan_vien_id = nhan_vien_id;
	}
	public QuaTrinhDaoTao() {
		super();
	}
	
}
