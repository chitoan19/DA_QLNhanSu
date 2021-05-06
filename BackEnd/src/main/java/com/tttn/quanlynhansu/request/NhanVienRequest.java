package com.tttn.quanlynhansu.request;


public class NhanVienRequest {
	private Integer pageSize;
	private Integer pageNum;
	private String ho_ten;
	private Integer phong_ban_id;
	private String chuc_vu;
	private String que_quan;
	private String dia_chi;
	private byte gioi_tinh;
	private String email;
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public byte getGioi_tinh() {
		return gioi_tinh;
	}
	public void setGioi_tinh(byte gioi_tinh) {
		this.gioi_tinh = gioi_tinh;
	}
	public Integer getPhong_ban_id() {
		return phong_ban_id;
	}
	public void setPhong_ban_id(Integer phong_ban_id) {
		this.phong_ban_id = phong_ban_id;
	}
	public String getQue_quan() {
		return que_quan;
	}
	public void setQue_quan(String que_quan) {
		this.que_quan = que_quan;
	}
	public String getDia_chi() {
		return dia_chi;
	}
	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}
	public String getHo_ten() {
		return ho_ten;
	}
	public void setHo_ten(String ho_ten) {
		this.ho_ten = ho_ten;
	}
	
	public String getChuc_vu() {
		return chuc_vu;
	}
	public void setChuc_vu(String chuc_vu) {
		this.chuc_vu = chuc_vu;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public NhanVienRequest() {
		
	}
	
	
}
