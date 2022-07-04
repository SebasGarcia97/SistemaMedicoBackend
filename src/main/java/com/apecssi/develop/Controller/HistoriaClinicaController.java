package com.apecssi.develop.Controller;

import com.apecssi.develop.Models.TblHistoriaClinica;
import com.apecssi.develop.Service.HistoriaClinicaServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/historiaClinica")
public class HistoriaClinicaController  {
    @Autowired
    HistoriaClinicaServiceDao historiaClinicaServiceDao;

    @PostMapping("/post")
    ResponseEntity<?> post (
            Integer idDepartamento,
            Integer idPaciente,
            Date fechaApertura
    ){
        return  historiaClinicaServiceDao.post(idDepartamento, idPaciente, fechaApertura);

    }

    @GetMapping("/get")
    ResponseEntity<?> getHistoriaClinica (
            Integer idHistoriaClinica
    ){

        return  historiaClinicaServiceDao.getHistoriaClinica(idHistoriaClinica);
    }

    @GetMapping("/listHistoriaClinica")
    List<TblHistoriaClinica> listHistoriaClinica(Integer idDepartamento){
        return historiaClinicaServiceDao.listHistoriaClinica(idDepartamento);
    }

    @GetMapping("/listHistoriaClinicabyCedula")
    List<TblHistoriaClinica> listHistoriaClinicaByCedula(String cedula){
        return historiaClinicaServiceDao.listHistoriaClinicaByCedula(cedula);
    }

    @GetMapping("/getHistoriaClinicabyCedulaandDepartamento")
    ResponseEntity<?> getHistoriaClinicabyPacienteandByDepartamento (
            String cedula,
            Integer idDepartamento
    ){
        return historiaClinicaServiceDao.getHistoriaClinicabyPacienteandByDepartamento(cedula, idDepartamento);

    }

    @GetMapping("/list")
    ResponseEntity<?> listHistoriaClinicaFindAll(){
        return  historiaClinicaServiceDao.listHClinica();

    }

}
