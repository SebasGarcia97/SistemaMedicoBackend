package com.apecssi.develop.Service;

import com.apecssi.develop.Models.TblMedico;
import com.apecssi.develop.Models.TblUsuario;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UsuarioServiceDao {

    ResponseEntity<?> postUsuario(
            Integer idMedico,
            String usuNombre,
            String usuPassword
    );

    ResponseEntity<?> getUsuario(
            String usuNombre,
            String usuPassword
    );
    ResponseEntity<?> getUsuariobyCedula(
            String cedulaMedico
    );

    ResponseEntity<?> updateUsuario(
            String usuNombreActual,
            String usuPasswordActual,
            String usuNombreNuevo,
            String usuPasswordNuevo
    );

    ResponseEntity<?> findByUsuarioId(
            Integer idMedico
    );

}
