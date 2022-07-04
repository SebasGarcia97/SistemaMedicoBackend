package com.apecssi.develop.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface RolServiceDao {
    ResponseEntity<?> postRol(
      String rolNombre
    );

    ResponseEntity<?> listRol();



}
