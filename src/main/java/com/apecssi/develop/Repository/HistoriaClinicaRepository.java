package com.apecssi.develop.Repository;

import com.apecssi.develop.Models.TblHistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface HistoriaClinicaRepository extends JpaRepository<TblHistoriaClinica, Integer> {

    List<TblHistoriaClinica> findByTblDepartamento_IdDepartamento(Integer idDepartamento);
    List<TblHistoriaClinica> findTblHistoriaClinicaByTblPaciente_TblPersonaPerCedula(String cedula);
    TblHistoriaClinica findByTblPaciente_TblPersona_PerCedulaAndTblDepartamento_IdDepartamento (String cedula, Integer idDepartamento);
    TblHistoriaClinica findByIdHistoriaClinica(Integer idHistoriaClinica);
}
