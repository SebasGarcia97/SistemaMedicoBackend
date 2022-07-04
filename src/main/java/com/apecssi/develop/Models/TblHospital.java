package com.apecssi.develop.Models;

import javax.persistence.*;

@Entity
public class TblHospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHospital;

    @Column (length = 100)
    private String hspNombre;

    @Column (length = 100)
    private String hspDireccion;


    public Integer getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(Integer idHospital) {
        this.idHospital = idHospital;
    }

    public String getHspNombre() {
        return hspNombre;
    }

    public void setHspNombre(String hspNombre) {
        this.hspNombre = hspNombre;
    }

    public String getHspDireccion() {
        return hspDireccion;
    }

    public void setHspDireccion(String hspDireccion) {
        this.hspDireccion = hspDireccion;
    }
}
