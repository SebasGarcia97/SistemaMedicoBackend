package com.apecssi.develop.Controller;

import com.apecssi.develop.Service.SignosVitalesServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/signosVitales")
public class SignosVitalesController {

    @Autowired
    private SignosVitalesServiceDao signosVitalesServiceDao;


    @PostMapping("/post")
    ResponseEntity<?> signosVitalesPost (@RequestParam String svNombre){

        return signosVitalesServiceDao.postSignosVitales(svNombre);
    }

    @GetMapping("/findAll")
    ResponseEntity<?> findAllRols(){
        return signosVitalesServiceDao.listSignosVitales();
    }


}
