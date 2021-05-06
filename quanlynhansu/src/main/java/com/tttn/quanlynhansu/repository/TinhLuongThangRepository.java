package com.tttn.quanlynhansu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tttn.quanlynhansu.model.TinhLuongThang;


@Repository
public interface TinhLuongThangRepository extends JpaRepository<TinhLuongThang, Long>{

}
