package com.apecssi.develop.Service.DaoImp;

import com.apecssi.develop.Models.TblMedico;
import com.apecssi.develop.Models.TblUsuario;
import com.apecssi.develop.Repository.MedicoRepository;
import com.apecssi.develop.Repository.UsuarioRepository;
import com.apecssi.develop.Service.UsuarioServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceDaoImp implements UsuarioServiceDao {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    MedicoRepository medicoRepository;

    @Override
    public ResponseEntity<?> postUsuario(Integer idMedico, String usuNombre, String usuPassword) {

        TblUsuario tblUsuario = usuarioRepository.findByTblMedico_IdMedico(idMedico);
        if(tblUsuario != null){
            return  new ResponseEntity<>( HttpStatus.CONFLICT);
        }

        tblUsuario = new TblUsuario();
        tblUsuario.setTblMedico(medicoRepository.findById(idMedico).get());
        tblUsuario.setUsuNombre(usuNombre);
        tblUsuario.setUsuPassword(usuPassword);
        tblUsuario = usuarioRepository.saveAndFlush(tblUsuario);
        return new ResponseEntity<>(tblUsuario, HttpStatus.CREATED);

    }


    @Override
    public ResponseEntity<?> getUsuario(String usuNombre, String usuPassword) {
        TblUsuario tblUsuario = usuarioRepository.findTblUsuariosByUsuNombreAndUsuPassword(usuNombre, usuPassword);
        if (tblUsuario == null ){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tblUsuario,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getUsuariobyCedula(String cedulaMedico) {
        TblUsuario tblUsuario = usuarioRepository.findByTblMedico_TblPersona_PerCedula(cedulaMedico);
        if (tblUsuario == null ){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tblUsuario,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateUsuario(String usuNombreActual, String usuPasswordActual, String usuNombreNuevo, String usuPasswordNuevo) {
        TblUsuario tblUsuario = usuarioRepository.findTblUsuariosByUsuNombreAndUsuPassword(usuNombreActual,usuPasswordActual);
        if (tblUsuario == null ){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        tblUsuario.setUsuPassword(usuPasswordNuevo);
        tblUsuario.setUsuNombre(usuNombreNuevo);
        tblUsuario = usuarioRepository.saveAndFlush(tblUsuario);
        return new ResponseEntity<>(tblUsuario,HttpStatus.OK);

    }

    @Override
    public ResponseEntity<?> findByUsuarioId(Integer idMedico) {
        return new ResponseEntity<>(usuarioRepository.findByTblMedico_IdMedico(idMedico),HttpStatus.OK);
    }


}
