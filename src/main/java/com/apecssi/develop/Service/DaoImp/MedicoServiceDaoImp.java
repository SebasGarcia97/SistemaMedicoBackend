package com.apecssi.develop.Service.DaoImp;

import com.apecssi.develop.Models.TblMedico;
import com.apecssi.develop.Models.TblPersona;
import com.apecssi.develop.Repository.DepartamentoRepository;
import com.apecssi.develop.Repository.MedicoRepository;
import com.apecssi.develop.Repository.PersonaRepository;
import com.apecssi.develop.Repository.RolRepository;
import com.apecssi.develop.Service.MedicoServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Service
public class MedicoServiceDaoImp implements MedicoServiceDao {

    @Autowired
    RolRepository rolRepository;

    @Autowired
    DepartamentoRepository departamentoRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    MedicoRepository medicoRepository;

    @Override
    public ResponseEntity<?> postMedico(String cedula, String nombre, String apellido, String telefono, String email, String direccion, String fechNac, Integer idDepartamento, Integer idRol, String horaEntrada, String horaSalida) {

        if(cedula.isEmpty() || idDepartamento ==0 || idRol==0){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }



        //VALIDAMOS SI LA PERSONA EXISTE
        TblPersona tblPersona = personaRepository.findByPerCedula(cedula);

        if(tblPersona == null){
            tblPersona = new TblPersona();
            tblPersona.setPerCedula(cedula);
            tblPersona.setPerApellido(apellido);
            tblPersona.setPerNombre(nombre);
            tblPersona.setPerTelefono(telefono);
            tblPersona.setPerDireccion(direccion);
            tblPersona.setPerEmail(email);
            tblPersona.setPerFechaNac(Date.valueOf(fechNac));
            tblPersona = personaRepository.saveAndFlush(tblPersona);
        }

        //CREAMOS AL MEDICO
        TblMedico tblMedico = new TblMedico();
        tblMedico.setTblPersona(tblPersona);
        tblMedico.setTblRol(rolRepository.findById(idRol).get());
        tblMedico.setTblDepartamento(departamentoRepository.findById(idDepartamento).get());
        tblMedico.setMedHoraEntrada(Time.valueOf(horaEntrada));
        tblMedico.setMedHoraSalida(Time.valueOf(horaSalida));
        tblMedico = medicoRepository.saveAndFlush(tblMedico);
        return new ResponseEntity<>(tblMedico, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> findbyId(Integer idMedico) {
        TblMedico tblMedico = medicoRepository.findById(idMedico).get();
        return new ResponseEntity<>(tblMedico, HttpStatus.OK);
    }

    @Override
    public List<TblMedico> findbyApellidoNombre(String nombre, String apellido) {
        List<TblMedico> tblMedicoList = medicoRepository.findByTblPersona_PerApellidoOrAndTblPersona_PerNombre(apellido,nombre);
        return tblMedicoList;
    }

    @Override
    public List<TblMedico> findByidDepartamento(Integer idDepartamento) {
        List<TblMedico> tblMedicoDepartamentoList = medicoRepository.findByTblDepartamento_IdDepartamento(idDepartamento);
        return tblMedicoDepartamentoList;
    }

}
