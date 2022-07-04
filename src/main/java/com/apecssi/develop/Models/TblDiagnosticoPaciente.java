package com.apecssi.develop.Models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class TblDiagnosticoPaciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDiagnosticoPaciente;

    @OneToOne
    @JoinColumn(referencedColumnName = "idMedico", name = "idMedico")
    private TblMedico tblMedico;

    @OneToOne
    @JoinColumn(referencedColumnName = "idPaciente", name = "idPaciente")
    private TblPaciente tblPaciente;

    @OneToOne
    @JoinColumn(referencedColumnName = "idHistoriaClinica", name = "idHistoriaClinica")
    private TblHistoriaClinica tblHistoriaClinica;

    @Column
    private Timestamp dpFecha;

    @Column(length = 500)
    private  String dpDiagnostico;

    @Column(length = 500)
    private  String dpObservacion;

    @Column(length = 500)
    private  String dpMedicacion;


    public Integer getIdDiagnosticoPaciente() {
        return idDiagnosticoPaciente;
    }

    public void setIdDiagnosticoPaciente(Integer idDiagnosticoPaciente) {
        this.idDiagnosticoPaciente = idDiagnosticoPaciente;
    }

    public TblMedico getTblMedico() {
        return tblMedico;
    }

    public void setTblMedico(TblMedico tblMedico) {
        this.tblMedico = tblMedico;
    }

    public TblPaciente getTblPaciente() {
        return tblPaciente;
    }

    public void setTblPaciente(TblPaciente tblPaciente) {
        this.tblPaciente = tblPaciente;
    }

    public TblHistoriaClinica getTblHistoriaClinica() {
        return tblHistoriaClinica;
    }

    public void setTblHistoriaClinica(TblHistoriaClinica tblHistoriaClinica) {
        this.tblHistoriaClinica = tblHistoriaClinica;
    }

    public Timestamp getDpFecha() {
        return dpFecha;
    }

    public void setDpFecha(Timestamp dpFecha) {
        this.dpFecha = dpFecha;
    }

    public String getDpDiagnostico() {
        return dpDiagnostico;
    }

    public void setDpDiagnostico(String dpDiagnostico) {
        this.dpDiagnostico = dpDiagnostico;
    }

    public String getDpObservacion() {
        return dpObservacion;
    }

    public void setDpObservacion(String dpObservacion) {
        this.dpObservacion = dpObservacion;
    }

    public String getDpMedicacion() {
        return dpMedicacion;
    }

    public void setDpMedicacion(String dpMedicacion) {
        this.dpMedicacion = dpMedicacion;
    }
}
