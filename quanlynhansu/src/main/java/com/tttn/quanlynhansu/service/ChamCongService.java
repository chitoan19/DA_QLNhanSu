package com.tttn.quanlynhansu.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tttn.quanlynhansu.model.ChamCong;
import com.tttn.quanlynhansu.model.TinhLuongThang;
import com.tttn.quanlynhansu.repository.ChamCongRepository;
import com.tttn.quanlynhansu.repository.TinhLuongThangRepository;
import com.tttn.quanlynhansu.request.ChamCongRequest;
import com.tttn.quanlynhansu.request.TinhLuongThangRequest;

@Service
public class ChamCongService {
	public static Long totalItems;
	@Autowired
	private ChamCongRepository repo;

	@PersistenceContext
	private EntityManager em;

	public List<ChamCong> findAllOf(ChamCongRequest request) {
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM cham_cong WHERE 1 = 1");
		if (request.getThang() != null) {
			sql.append(" AND thang =:thang");
			params.put("thang", request.getThang());
		}
		if (request.getNam() != null) {
			sql.append(" AND nam =:nam");
			params.put("nam", request.getNam());
		}
		if (request.getNhan_vien_id() != null) {
			sql.append(" AND nhan_vien_id =:nhan_vien_id");
			params.put("nhan_vien_id", request.getNhan_vien_id());
		}
		sql.append(" ORDER BY id DESC ");
		Query query = em.createNativeQuery(sql.toString(), ChamCong.class);

		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			query.setParameter(key, params.get(key));

		}
		totalItems = (long) query.getResultList().size();
		query.setFirstResult((request.getPageNum() - 1) * request.getPageSize());
		query.setMaxResults(request.getPageSize());

		List<ChamCong> result = query.getResultList();
		return result;
	}

	public TinhLuongThang thongKeCongThang(ChamCongRequest request) {
		TinhLuongThang luongThang = new TinhLuongThang();
		int soNgayCong = 0;
		int soNgayNghiPhep = 0;
		int soGioLamThem = 0;
		int soNgayDiMuon = 0;

		Map<String, Object> params = new HashMap<String, Object>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM cham_cong WHERE 1 = 1");
		if (request.getThang() != null) {
			sql.append(" AND thang =:thang");
			params.put("thang", request.getThang());
		}
		if (request.getNam() != null) {
			sql.append(" AND nam =:nam");
			params.put("nam", request.getNam());
		}
		if (request.getNhan_vien_id() != null) {
			sql.append(" AND nhan_vien_id =:nhan_vien_id");
			params.put("nhan_vien_id", request.getNhan_vien_id());
		}

		Query query = em.createNativeQuery(sql.toString(), ChamCong.class);

		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			query.setParameter(key, params.get(key));
		}
		soNgayCong = (int) query.getResultList().size();
		soNgayNghiPhep = 24 - soNgayCong;
		List<ChamCong> result = query.getResultList();
		for (ChamCong cc : result) {
			if (cc.getTrang_thai() == 0) {
				soNgayDiMuon++;
			}
			soGioLamThem += cc.getGio_lam_them();
		}
		luongThang.setSo_ngay_cong(soNgayCong);
		luongThang.setSo_ngay_di_muon(soNgayDiMuon);
		luongThang.setSo_ngay_nghi_phep(soNgayNghiPhep);
		luongThang.setSo_gio_lam_them(soGioLamThem);
		luongThang.setNhan_vien_id(request.getNhan_vien_id());
		luongThang.setThang(request.getThang());
		luongThang.setNam(request.getNam());
		if(soNgayDiMuon == 1) {
			luongThang.setKhau_tru((long)50);
		}
		if(soNgayDiMuon == 2) {
			luongThang.setKhau_tru((long)100);
		}
		if(soNgayDiMuon == 3) {
			luongThang.setKhau_tru((long)200);
		}
		if(soNgayDiMuon > 3) {
			luongThang.setKhau_tru((long)500);
		}		
		return luongThang;
	}

	public List<TinhLuongThang> findAllTinhLuong(TinhLuongThangRequest request) {
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tinh_luong_thang WHERE 1 = 1");
		if (request.getThang() != null) {
			sql.append(" AND thang =:thang");
			params.put("thang", request.getThang());
		}
		if (request.getNam() != null) {
			sql.append(" AND nam =:nam");
			params.put("nam", request.getNam());
		}
		if (request.getNhan_vien_id() != null) {
			sql.append(" AND nhan_vien_id =:nhan_vien_id");
			params.put("nhan_vien_id", request.getNhan_vien_id());
		}
		sql.append(" ORDER BY id DESC ");
		Query query = em.createNativeQuery(sql.toString(), TinhLuongThang.class);

		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			query.setParameter(key, params.get(key));

		}
		totalItems = (long) query.getResultList().size();
		query.setFirstResult((request.getPageNum() - 1) * request.getPageSize());
		query.setMaxResults(request.getPageSize());

		List<TinhLuongThang> result = query.getResultList();
		return result;
	} 
}
