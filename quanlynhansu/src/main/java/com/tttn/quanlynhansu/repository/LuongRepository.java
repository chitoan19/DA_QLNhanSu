package com.tttn.quanlynhansu.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tttn.quanlynhansu.model.Luong;

@Repository
public interface LuongRepository extends JpaRepository<Luong, Long>{
}
