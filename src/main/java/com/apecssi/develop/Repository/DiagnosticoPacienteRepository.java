package com.apecssi.develop.Repository;

import com.apecssi.develop.Models.TblDiagnosticoPaciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository

public interface DiagnosticoPacienteRepository extends JpaRepository<TblDiagnosticoPaciente, Integer> {

    List<TblDiagnosticoPaciente> findByTblPaciente_TblPersona_PerCedulaAndTblHistoriaClinica_TblDepartamento_IdDepartamento(String cedula, Integer idDepartamento);
    List<TblDiagnosticoPaciente> findByDpFecha (Date fecha);
    List<TblDiagnosticoPaciente> findByTblHistoriaClinica_IdHistoriaClinica(Integer idHistoriaClinica);
    List<TblDiagnosticoPaciente> findByTblMedico_IdMedico(Integer idMedico);
 }
