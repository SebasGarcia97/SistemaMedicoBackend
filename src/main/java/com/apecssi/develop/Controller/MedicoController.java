package com.apecssi.develop.Controller;

import com.apecssi.develop.Models.TblMedico;
import com.apecssi.develop.Service.MedicoServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    MedicoServiceDao medicoServiceDao;

    @PostMapping("/post")
    ResponseEntity<?> postMedico(
            String cedula,
            String nombre,
            String apellido,
            String telefono,
            String email,
            String direccion,
            String fechNac,
            Integer idDepartamento,
            Integer idRol,
            String horaEntrada,
            String horaSalida
    ){

        return  medicoServiceDao.postMedico(cedula,nombre,apellido,telefono,email,direccion,fechNac,idDepartamento,idRol,horaEntrada,horaSalida);
    }

    @GetMapping ("/findMedicoId")
    ResponseEntity<?> findByid (Integer idMedico){
        return medicoServiceDao.findbyId(idMedico);
    }

    @GetMapping ("/findMedicoApellidoNombre")
    List<TblMedico> findByApellidoNombre (String apellido, String nombre){
        return medicoServiceDao.findbyApellidoNombre(apellido,nombre);
    }

    @GetMapping ("/findMedicoDepartamento")
    List<TblMedico> findByMedicoDepartamento (Integer idDepartamento){
        return medicoServiceDao.findByidDepartamento(idDepartamento);
    }


}
