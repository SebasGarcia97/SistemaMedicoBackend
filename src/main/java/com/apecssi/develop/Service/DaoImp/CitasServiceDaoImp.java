package com.apecssi.develop.Service.DaoImp;

import com.apecssi.develop.Models.TblCitas;
import com.apecssi.develop.Models.TblMedico;
import com.apecssi.develop.Models.TblPaciente;
import com.apecssi.develop.Models.TblPersona;
import com.apecssi.develop.Repository.CitasRepository;
import com.apecssi.develop.Repository.MedicoRepository;
import com.apecssi.develop.Repository.PacienteRepository;
import com.apecssi.develop.Repository.PersonaRepository;
import com.apecssi.develop.Service.CitasServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;


@Service
public class CitasServiceDaoImp implements CitasServiceDao {
    @Autowired
    MedicoRepository medicoRepository;
    @Autowired
    CitasRepository citasRepository;
    @Autowired
    PacienteRepository pacienteRepository;
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public ResponseEntity<?> postCitas(Integer idMedico,String citaFecha, String citaHora, String cedula, String nombre, String apellido, String telefono) {

        String fecha_hora = citaFecha +" "+ citaHora;
        Timestamp timestamp = Timestamp.valueOf(fecha_hora);

        //Paciente
        TblPaciente tblPaciente = pacienteRepository.findTblPacienteByTblPersona_PerCedula(cedula);
        if (tblPaciente == null){
            TblPersona tblPersona = new TblPersona();
            tblPersona.setPerCedula(cedula);
            tblPersona.setPerApellido(apellido);
            tblPersona.setPerNombre(nombre);
            tblPersona.setPerTelefono(telefono);
            tblPersona = personaRepository.saveAndFlush(tblPersona);

            tblPaciente = new TblPaciente();
            tblPaciente.setTblPersona(tblPersona);
            tblPaciente = pacienteRepository.saveAndFlush(tblPaciente);
        }

        //Validamos si existe MedicO
        if (medicoRepository.findById(idMedico) == null) {
            return new ResponseEntity<>( HttpStatus.CONFLICT);
        }

        TblCitas tblCitas = new TblCitas();
        tblCitas.setTblMedico(medicoRepository.findById(idMedico).get());
        tblCitas.setCitaApellidoPaciente(apellido);
        tblCitas.setCitaApellidoPaciente(apellido);
        tblCitas.setFechaHoraCita(timestamp);
        tblCitas.setCitaNombrePaciente(nombre);
        tblCitas.setCitaCedulaPaciente(cedula);
        tblCitas.setCitaTelefonoPaciente(telefono);
        tblCitas.setCitaEstado("AGENDADO");

        tblCitas = citasRepository.saveAndFlush(tblCitas);
        return new ResponseEntity<>(tblCitas, HttpStatus.CREATED);


    }

    @Override
    public ResponseEntity<?> CitasByMedico(Integer idMedico) {

       List<TblCitas> tblCitasList = citasRepository.findByTblMedico_IdMedico(idMedico);
       return new ResponseEntity<>(tblCitasList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> UpdateCitas(Integer idCita,Integer idMedico, String citaFecha, String citaHora,  String cedula, String nombre, String apellido, String telefono) {
        String fecha_hora = citaFecha +" "+ citaHora;
        Timestamp timestamp = Timestamp.valueOf(fecha_hora);
        //VALIDAMOS SI EXISTE CITA
        TblCitas citas = citasRepository.findByIdCita(idCita);
        if (citas != null) {
            citas.setCitaApellidoPaciente(apellido);
            citas.setCitaApellidoPaciente(apellido);
            citas.setFechaHoraCita(timestamp);
            citas.setCitaNombrePaciente(nombre);
            citas.setCitaCedulaPaciente(cedula);
            citas.setCitaTelefonoPaciente(telefono);
            citas.setTblMedico(medicoRepository.findById(idMedico).get());
            citas.setCitaEstado("ACTUALIZADO");

            citas = citasRepository.saveAndFlush(citas);
            return new ResponseEntity<>(citas, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }


    @Override
    public ResponseEntity<?> CancelarCita(Integer idCita) {

        TblCitas tblCitas = citasRepository.findByIdCita(idCita);
        if (tblCitas != null) {
            tblCitas.setCitaEstado("CANCELADO");
            tblCitas = citasRepository.saveAndFlush(tblCitas);
            return new ResponseEntity<>(tblCitas, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @Override
    public ResponseEntity<?> ActualizarCita(Integer idCita, String citaHora, String citaFecha, Integer idMedico) {
        TblCitas citas = citasRepository.findByIdCita(idCita);
        if (citas != null){
            citas.setCitaEstado("POSTERGADO");
            citas.setTblMedico(medicoRepository.findById(idMedico).get());
            String fecha_hora = citaFecha +" "+ citaHora;
            Timestamp timestamp = Timestamp.valueOf(fecha_hora);
            citas.setFechaHoraCita(timestamp);
            citas = citasRepository.saveAndFlush(citas);
            return new ResponseEntity<>(citas, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }


    @Override
    public ResponseEntity<?> EliminarCita(Integer idCita) {

        TblCitas tblCitas = citasRepository.findByIdCita(idCita);
        if (tblCitas != null){
            tblCitas.setCitaEstado("CITA ELIMINADA");
            tblCitas = citasRepository.saveAndFlush(tblCitas);
            return new ResponseEntity<>(tblCitas,HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);

    }

    @Override
    public ResponseEntity<?> listCitas() {
        return new ResponseEntity<>(citasRepository.findAll(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getCitaByID(Integer idCita) {
        return new ResponseEntity<>(citasRepository.findById(idCita),HttpStatus.OK);
    }

}
