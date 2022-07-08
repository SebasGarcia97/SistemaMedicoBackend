package com.apecssi.develop.Controller;


import com.apecssi.develop.Service.DepartamentoServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/departamento")

public class DepartamentoController {

    @Autowired
    DepartamentoServiceDao departamentoServiceDao;


    @PostMapping("/post")
    ResponseEntity<?> postDepartamento(
            String depDireccion,
            String depNombre,
            Integer idHospital
    ){
        return departamentoServiceDao.postDepartamento(depDireccion,depNombre,idHospital);
    }

    @GetMapping("/list")
    ResponseEntity<?> listDepartamento(){
        return  departamentoServiceDao.listDepartamento();
    }


}
