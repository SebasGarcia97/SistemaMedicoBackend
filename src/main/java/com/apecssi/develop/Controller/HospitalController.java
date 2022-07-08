package com.apecssi.develop.Controller;
import com.apecssi.develop.Service.HospitalServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private HospitalServiceDao hospitalServiceDao;

    @PostMapping("/post")
    ResponseEntity<?> postHospital(
            @RequestParam String hspDireccion,
            @RequestParam String hspNombre ){

        return hospitalServiceDao.postHospital(hspDireccion,hspNombre);
    }

    @GetMapping("/lista")
    ResponseEntity<?> findAllHopital(){
        return hospitalServiceDao.listHospital();
    }


}
