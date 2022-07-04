package com.apecssi.develop.Repository;

import com.apecssi.develop.Models.TblDiagnosticoSV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DiagnosticoSV extends JpaRepository<TblDiagnosticoSV , Integer> {


}
