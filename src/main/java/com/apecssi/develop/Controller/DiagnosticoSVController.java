package com.apecssi.develop.Controller;

import com.apecssi.develop.Service.DiagnosticoPacienteServiceDao;
import com.apecssi.develop.Service.DiagnosticoSVServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/SignosVitales")
public class DiagnosticoSVController {

    @Autowired
    DiagnosticoSVServiceDao diagnosticoSVServiceDao;

    @PostMapping("/post")
    ResponseEntity<?> postDiagnostico(Integer idSignosVitales,
                                      Integer idDiagnosticoPaciente,
                                      String detalle,
                                      String estado){

        return diagnosticoSVServiceDao.postDiagnostico(idSignosVitales,idDiagnosticoPaciente,detalle,estado);
    }

}


