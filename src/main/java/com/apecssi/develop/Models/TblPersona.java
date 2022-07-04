package com.apecssi.develop.Models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class TblPersona {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idPersona;

    @Column(length = 10, unique = true)
    private String perCedula;

    @Column(length = 50)
    private String perNombre;

    @Column(length = 50)
    private String perApellido;

    @Column(length = 15)
    private String perTelefono;

    @Column(length = 50)
    private String perEmail;

    @Column(length = 100)
    private String perDireccion;

    @Column
    private java.sql.Date perFechaNac;


    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getPerCedula() {
        return perCedula;
    }

    public void setPerCedula(String perCedula) {
        this.perCedula = perCedula;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public String getPerApellido() {
        return perApellido;
    }

    public void setPerApellido(String perApellido) {
        this.perApellido = perApellido;
    }

    public String getPerTelefono() {
        return perTelefono;
    }

    public void setPerTelefono(String perTelefono) {
        this.perTelefono = perTelefono;
    }

    public String getPerEmail() {
        return perEmail;
    }

    public void setPerEmail(String perEmail) {
        this.perEmail = perEmail;
    }

    public String getPerDireccion() {
        return perDireccion;
    }

    public void setPerDireccion(String perDireccion) {
        this.perDireccion = perDireccion;
    }

    public Date getPerFechaNac() {
        return perFechaNac;
    }

    public void setPerFechaNac(Date perFechaNac) {
        this.perFechaNac = perFechaNac;
    }
}
