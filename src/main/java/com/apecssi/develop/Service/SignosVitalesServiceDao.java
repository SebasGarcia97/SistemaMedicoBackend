package com.apecssi.develop.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface SignosVitalesServiceDao {

    ResponseEntity<?> postSignosVitales(
            String svNombre
    );

    ResponseEntity<?> listSignosVitales();
}
