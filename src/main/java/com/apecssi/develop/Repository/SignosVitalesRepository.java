package com.apecssi.develop.Repository;

import com.apecssi.develop.Models.TblSignosVitales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignosVitalesRepository extends JpaRepository<TblSignosVitales, Integer> {
}
