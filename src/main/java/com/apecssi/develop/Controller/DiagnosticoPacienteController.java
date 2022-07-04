package com.apecssi.develop.Controller;

import com.apecssi.develop.Service.DiagnosticoPacienteServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping ("/diagnosticoP")
public class DiagnosticoPacienteController {

    @Autowired
    DiagnosticoPacienteServiceDao diagnosticoPacienteServiceDao;

    @PostMapping("/post")
    ResponseEntity<?> postDiaPaciente( Integer idMedico, Integer idPaciente, Integer idHistoriaClinica, String diagnostico, String observacion, String medicacion){
        return diagnosticoPacienteServiceDao.postDiagnostico(idMedico,idPaciente,idHistoriaClinica,diagnostico,observacion,medicacion);
    }

    @GetMapping("/findFecha")
    ResponseEntity<?> findFecha(String fecha){
        return diagnosticoPacienteServiceDao.findByFecha(fecha);
    }

    @GetMapping("/findbyCedulaPaciente")
    ResponseEntity<?> findDiagnosticoByCedulaPaciente(String cedula, Integer idDepartamento){
        return diagnosticoPacienteServiceDao.findDiagnosticoByCedulaPaciente(cedula,idDepartamento);
    }

    @GetMapping("/findbyHistoriaClinica")
    ResponseEntity<?> findHistoriaClinica(Integer idHistoriaClinica){
        return diagnosticoPacienteServiceDao.findByHistoriaClinica(idHistoriaClinica);
    }

    @GetMapping("/findbyMedico")
    ResponseEntity<?> findMedico(Integer idMedico){
        return diagnosticoPacienteServiceDao.findByMedico(idMedico);
    }

}
