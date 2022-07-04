package com.apecssi.develop.Service.DaoImp;

import com.apecssi.develop.Models.TblRol;

import com.apecssi.develop.Repository.RolRepository;
import com.apecssi.develop.Service.RolServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class RolServiceDaoImp implements RolServiceDao {

    @Autowired
    RolRepository rolRepository;

    @Override
    public ResponseEntity<?> postRol(String rolNombre) {
        TblRol tblRol = new TblRol();
        tblRol.setRolNombre(rolNombre);

        tblRol = rolRepository.saveAndFlush(tblRol);
        return new ResponseEntity<>(tblRol, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> listRol() {
        return new ResponseEntity<>(rolRepository.findAll(), HttpStatus.OK);
    }


}
