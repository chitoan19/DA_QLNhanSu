package com.tttn.quanlynhansu.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phong_ban")
public class PhongBan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "phong_ban_id")
	private long id;
	
	@Column(name = "ten_phong_ban")
	private String ten_phong_ban;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTen_phong_ban() {
		return ten_phong_ban;
	}

	public void setTen_phong_ban(String ten_phong_ban) {
		this.ten_phong_ban = ten_phong_ban;
	}

	
	
	
}
