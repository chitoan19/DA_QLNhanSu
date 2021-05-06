package com.tttn.quanlynhansu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tttn.quanlynhansu.model.NhanVien;
import com.tttn.quanlynhansu.model.QuaTrinhHoatDong;

@Repository
public interface QuaTrinhHoatDongRepository extends JpaRepository<QuaTrinhHoatDong, Long>{
	
}
