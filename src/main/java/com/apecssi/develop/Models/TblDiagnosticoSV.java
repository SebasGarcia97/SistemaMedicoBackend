package com.apecssi.develop.Models;

import javax.persistence.*;

@Entity
public class TblDiagnosticoSV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDiagnosticoSV;

    @OneToOne
    @JoinColumn(referencedColumnName = "idSignosVitales", name = "idSignosVitales")
    private TblSignosVitales tblSignosVitales;

    @OneToOne
    @JoinColumn(referencedColumnName = "idDiagnosticoPaciente", name = "idDiagnosticoPaciente")
    private TblDiagnosticoPaciente diagnosticoPaciente;

    @Column(length = 500)
    private String dsvDetalle;

    @Column(length = 50)
    private String devEstado;


    public Integer getIdDiagnosticoSV() {
        return idDiagnosticoSV;
    }

    public void setIdDiagnosticoSV(Integer idDiagnosticoSV) {
        this.idDiagnosticoSV = idDiagnosticoSV;
    }

    public TblSignosVitales getTblSignosVitales() {
        return tblSignosVitales;
    }

    public void setTblSignosVitales(TblSignosVitales tblSignosVitales) {
        this.tblSignosVitales = tblSignosVitales;
    }

    public TblDiagnosticoPaciente getDiagnosticoPaciente() {
        return diagnosticoPaciente;
    }

    public void setDiagnosticoPaciente(TblDiagnosticoPaciente diagnosticoPaciente) {
        this.diagnosticoPaciente = diagnosticoPaciente;
    }

    public String getDsvDetalle() {
        return dsvDetalle;
    }

    public void setDsvDetalle(String dsvDetalle) {
        this.dsvDetalle = dsvDetalle;
    }

    public String getDevEstado() {
        return devEstado;
    }

    public void setDevEstado(String devEstado) {
        this.devEstado = devEstado;
    }
}
