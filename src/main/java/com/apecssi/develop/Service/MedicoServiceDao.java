package com.apecssi.develop.Service;

import com.apecssi.develop.Models.TblMedico;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoServiceDao {

    ResponseEntity<?> postMedico(
            String cedula,
            String nombre,
            String apellido,
            String telefono,
            String email,
            String direccion,
            String fechNac,
            Integer idDepartamento,
            Integer idRol,
            String horaEntrada,
            String horaSalida

    );

    ResponseEntity<?> findbyId(Integer idMedico);
    List<TblMedico> findbyApellidoNombre(String nombre, String apellido);
    List<TblMedico> findByidDepartamento(Integer idDepartamento);


}
