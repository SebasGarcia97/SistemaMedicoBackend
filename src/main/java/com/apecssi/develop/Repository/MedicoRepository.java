package com.apecssi.develop.Repository;

import com.apecssi.develop.Models.TblMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface MedicoRepository extends JpaRepository<TblMedico, Integer> {

    TblMedico findByTblRol_IdRol(Integer idRol);
    List<TblMedico> findByTblPersona_PerApellidoOrAndTblPersona_PerNombre(String apellido, String nombre);
    List<TblMedico> findByTblDepartamento_IdDepartamento(Integer idDepartamento);


}
