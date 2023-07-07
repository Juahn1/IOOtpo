package Views;


import Model.ManoDeObra;
import Model.Reparacion;
import Model.Repuesto;

import java.time.LocalDate;
import java.util.List;


public class ReparacionesView {
    private int idReparacion;
    private LocalDate fechaReparacion;
    private String patente;
    private int dniCliente;
    private List<ManoDeObra> listaManodeobra;
    private List<Repuesto> listaRepuestos;
    private EstadoReparacion estado;
    private enum EstadoReparacion {
        PENDIENTE,
        EN_PROCESO,
        FINALIZADO
    }

    public ReparacionesView(){}

    public ReparacionesView(int idReparacion, LocalDate fechaReparacion, String patente, int dniCliente, List<ManoDeObra> listaManodeobra, List<Repuesto> listaRepuestos) {
        this.idReparacion = idReparacion;
        this.fechaReparacion = fechaReparacion;
        this.patente = patente;
        this.estado = EstadoReparacion.PENDIENTE;
        this.dniCliente = dniCliente;
        this.listaManodeobra = listaManodeobra;
        this.listaRepuestos = listaRepuestos;
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

    public List<ManoDeObra> getListaManodeobra() {
        return listaManodeobra;
    }

    public void setListaManodeobra(List<ManoDeObra> listaManodeobra) {
        this.listaManodeobra = listaManodeobra;
    }

    public List<Repuesto> getListaRepuestos() {
        return listaRepuestos;
    }

    public void setListaRepuestos(List<Repuesto> listaRepuestos) {
        this.listaRepuestos = listaRepuestos;
    }

    public void agregarManoDeObra(String descripcionTrabajo, int cantidadHoras, float valorPorHora, int dniTecnico) {
        System.out.println(this.estado);
        if(this.estado == EstadoReparacion.EN_PROCESO){     //solo se puede agregar cuando la reparacion esta inicializada
            System.out.println("llegue???");
            this.listaManodeobra.add(new ManoDeObra(descripcionTrabajo, cantidadHoras, valorPorHora, dniTecnico));
        }
    }

    public void comenzarReparacion(){
        this.estado = EstadoReparacion.EN_PROCESO;
    }

    public void finalizarReparacion(){
        this.estado = EstadoReparacion.FINALIZADO;
    }

    public String toString(){
        return this.idReparacion + " : " + this.fechaReparacion + " : " + this.patente + " : " + this.dniCliente;
    }
}
