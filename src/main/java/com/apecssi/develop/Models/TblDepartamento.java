package com.apecssi.develop.Models;

import javax.persistence.*;

@Entity
public class TblDepartamento {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idDepartamento;

    @OneToOne
    @JoinColumn(referencedColumnName = "idHospital", name = "idHospital")
    private TblHospital tblHospital;

    @Column (length = 100)
    private String depNombre;

    @Column (length = 100)
    private String depDireccion;

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public TblHospital getTblHospital() {
        return tblHospital;
    }

    public void setTblHospital(TblHospital tblHospital) {
        this.tblHospital = tblHospital;
    }

    public String getDepNombre() {
        return depNombre;
    }

    public void setDepNombre(String depNombre) {
        this.depNombre = depNombre;
    }

    public String getDepDireccion() {
        return depDireccion;
    }

    public void setDepDireccion(String depDireccion) {
        this.depDireccion = depDireccion;
    }
}
