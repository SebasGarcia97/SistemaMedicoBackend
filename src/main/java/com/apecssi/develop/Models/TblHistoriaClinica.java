package com.apecssi.develop.Models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Optional;

@Entity
public class TblHistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHistoriaClinica;

    @OneToOne
    @JoinColumn(referencedColumnName = "idDepartamento", name = "idDepartamento")
    private TblDepartamento tblDepartamento;

    @Column
    private Date hcFecha;

    @ManyToOne
    @JoinColumn(referencedColumnName = "idPaciente", name = "idPaciente")
    private TblPaciente tblPaciente;


    public Integer getIdHistoriaClinica() {
        return idHistoriaClinica;
    }

    public void setIdHistoriaClinica(Integer idHistoriaClinica) {
        this.idHistoriaClinica = idHistoriaClinica;
    }

    public TblDepartamento getTblDepartamento() {
        return tblDepartamento;
    }

    public void setTblDepartamento(TblDepartamento tblDepartamento) {
        this.tblDepartamento = tblDepartamento;
    }

    public Date getHcFecha() {
        return hcFecha;
    }

    public void setHcFecha(Date hcFecha) {
        this.hcFecha = hcFecha;
    }

    public TblPaciente getTblPaciente() {
        return tblPaciente;
    }

    public void setTblPaciente(TblPaciente tblPaciente) {this.tblPaciente = tblPaciente;}



}
