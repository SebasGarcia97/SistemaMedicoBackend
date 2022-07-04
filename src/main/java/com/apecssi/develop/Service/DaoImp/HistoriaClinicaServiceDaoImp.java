package com.apecssi.develop.Service.DaoImp;

import com.apecssi.develop.Models.TblDepartamento;
import com.apecssi.develop.Models.TblHistoriaClinica;
import com.apecssi.develop.Models.TblPaciente;
import com.apecssi.develop.Repository.DepartamentoRepository;
import com.apecssi.develop.Repository.HistoriaClinicaRepository;
import com.apecssi.develop.Repository.PacienteRepository;
import com.apecssi.develop.Service.HistoriaClinicaServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class HistoriaClinicaServiceDaoImp implements HistoriaClinicaServiceDao {
    @Autowired
    HistoriaClinicaRepository historiaClinicaRepository;
    @Autowired
    PacienteRepository pacienteRepository;
    @Autowired
    DepartamentoRepository departamentoRepository;

    @Override
    public ResponseEntity<?> post(Integer idDepartamento, Integer idPaciente, Date fechaApertura) {
        TblPaciente paciente = pacienteRepository.findById(idPaciente).get();
        if(paciente == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        TblDepartamento tblDepartamento = departamentoRepository.findById(idDepartamento).get();
        if(tblDepartamento == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        TblHistoriaClinica tblHistoriaClinica= new TblHistoriaClinica();
        tblHistoriaClinica.setTblPaciente(paciente);
        tblHistoriaClinica.setTblDepartamento(tblDepartamento);
        tblHistoriaClinica.setHcFecha(fechaApertura);
        tblHistoriaClinica = historiaClinicaRepository.saveAndFlush(tblHistoriaClinica);
        return new ResponseEntity<>(tblHistoriaClinica, HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<?> getHistoriaClinica(Integer idHistoriaClinica) {
        TblHistoriaClinica tblHistoriaClinica = historiaClinicaRepository.findByIdHistoriaClinica(idHistoriaClinica);
        if (tblHistoriaClinica == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(tblHistoriaClinica,HttpStatus.OK);
    }

    @Override
    public List<TblHistoriaClinica> listHistoriaClinica(Integer idDepartamento) {
        List<TblHistoriaClinica> tblHistoriaClinicaList = historiaClinicaRepository.findByTblDepartamento_IdDepartamento(idDepartamento);
        return tblHistoriaClinicaList;
    }

    @Override
    public List<TblHistoriaClinica> listHistoriaClinicaByCedula(String cedula) {
        List<TblHistoriaClinica> tblHistoriaClinicaList = historiaClinicaRepository.findTblHistoriaClinicaByTblPaciente_TblPersonaPerCedula(cedula);
        return tblHistoriaClinicaList;
    }

    @Override
    public ResponseEntity<?> getHistoriaClinicabyPacienteandByDepartamento(String cedula, Integer idDepartamento) {
        TblHistoriaClinica tblHistoriaClinica = historiaClinicaRepository.findByTblPaciente_TblPersona_PerCedulaAndTblDepartamento_IdDepartamento(cedula, idDepartamento);
        return new ResponseEntity<>(tblHistoriaClinica,HttpStatus.OK );
    }


    @Override
    public ResponseEntity<?> listHClinica() {
        return new ResponseEntity<>(historiaClinicaRepository.findAll(),HttpStatus.OK);
    }
}
