package com.apecssi.develop.Repository;

import com.apecssi.develop.Models.TblPersona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<TblPersona, Integer> {

    TblPersona findByPerCedula(String cedula);
    TblPersona findTblPersonaByPerCedula(String cedula);
}
