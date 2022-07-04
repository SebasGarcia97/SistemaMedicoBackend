package com.apecssi.develop.Service;

import org.springframework.http.ResponseEntity;

public interface PacienteServiceDao {

    ResponseEntity<?> postPaciente(
            String cedula,
            String nombre,
            String apellido,
            String telefono,
            String correo,
            String direccion,
            String fechaNacimiento,
            String pacDiscapacidad
    );

    ResponseEntity<?> listPaciente(
            Boolean estadoPaciente
    );
    ResponseEntity<?> updatePacienteInactivo(
            String cedula
    );

    ResponseEntity<?> actualizarPaciente(
            String cedula,
            String nombre,
            String apellido,
            String telefono,
            String correo,
            String direccion,
            String fechaNacimiento,
            String pacDiscapacidad

    );

    ResponseEntity<?> getPacientePersona(
            String cedula
    );



    ResponseEntity<?> listPacientes();

    ResponseEntity<?> getPacienteByID(
            Integer idPaciente
    );
}
