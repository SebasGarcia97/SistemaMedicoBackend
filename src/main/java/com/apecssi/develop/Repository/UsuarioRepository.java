package com.apecssi.develop.Repository;

import com.apecssi.develop.Models.TblUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UsuarioRepository extends JpaRepository<TblUsuario, Integer> {

    TblUsuario findByTblMedico_TblPersona_PerCedula(String cedula);
    TblUsuario findByTblMedico_IdMedico(Integer idMedico);
    TblUsuario findTblUsuariosByUsuNombreAndUsuPassword(String usuNombre, String usuPassword);



}
