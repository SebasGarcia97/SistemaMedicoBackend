package com.apecssi.develop.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface CitasServiceDao {
    ResponseEntity<?> postCitas(
            Integer idMedico,
            String citaHora,
            String citaFecha,
            String cedula,
            String nombre,
            String apellido,
            String telefono

    );

    ResponseEntity<?> CitasByMedico(
            Integer idMedico
    );

    ResponseEntity<?> UpdateCitas(
            Integer idCita,
            Integer idMedico,
            String citaHora,
            String citaFecha,
            String cedula,
            String nombre,
            String apellido,
            String telefono
    );

    ResponseEntity<?> CancelarCita(
            Integer idCita
    );

    ResponseEntity<?> ActualizarCita(
            Integer idCita,
            String citaHora,
            String citaFecha,
            Integer idMedico
    );

    ResponseEntity<?> EliminarCita(
            Integer idCita
    );

    ResponseEntity<?> listCitas();

    ResponseEntity<?> getCitaByID(
            Integer idCita);



}
