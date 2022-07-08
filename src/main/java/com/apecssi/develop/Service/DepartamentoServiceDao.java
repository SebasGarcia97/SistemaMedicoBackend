package com.apecssi.develop.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoServiceDao {

    ResponseEntity<?> postDepartamento(
      String depDireccion,
      String depNombre,
      Integer idHospital
    );

    ResponseEntity<?> listDepartamento();
}
