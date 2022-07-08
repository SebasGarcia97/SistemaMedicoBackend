package com.apecssi.develop.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalServiceDao {
    ResponseEntity<?> postHospital(
            String hspDireccion,
            String hspNombre
    );
    ResponseEntity<?> listHospital();

}
