package com.apecssi.develop.Models;

import javax.persistence.*;

@Entity
public class TblSignosVitales {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idSignosVitales;

    @Column(length = 50)
    private  String svNombre;

    public Integer getIdSignosVitales() {
        return idSignosVitales;
    }

    public void setIdSignosVitales(Integer idSignosVitales) {
        this.idSignosVitales = idSignosVitales;
    }

    public String getSvNombre() {
        return svNombre;
    }

    public void setSvNombre(String svNombre) {
        this.svNombre = svNombre;
    }
}
