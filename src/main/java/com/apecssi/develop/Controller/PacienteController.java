package com.apecssi.develop.Controller;

import com.apecssi.develop.Models.TblPaciente;
import com.apecssi.develop.Models.TblPersona;
import com.apecssi.develop.Repository.PacienteRepository;
import com.apecssi.develop.Service.PacienteServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/paciente")


public class PacienteController {
    @Autowired
     private PacienteServiceDao pacienteServiceDao;


    @PostMapping("/post")
    ResponseEntity<?> postPaciente(
            String cedula,
            String nombre,
            String apellido,
            String telefono,
            String correo,
            String direccion,
            String fechaNacimiento,
            String pacDiscapacidad
    ){
        return pacienteServiceDao.postPaciente(cedula, nombre, apellido, telefono, correo, direccion, fechaNacimiento, pacDiscapacidad);

    }

    @GetMapping("/lista")
    ResponseEntity<?> listPaciente(
            Boolean estadoPaciente
    ){
        return pacienteServiceDao.listPaciente(estadoPaciente);
    }

    @PutMapping("/updatePacienteInactivo")
    ResponseEntity<?> updatePacienteInactivo(
            String cedula
    ){
        return  pacienteServiceDao.updatePacienteInactivo(cedula);

    }


    @PutMapping("/put")
    ResponseEntity<?> actualizarPaciente(
            String cedula,
            String nombre,
            String apellido,
            String telefono,
            String correo,
            String direccion,
            String fechaNacimiento,
            String pacDiscapacidad
    ){
        return pacienteServiceDao.actualizarPaciente(cedula, nombre, apellido, telefono, correo, direccion, fechaNacimiento, pacDiscapacidad);
    }

    @GetMapping("/pacientePersona")
    ResponseEntity<?> pacientePersona(
            String cedula

    ){

        return  pacienteServiceDao.getPacientePersona(cedula);

    }
    @GetMapping("/list")
    ResponseEntity<?> listPaciente(){

        return  pacienteServiceDao.listPacientes();

    }

    @GetMapping("/pacientesByID")
    ResponseEntity<?> pacientesByID(
            Integer idPaciente
    ){
        return  pacienteServiceDao.getPacienteByID(idPaciente);
    }

}
