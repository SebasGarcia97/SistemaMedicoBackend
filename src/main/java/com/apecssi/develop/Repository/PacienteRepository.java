package com.apecssi.develop.Repository;

import com.apecssi.develop.Models.TblPaciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PacienteRepository extends JpaRepository <TblPaciente, Integer> {

    TblPaciente findTblPacienteByTblPersona_PerCedula(String cedula);
    List<TblPaciente> findTblPacientesByEstadoPaciente(Boolean estadoPaciente);

}
