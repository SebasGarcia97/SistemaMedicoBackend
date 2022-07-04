package com.apecssi.develop.Service.DaoImp;

import com.apecssi.develop.Models.TblDiagnosticoPaciente;
import com.apecssi.develop.Models.TblDiagnosticoSV;
import com.apecssi.develop.Models.TblSignosVitales;
import com.apecssi.develop.Repository.DiagnosticoPacienteRepository;
import com.apecssi.develop.Repository.DiagnosticoSVRepository;
import com.apecssi.develop.Repository.SignosVitalesRepository;
import com.apecssi.develop.Service.DiagnosticoSVServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DiagnosticoSVServiceDaoImp implements DiagnosticoSVServiceDao {
    @Autowired
    SignosVitalesRepository signosVitalesRepository;

    @Autowired
    DiagnosticoPacienteRepository diagnosticoPacienteRepository;

    @Autowired
    DiagnosticoSVRepository diagnosticoSVRepository;

    @Override
    public ResponseEntity<?> postDiagnostico(Integer idSignosVitales, Integer idDiagnosticoPaciente, String detalle, String estado) {
        if(idSignosVitales == 0 || idDiagnosticoPaciente == 0){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        TblSignosVitales tblSignosVitales = new TblSignosVitales();
        tblSignosVitales = signosVitalesRepository.findById(idSignosVitales).get();

        TblDiagnosticoPaciente tblDiagnosticoPaciente = new TblDiagnosticoPaciente();
        tblDiagnosticoPaciente = diagnosticoPacienteRepository.findById(idDiagnosticoPaciente).get();

        //Creamos
        TblDiagnosticoSV tblDiagnosticoSV = new TblDiagnosticoSV();
        tblDiagnosticoSV.setTblSignosVitales(tblSignosVitales);
        tblDiagnosticoSV.setDiagnosticoPaciente(tblDiagnosticoPaciente);
        tblDiagnosticoSV.setDevEstado(estado);
        tblDiagnosticoSV.setDsvDetalle(detalle);

        tblDiagnosticoSV = diagnosticoSVRepository.saveAndFlush(tblDiagnosticoSV);
        return new ResponseEntity<>(tblDiagnosticoSV, HttpStatus.CREATED);

    }
}
