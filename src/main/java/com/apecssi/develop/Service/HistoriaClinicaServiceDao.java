package com.apecssi.develop.Service;

import com.apecssi.develop.Models.TblHistoriaClinica;
import org.springframework.http.ResponseEntity;

import java.sql.Date;
import java.util.List;

public interface HistoriaClinicaServiceDao {

    ResponseEntity<?> post (
            Integer idDepartamento,
            Integer idPaciente,
            Date fechaApertura
    );
    ResponseEntity<?> getHistoriaClinica (
            Integer idHistoriaClinica
    );

    List<TblHistoriaClinica> listHistoriaClinica(Integer idDepartamento);

    List<TblHistoriaClinica> listHistoriaClinicaByCedula(String cedula);

    ResponseEntity<?> getHistoriaClinicabyPacienteandByDepartamento (
            String cedula,
            Integer idDepartamento
    );

    ResponseEntity<?> listHClinica();
}
