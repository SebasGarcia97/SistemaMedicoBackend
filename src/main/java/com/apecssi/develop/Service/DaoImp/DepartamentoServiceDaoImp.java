package com.apecssi.develop.Service.DaoImp;

import com.apecssi.develop.Models.TblDepartamento;
import com.apecssi.develop.Repository.DepartamentoRepository;
import com.apecssi.develop.Repository.HospitalRepository;
import com.apecssi.develop.Service.DepartamentoServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DepartamentoServiceDaoImp implements DepartamentoServiceDao {
    @Autowired
    DepartamentoRepository departamentoRepository;

    @Autowired
    HospitalRepository hospitalRepository;

    @Override
    public ResponseEntity<?> postDepartamento(String depDireccion, String depNombre, Integer idHospital) {
        TblDepartamento tblDepartamento = new TblDepartamento();
        tblDepartamento.setDepDireccion(depDireccion);
        tblDepartamento.setDepNombre(depNombre);
        tblDepartamento.setTblHospital(hospitalRepository.getById(idHospital));

        tblDepartamento = departamentoRepository.saveAndFlush(tblDepartamento);

        return new ResponseEntity<>(tblDepartamento,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> listDepartamento() {
        return new ResponseEntity<>(departamentoRepository.findAll(), HttpStatus.OK);
    }
}
