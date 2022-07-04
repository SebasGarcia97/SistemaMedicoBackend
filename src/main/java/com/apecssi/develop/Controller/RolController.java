package com.apecssi.develop.Controller;

import com.apecssi.develop.Service.RolServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/rol")

public class RolController {
    @Autowired
    private RolServiceDao rolServiceDao;

    @PostMapping("/rol")
    ResponseEntity<?> postRol (@RequestParam String rolNombre){
        return rolServiceDao.postRol(rolNombre);
    }

    @GetMapping("/findAll")
    ResponseEntity<?> findAllRols(){
        return rolServiceDao.listRol();
    }
}
