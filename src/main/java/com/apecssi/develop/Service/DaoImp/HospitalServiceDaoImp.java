package com.apecssi.develop.Service.DaoImp;


import com.apecssi.develop.Models.TblHospital;
import com.apecssi.develop.Repository.HospitalRepository;
import com.apecssi.develop.Repository.RolRepository;
import com.apecssi.develop.Service.HospitalServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HospitalServiceDaoImp implements HospitalServiceDao {

    @Autowired
    HospitalRepository hospitalRepository;


    @Override
    public ResponseEntity<?> postHospital(String hspDireccion, String hspNombre) {
        TblHospital tblHospital = new TblHospital();
        tblHospital.setHspDireccion(hspDireccion);
        tblHospital.setHspNombre(hspNombre);

        tblHospital = hospitalRepository.saveAndFlush(tblHospital);
        return new ResponseEntity<>(tblHospital, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> listHospital() {
        return new ResponseEntity<>(hospitalRepository.findAll(), HttpStatus.OK);
    }

}
