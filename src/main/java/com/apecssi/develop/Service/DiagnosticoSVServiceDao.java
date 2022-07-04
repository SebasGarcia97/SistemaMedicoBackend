package com.apecssi.develop.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticoSVServiceDao {

    ResponseEntity<?> postDiagnostico(
            Integer idSignosVitales,
            Integer idDiagnosticoPaciente,
            String detalle,
            String estado
    );


}
