package com.apecssi.develop.Service.DaoImp;

import com.apecssi.develop.Models.TblSignosVitales;
import com.apecssi.develop.Repository.SignosVitalesRepository;
import com.apecssi.develop.Service.SignosVitalesServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SignosVitalesServiceDaoImp implements SignosVitalesServiceDao {

    @Autowired
    SignosVitalesRepository signosVitalesRepository;

    @Override
    public ResponseEntity<?> postSignosVitales(String svNombre) {
        TblSignosVitales tblSignosVitales = new TblSignosVitales();
        tblSignosVitales.setSvNombre(svNombre);

        tblSignosVitales = signosVitalesRepository.saveAndFlush(tblSignosVitales);
        return new ResponseEntity<>(tblSignosVitales, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> listSignosVitales() {
        return new ResponseEntity<>(signosVitalesRepository.findAll(), HttpStatus.OK);
    }
}
