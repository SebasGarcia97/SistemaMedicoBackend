package com.apecssi.develop.Models;

import javax.persistence.*;
import java.sql.Time;

@Entity
public class TblMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMedico;

    @OneToOne
    @JoinColumn(referencedColumnName = "idDepartamento", name = "idDepartamento")
    private TblDepartamento tblDepartamento;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idPersona", name = "idPersona")
    private TblPersona tblPersona;

    @OneToOne
    @JoinColumn(referencedColumnName = "idRol", name = "idRol")
    private TblRol tblRol;

    @Column
    private Time medHoraEntrada;

    @Column
    private Time medHoraSalida;


    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public TblDepartamento getTblDepartamento() {
        return tblDepartamento;
    }

    public void setTblDepartamento(TblDepartamento tblDepartamento) {
        this.tblDepartamento = tblDepartamento;
    }

    public TblPersona getTblPersona() {
        return tblPersona;
    }

    public void setTblPersona(TblPersona tblPersona) {
        this.tblPersona = tblPersona;
    }

    public TblRol getTblRol() {
        return tblRol;
    }

    public void setTblRol(TblRol tblRol) {
        this.tblRol = tblRol;
    }

    public Time getMedHoraEntrada() {
        return medHoraEntrada;
    }

    public void setMedHoraEntrada(Time medHoraEntrada) {
        this.medHoraEntrada = medHoraEntrada;
    }

    public Time getMedHoraSalida() {
        return medHoraSalida;
    }

    public void setMedHoraSalida(Time medHoraSalida) {
        this.medHoraSalida = medHoraSalida;
    }
}
