package com.tttn.quanlynhansu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tttn.quanlynhansu.model.BangLuong;
import com.tttn.quanlynhansu.model.NhanVien;

@Repository
public interface BangLuongRepository extends JpaRepository<BangLuong, Long>{
	
}
