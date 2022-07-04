package com.apecssi.develop.Repository;

import com.apecssi.develop.Models.TblDiagnosticoSV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticoSVRepository extends JpaRepository<TblDiagnosticoSV, Integer> {
}
