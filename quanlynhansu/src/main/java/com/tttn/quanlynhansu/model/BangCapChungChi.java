package com.tttn.quanlynhansu.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bang_cap_chung_chi")
public class BangCapChungChi {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="loai_bang_cap_chung_chi")
	private String loai_bang;
	
	@Column(name="ngay_cap")
	private Date ngay_cap;
	
	@Column(name="nhan_vien_id")
	private Long nhan_vien_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoai_bang() {
		return loai_bang;
	}

	public void setLoai_bang(String loai_bang) {
		this.loai_bang = loai_bang;
	}

	public Date getNgay_cap() {
		return ngay_cap;
	}

	public void setNgay_cap(Date ngay_cap) {
		this.ngay_cap = ngay_cap;
	}

	public Long getNhan_vien_id() {
		return nhan_vien_id;
	}

	public void setNhan_vien_id(Long nhan_vien_id) {
		this.nhan_vien_id = nhan_vien_id;
	}

	public BangCapChungChi(Long id, String loai_bang, Date ngay_cap, Long nhan_vien_id) {
		super();
		this.id = id;
		this.loai_bang = loai_bang;
		this.ngay_cap = ngay_cap;
		this.nhan_vien_id = nhan_vien_id;
	}

	public BangCapChungChi() {
		super();
	}
	
	
}
