package com.apecssi.develop.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticoPacienteServiceDao {

    ResponseEntity<?> postDiagnostico(
            Integer idMedico,
            Integer idPaciente,
            Integer idHistoriaClinica,
            String diagnostico,
            String observacion,
            String medicacion
    );

    ResponseEntity<?> findDiagnosticoByCedulaPaciente(
            String cedula,
            Integer idDepartamento
    );

    ResponseEntity<?> findByFecha(
            String fecha
    );

    ResponseEntity<?> findByHistoriaClinica(
            Integer idhistoriaClinica
    );

    ResponseEntity<?> findByMedico(
            Integer idMedico
    );
}
