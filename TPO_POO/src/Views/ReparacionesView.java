package Views;

import Model.ManoDeObra;
import Model.Reparacion;
import Model.Repuesto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReparacionesView {
    private int idReparacion;
    private LocalDate fechaReparacion;
    private String patente;
    private int dniCliente;

    public ReparacionesView(){}

    public ReparacionesView(int idReparacion, LocalDate fechaReparacion, String patente, int dniCliente) {
        this.idReparacion = idReparacion;
        this.fechaReparacion = fechaReparacion;
        this.patente = patente;
        this.dniCliente = dniCliente;
    }

    public int getIdReparacion() {
        return idReparacion;
    }

    public void setIdReparacion(int idReparacion) {
        this.idReparacion = idReparacion;
    }

    public LocalDate getFechaReparacion() {
        return fechaReparacion;
    }

    public void setFechaReparacion(LocalDate fechaReparacion) {
        this.fechaReparacion = fechaReparacion;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(int dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String toString(){
        return this.idReparacion + " : " + this.fechaReparacion + " : " + this.patente + " : " + this.dniCliente;
    }
}
