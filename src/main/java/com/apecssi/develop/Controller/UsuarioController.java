package com.apecssi.develop.Controller;

import com.apecssi.develop.Service.UsuarioServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioServiceDao usuarioServiceDao;

    @PostMapping("/post")
    ResponseEntity<?> postUsuario(
            Integer idMedico,
            String usuNombre,
            String usuPassword
    ){
        return usuarioServiceDao.postUsuario(idMedico, usuNombre, usuPassword);
    }


    @GetMapping("/getUsuario")
    ResponseEntity<?> getUsuario(
            String usuNombre,
            String usuPassword
    ){
        return  usuarioServiceDao.getUsuario(usuNombre, usuPassword);
    }


    @GetMapping("/getUsuariobyCedula")
    ResponseEntity<?> getUsuariobyCedula(
            String cedulaMedico
    ){
        return  usuarioServiceDao.getUsuariobyCedula(cedulaMedico);
    }

    @PutMapping("/putUsuario")
    ResponseEntity<?> updateUsuario(
            String usuNombreActual,
            String usuPasswordActual,
            String usuNombreNuevo,
            String usuPasswordNuevo
    ){
        return  usuarioServiceDao.updateUsuario(usuNombreActual, usuPasswordActual, usuNombreNuevo, usuPasswordNuevo);
    }

    @GetMapping("/findByUsuarioId")
    ResponseEntity<?> findByUsuarioId(
            Integer idMedico
    ){
        return  usuarioServiceDao.findByUsuarioId(idMedico);
    }

}
