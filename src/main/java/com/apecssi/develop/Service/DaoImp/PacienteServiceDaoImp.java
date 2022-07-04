package com.apecssi.develop.Service.DaoImp;

import com.apecssi.develop.Models.TblPaciente;
import com.apecssi.develop.Models.TblPersona;
import com.apecssi.develop.Repository.PacienteRepository;
import com.apecssi.develop.Repository.PersonaRepository;
import com.apecssi.develop.Service.PacienteServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceDaoImp implements PacienteServiceDao {
    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public ResponseEntity<?> postPaciente(String cedula, String nombre, String apellido, String telefono, String correo, String direccion, String fechaNacimiento, String pacDiscapacidad) {

        TblPaciente tblPaciente = pacienteRepository.findTblPacienteByTblPersona_PerCedula(cedula);
        if(tblPaciente != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        tblPaciente = new TblPaciente();
        TblPersona tblPersona = personaRepository.findTblPersonaByPerCedula(cedula);
        if(tblPersona == null){
            tblPersona = new TblPersona();
            tblPersona.setPerCedula(cedula);
            tblPersona.setPerNombre(nombre);
            tblPersona.setPerApellido(apellido);
            tblPersona.setPerDireccion(direccion);
            tblPersona.setPerEmail(correo);
            tblPersona.setPerTelefono(telefono);
            tblPersona.setPerFechaNac(java.sql.Date.valueOf(fechaNacimiento));
            tblPersona = personaRepository.saveAndFlush(tblPersona);
        }
        tblPaciente.setTblPersona(tblPersona);
        tblPaciente.setPacDiscapacidad(pacDiscapacidad);
        tblPaciente.setEstadoPaciente(Boolean.TRUE);
        tblPaciente = pacienteRepository.saveAndFlush(tblPaciente);
        return  new ResponseEntity<>(tblPaciente, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> listPaciente(Boolean estadoPaciente) {
        List<TblPaciente> tblPacienteList = pacienteRepository.findTblPacientesByEstadoPaciente(estadoPaciente);
        return new ResponseEntity<>(tblPacienteList,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updatePacienteInactivo(String cedula) {
       TblPaciente tblPaciente = pacienteRepository.findTblPacienteByTblPersona_PerCedula(cedula);
       if(tblPaciente != null){
           tblPaciente.setEstadoPaciente(Boolean.FALSE);
           tblPaciente = pacienteRepository.saveAndFlush(tblPaciente);
           return new ResponseEntity<>(tblPaciente, HttpStatus.OK);
       }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @Override
    public ResponseEntity<?> actualizarPaciente(String cedula, String nombre, String apellido, String telefono, String correo, String direccion, String fechaNacimiento, String pacDiscapacidad) {
        TblPaciente tblPaciente = pacienteRepository.findTblPacienteByTblPersona_PerCedula(cedula);
        if (tblPaciente == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        TblPersona tblPersona = personaRepository.findTblPersonaByPerCedula(cedula);
        if(tblPersona == null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        tblPersona.setPerNombre(nombre);
        tblPersona.setPerApellido(apellido);
        tblPersona.setPerFechaNac(java.sql.Date.valueOf(fechaNacimiento));
        tblPersona.setPerEmail(correo);
        tblPersona.setPerTelefono(telefono);
        tblPersona.setPerDireccion(direccion);
        tblPaciente.setTblPersona(tblPersona);
        tblPaciente.setPacDiscapacidad(pacDiscapacidad);
        tblPaciente.setEstadoPaciente(Boolean.TRUE);
        tblPaciente = pacienteRepository.saveAndFlush(tblPaciente);
        return  new ResponseEntity<>(tblPaciente, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getPacientePersona(String cedula) {

        TblPaciente tblPaciente = pacienteRepository.findTblPacienteByTblPersona_PerCedula(cedula);
        return new ResponseEntity<>(tblPaciente,HttpStatus.OK);


    }

    @Override
    public ResponseEntity<?> listPacientes() {
        return new ResponseEntity<>(pacienteRepository.findAll(),HttpStatus.OK);
    }



    @Override
    public ResponseEntity<?> getPacienteByID(Integer idPaciente) {
        return new ResponseEntity<>(pacienteRepository.findById(idPaciente),HttpStatus.OK);
    }


}
