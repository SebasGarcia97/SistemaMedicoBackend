package com.apecssi.develop.Models;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class TblCitas {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  Integer idCita;

    @OneToOne
    @JoinColumn (referencedColumnName = "idMedico", name = "idMedico")
    private TblMedico tblMedico;


    private Date fechaHoraCita;

    @Column(length = 10)
    private String citaCedulaPaciente;

    @Column(length = 50)
    private String citaNombrePaciente;

    @Column(length = 50)
    private String citaApellidoPaciente;

    @Column(length = 15)
    private String citaTelefonoPaciente;

    @Column(length = 20)
    private String citaEstado;

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public TblMedico getTblMedico() {
        return tblMedico;
    }

    public void setTblMedico(TblMedico tblMedico) {
        this.tblMedico = tblMedico;
    }

    public Date getFechaHoraCita() {
        return fechaHoraCita;
    }

    public void setFechaHoraCita(Date fechaHoraCita) {
        this.fechaHoraCita = fechaHoraCita;
    }

    public String getCitaCedulaPaciente() {
        return citaCedulaPaciente;
    }

    public void setCitaCedulaPaciente(String citaCedulaPaciente) {
        this.citaCedulaPaciente = citaCedulaPaciente;
    }

    public String getCitaNombrePaciente() {
        return citaNombrePaciente;
    }

    public void setCitaNombrePaciente(String citaNombrePaciente) {
        this.citaNombrePaciente = citaNombrePaciente;
    }

    public String getCitaApellidoPaciente() {
        return citaApellidoPaciente;
    }

    public void setCitaApellidoPaciente(String citaApellidoPaciente) {
        this.citaApellidoPaciente = citaApellidoPaciente;
    }

    public String getCitaTelefonoPaciente() {
        return citaTelefonoPaciente;
    }

    public void setCitaTelefonoPaciente(String citaTelefonoPaciente) {
        this.citaTelefonoPaciente = citaTelefonoPaciente;
    }

    public String getCitaEstado() {
        return citaEstado;
    }

    public void setCitaEstado(String citaEstado) {
        this.citaEstado = citaEstado;
    }
}
