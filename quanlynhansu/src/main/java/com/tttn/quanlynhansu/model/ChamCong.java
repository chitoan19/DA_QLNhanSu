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
@Table(name = "cham_cong")
public class ChamCong {
	// 1
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// 2
	@DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
	@Column(name = "gio_vao")
	private Date gio_vao;
	// 3
	@DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
	@Column(name = "gio_ra")
	private Date gio_ra;
	// 4
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Column(name = "ngay")
	private Date ngay_thang;
	// 7
	@Column(name = "gio_lam_them")
	private int gio_lam_them;
	// 7
	@Column(name = "trang_thai")
	private int trang_thai;
	
	@Column(name = "thang")
	private Integer thang;
	
	@Column(name = "nam")
	private Integer nam;
	
	// 9
	@Column(name = "nhan_vien_id")
	private Long nhan_vien_id;

	public Integer getThang() {
		return thang;
	}

	public void setThang(Integer thang) {
		this.thang = thang;
	}

	public Integer getNam() {
		return nam;
	}

	public void setNam(Integer nam) {
		this.nam = nam;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getGio_vao() {
		return gio_vao;
	}

	public void setGio_vao(Date gio_vao) {
		this.gio_vao = gio_vao;
	}

	public Date getGio_ra() {
		return gio_ra;
	}

	public void setGio_ra(Date gio_ra) {
		this.gio_ra = gio_ra;
	}

	public int getGio_lam_them() {
		return gio_lam_them;
	}

	public void setGio_lam_them(int gio_lam_them) {
		this.gio_lam_them = gio_lam_them;
	}

	public int getTrang_thai() {
		return trang_thai;
	}

	public void setTrang_thai(int trang_thai) {
		this.trang_thai = trang_thai;
	}

	public Long getNhan_vien_id() {
		return nhan_vien_id;
	}

	public void setNhan_vien_id(Long nhan_vien_id) {
		this.nhan_vien_id = nhan_vien_id;
	}

	public ChamCong(Long id, Date gio_vao, Date gio_ra, Date ngay, int gio_lam_them, int trang_thai,
			Long nhan_vien_id) {
		super();
		this.id = id;
		this.gio_vao = gio_vao;
		this.gio_ra = gio_ra;
		this.gio_lam_them = gio_lam_them;
		this.trang_thai = trang_thai;
		this.nhan_vien_id = nhan_vien_id;
	}

	public Date getNgay_thang() {
		return ngay_thang;
	}

	public void setNgay_thang(Date ngay_thang) {
		this.ngay_thang = ngay_thang;
	}

	public ChamCong() {
		super();
	}

}
