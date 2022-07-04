package com.apecssi.develop.Repository;

import com.apecssi.develop.Models.TblDepartamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<TblDepartamento, Integer> {
}
