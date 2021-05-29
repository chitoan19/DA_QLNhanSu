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
import com.tttn.quanlynhansu.model.Luong;
import com.tttn.quanlynhansu.model.TinhLuongThang;
import com.tttn.quanlynhansu.repository.ChamCongRepository;
import com.tttn.quanlynhansu.repository.LuongRepository;
import com.tttn.quanlynhansu.repository.TinhLuongThangRepository;
import com.tttn.quanlynhansu.request.ChamCongRequest;
import com.tttn.quanlynhansu.request.TinhLuongThangRequest;

@Service
public class ChamCongService {
	public static Long totalItems;
	@Autowired
	private ChamCongRepository repo;

	@Autowired
	private LuongRepository luongRepo;
	
	@Autowired
	private TinhLuongThangRepository luongThangRepo;

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

	public List<TinhLuongThang> thongKeCongThang(ChamCongRequest request) {
		List<TinhLuongThang> listResult = new ArrayList<>();
		if (request.getListIdnv().size() <= 0) {
			return null;
		}
		for (Long nhan_vien_id : request.getListIdnv()) {
			TinhLuongThang luongThang = new TinhLuongThang();
			int soNgayCong = 0;
			int soNgayNghiPhep = 0;
			int soGioLamThem = 0;
			int soNgayDiMuon = 0;
			long tongLuong = 0;
			Luong luong = getLuongByNhanVienId(nhan_vien_id);
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
			sql.append(" AND nhan_vien_id =:nhan_vien_id");
			params.put("nhan_vien_id", nhan_vien_id);

			Query query = em.createNativeQuery(sql.toString(), ChamCong.class);

			Set<String> keySet = params.keySet();
			for (String key : keySet) {
				query.setParameter(key, params.get(key));
			}
			
			List<ChamCong> result = query.getResultList();
			if (result.size() <= 0) {
				continue;
			}
			soNgayCong = (int) query.getResultList().size();
			soNgayNghiPhep = 24 - soNgayCong;
			
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
			luongThang.setNhan_vien_id(nhan_vien_id);
			luongThang.setKhau_tru((long) 0);
			luongThang.setThuong((long) 0);
			if (soNgayDiMuon == 1) {
				luongThang.setKhau_tru((long) 50000);
			}
			if (soNgayDiMuon == 2) {
				luongThang.setKhau_tru((long) 100000);
			}
			if (soNgayDiMuon == 3) {
				luongThang.setKhau_tru((long) 200000);
			}
			if (soNgayDiMuon > 3) {
				luongThang.setKhau_tru((long) 500000);
			}
			long tongLuongCoBan = (long) ((luong.getLuong_co_ban() / 24) * luongThang.getSo_ngay_cong());
			long tongLuongLamThemGio = (long) (luong.getMuc_luong_lam_them_gio() * luongThang.getSo_gio_lam_them());
			long khauTru = luongThang.getKhau_tru();
			long thuong = luongThang.getThuong();
			long phuCap = (long) luong.getPhu_cap();
			tongLuong = tongLuongCoBan + tongLuongLamThemGio + khauTru + thuong + phuCap;
			luongThang.setTong_luong((long) Math.round(tongLuong));
			if (luongThang.getNhan_vien_id() != null && !checkValid(request, nhan_vien_id)) {
				listResult.add(luongThang);
			}
		}
		luongThangRepo.saveAll(listResult);
		return listResult;
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
		if(request.getPageSize() != null) {
			query.setFirstResult((request.getPageNum() - 1) * request.getPageSize());
			query.setMaxResults(request.getPageSize());
		}
		
		List<TinhLuongThang> result = query.getResultList();
		return result;
	}

	public Luong getLuongByNhanVienId(Long nvid) {
		for (Luong l : luongRepo.findAll()) {
			if (l.getNhan_vien_id() == nvid) {
				return l;
			}
		}
		return null;
	}

	public boolean checkValid(ChamCongRequest request, Long nvId) {
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
		if (nvId != null) {
			sql.append(" AND nhan_vien_id =:nhan_vien_id");
			params.put("nhan_vien_id", nvId);
		}
		Query query = em.createNativeQuery(sql.toString(), TinhLuongThang.class);

		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			query.setParameter(key, params.get(key));

		}
		totalItems = (long) query.getResultList().size();
		if (totalItems > 0) {
			return true;
		}
		return false;
	}
}
