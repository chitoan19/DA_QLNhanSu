package com.tttn.quanlynhansu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tttn.quanlynhansu.model.ChamCong;

@Repository
public interface ChamCongRepository extends JpaRepository<ChamCong, Long>{
	
}
