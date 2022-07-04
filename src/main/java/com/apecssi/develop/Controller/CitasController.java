package com.apecssi.develop.Controller;

import com.apecssi.develop.Service.CitasServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

@RestController
@CrossOrigin("*")
@RequestMapping("/citas")

public class CitasController {

    @Autowired
    CitasServiceDao citasServiceDao;

    @PostMapping("/agendar")
    ResponseEntity<?> postCitas(
            Integer idMedico,
            String citaFecha,
            String citaHora,
            String cedula,
            String nombre,
            String apellido,
            String telefono

    ){

        return citasServiceDao.postCitas(idMedico,citaFecha, citaHora,cedula,nombre,apellido,telefono);

    }
    @GetMapping("/CitasByMedico")
    ResponseEntity<?> CitasByMedico(
            Integer idMedico
    ){

        return  citasServiceDao.CitasByMedico(idMedico);
    }


    @PutMapping("/UpdateCitas")
    ResponseEntity<?> UpdateCitas(
            Integer idCita,
            Integer idMedico,
            String citaFecha,
            String citaHora,
            String cedula,
            String nombre,
            String apellido,
            String telefono
    ){
        return citasServiceDao.UpdateCitas(idCita,idMedico,citaFecha,citaHora,cedula,nombre,apellido,telefono);

    }

    @PutMapping("/CancelarCitas")
    ResponseEntity<?> CancelarCitas(
            Integer idCita

    ){
        return citasServiceDao.CancelarCita(idCita);

    }

    @PutMapping("/ActualizarCitas")
    ResponseEntity<?> ActualizarCitas(
            Integer idCita,
            String citaHora,
            String citaFecha,
            Integer idMedico

    ){
        return citasServiceDao.ActualizarCita(idCita,citaHora,citaFecha,idMedico);

    }

    @DeleteMapping("/EliminarCitas")
    ResponseEntity<?> EliminarCitas(
            Integer idCita

    ){
        return citasServiceDao.EliminarCita(idCita);

    }

    @GetMapping("/list")
    ResponseEntity<?> listCitas(){
        return  citasServiceDao.listCitas();
    }

    @GetMapping("/getCitaByID")
    ResponseEntity<?> getCitaByID(
            Integer idCita
    ){
        return  citasServiceDao.getCitaByID(idCita);
    }


}
