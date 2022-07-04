package com.apecssi.develop.Models;

import javax.persistence.*;

@Entity
public class TblPaciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPaciente;

    @OneToOne
    @JoinColumn(referencedColumnName = "idPersona", name = "idPersona")
    private TblPersona tblPersona;

    @Column (length = 100)
    private String pacDiscapacidad;

    @Column
    private Boolean estadoPaciente;


    public Boolean getEstadoPaciente() {
        return estadoPaciente;
    }

    public void setEstadoPaciente(Boolean estadoPaciente) {
        this.estadoPaciente = estadoPaciente;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public TblPersona getTblPersona() {
        return tblPersona;
    }

    public void setTblPersona(TblPersona tblPersona) {
        this.tblPersona = tblPersona;
    }

    public String getPacDiscapacidad() {
        return pacDiscapacidad;
    }

    public void setPacDiscapacidad(String pacDiscapacidad) {
        this.pacDiscapacidad = pacDiscapacidad;
    }
}
