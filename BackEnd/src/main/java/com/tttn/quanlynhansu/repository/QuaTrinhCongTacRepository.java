package com.tttn.quanlynhansu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tttn.quanlynhansu.model.QuaTrinhCongTac;

@Repository
public interface QuaTrinhCongTacRepository extends JpaRepository<QuaTrinhCongTac, Long>{
	
}
