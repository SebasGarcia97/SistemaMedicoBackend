package com.apecssi.develop.Repository;

import com.apecssi.develop.Models.TblCitas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CitasRepository extends JpaRepository<TblCitas, Integer> {


    List<TblCitas> findByTblMedico_IdMedico(Integer idMedico);
    TblCitas findByIdCita(Integer idCita);

}
