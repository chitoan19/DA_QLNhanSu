package com.tttn.quanlynhansu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tttn.quanlynhansu.model.TaiKhoan;
import com.tttn.quanlynhansu.repository.TaiKhoanRepository;
import com.tttn.quanlynhansu.request.AuthRequest;

@Service
public class TaiKhoanService {

	public static Long totalItems;

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private TaiKhoanRepository repo;

	public List<TaiKhoan> getAllTaiKhoan() {
		return repo.findAll();
	}

	public void delTaiKhoan(long id) {
		repo.deleteById(id);
	}

	public TaiKhoan saveTaiKhoan(TaiKhoan tk) {
		return repo.save(tk);
	}

	public TaiKhoan getTaiKhoan(long id) {
		return repo.findById(id).get();
	}

	public TaiKhoan getTaiKhoan(String username, String password) {
		for (TaiKhoan tk : repo.findAll()) {
			if (tk.getTen_dang_nhap().equals(username) && tk.getMat_khau().equals(password)) {
				return tk;
			}
		}
		return null;
	}

	public List<TaiKhoan> findAll(AuthRequest request) {
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tai_khoan WHERE 1 = 1");
		if (request.getId() != null) {
			sql.append(" AND id !=:id");
			params.put("id", request.getId());
		}
		if (request.getTen_dang_nhap() != null && !request.getTen_dang_nhap().equals("")) {
			sql.append(" AND ten_dang_nhap LIKE  :ten_dang_nhap");
			params.put("ten_dang_nhap", "%" + request.getTen_dang_nhap() + "%");
		}
		if (request.getQuyen() > -1) {
			sql.append(" AND quyen  =:quyen");
			params.put("quyen", request.getQuyen());
		}
		if (request.getTrang_thai() > -1) {
			sql.append(" AND trang_thai  =:trang_thai");
			params.put("trang_thai", request.getTrang_thai());
		}
		sql.append(" ORDER BY id DESC ");
		Query query = em.createNativeQuery(sql.toString(), TaiKhoan.class);
		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			query.setParameter(key, params.get(key));
		}
		totalItems = (long) query.getResultList().size();
		query.setFirstResult((request.getPageNum() - 1) * request.getPageSize());
		query.setMaxResults(request.getPageSize());

		List<TaiKhoan> result = query.getResultList();
		return result;
	}

}
