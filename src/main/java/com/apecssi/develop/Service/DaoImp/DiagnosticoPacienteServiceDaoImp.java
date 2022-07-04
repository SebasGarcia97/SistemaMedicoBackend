package com.apecssi.develop.Service.DaoImp;

import com.apecssi.develop.Models.TblDiagnosticoPaciente;
import com.apecssi.develop.Models.TblHistoriaClinica;
import com.apecssi.develop.Models.TblMedico;
import com.apecssi.develop.Models.TblPaciente;
import com.apecssi.develop.Repository.DiagnosticoPacienteRepository;
import com.apecssi.develop.Repository.HistoriaClinicaRepository;
import com.apecssi.develop.Repository.MedicoRepository;
import com.apecssi.develop.Repository.PacienteRepository;
import com.apecssi.develop.Service.DiagnosticoPacienteServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class DiagnosticoPacienteServiceDaoImp implements DiagnosticoPacienteServiceDao {

    @Autowired
    MedicoRepository medicoRepository;
    @Autowired
    PacienteRepository pacienteRepository;
    @Autowired
    HistoriaClinicaRepository historiaClinicaRepository;
    @Autowired
    DiagnosticoPacienteRepository diagnosticoPacienteRepository;

    @Override
    public ResponseEntity<?> postDiagnostico(Integer idMedico, Integer idPaciente, Integer idHistoriaClinica, String diagnostico, String observacion, String medicacion) {

        if(idMedico == 0 || idPaciente == 0 || idHistoriaClinica == 0){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        //Buscar medico
        TblMedico tblMedico = new TblMedico();
        tblMedico = medicoRepository.findById(idMedico).get();

        //Buscar paciente
        TblPaciente tblPaciente = new TblPaciente();
        tblPaciente = pacienteRepository.findById(idPaciente).get();

        //Buscar Historial Clinico
        TblHistoriaClinica tblHistoriaClinica = new TblHistoriaClinica();
        tblHistoriaClinica = historiaClinicaRepository.findById(idHistoriaClinica).get();

       //Crear el Diagnostico
        TblDiagnosticoPaciente tblDp = new TblDiagnosticoPaciente();
        tblDp.setTblMedico(tblMedico);
        tblDp.setTblPaciente(tblPaciente);
        tblDp.setTblHistoriaClinica(tblHistoriaClinica);
        tblDp.setDpDiagnostico(diagnostico);
        tblDp.setDpMedicacion(medicacion);
        tblDp.setDpObservacion(observacion);

        tblDp = diagnosticoPacienteRepository.saveAndFlush(tblDp);
        return  new ResponseEntity<>(tblDp, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> findDiagnosticoByCedulaPaciente(String cedula, Integer idDepartamento) {
        List<TblDiagnosticoPaciente> diagnosticoPacienteList = new ArrayList<>();
        diagnosticoPacienteList = diagnosticoPacienteRepository.findByTblPaciente_TblPersona_PerCedulaAndTblHistoriaClinica_TblDepartamento_IdDepartamento(cedula,idDepartamento);
        return new ResponseEntity<>(diagnosticoPacienteList, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<?> findByFecha(String fecha) {
        List<TblDiagnosticoPaciente> tblDiagnosticoPacienteList = diagnosticoPacienteRepository.findByDpFecha(Date.valueOf(fecha));
        return new ResponseEntity<>(tblDiagnosticoPacienteList,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findByHistoriaClinica(Integer idhistoriaClinica) {
        List<TblDiagnosticoPaciente> tblDiagnosticoPacienteList = diagnosticoPacienteRepository.findByTblHistoriaClinica_IdHistoriaClinica(idhistoriaClinica);
        return new ResponseEntity<>(tblDiagnosticoPacienteList,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findByMedico(Integer idMedico) {
        List<TblDiagnosticoPaciente> tblDiagnosticoPacienteList = diagnosticoPacienteRepository.findByTblMedico_IdMedico(idMedico);
        return new ResponseEntity<>(tblDiagnosticoPacienteList,HttpStatus.OK);
    }
}
