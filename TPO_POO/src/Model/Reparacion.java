package Model;
import Views.ReparacionesView;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class Reparacion {
    //atributos

    private int idReparacion;
    private LocalDate fechaReparacion;
    private String patente;
    private List<Repuesto> listaRepuestos;
    private int dniCliente;
    private List<ManoDeObra> listaManodeobra;
    private static int contador = 1000;

    private EstadoReparacion estado;

    private enum EstadoReparacion {
        PENDIENTE,
        EN_PROCESO,
        FINALIZADO
    }

    //constructor
    public Reparacion(int dniCliente, String patente) {
        this.contador++;
        this.idReparacion = contador;
        this.fechaReparacion = LocalDate.now();
        this.estado = EstadoReparacion.PENDIENTE;
        this.listaRepuestos = new ArrayList<Repuesto>();
        this.listaManodeobra = new ArrayList<ManoDeObra>();
        this.patente = patente;
        this.dniCliente = dniCliente;
        fillObraYRepuestos();
    }

    private void fillObraYRepuestos(){
        this.listaRepuestos.add(new Repuesto("tornillos mariposa", 850, 12));
        this.listaRepuestos.add(new Repuesto("Pastilla de freno", 65000, 4));

        this.listaManodeobra.add(new ManoDeObra("Cambio de gomas", 8, 5000, 44741045));
        this.listaManodeobra.add(new ManoDeObra("Cambio de aceite", 1, 7000, 44741045));
    }

    //getter y setter
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

    public EstadoReparacion obtenerEstado() {
        return estado;
    }

    public List<Repuesto> getListaRepuestos() {
        return listaRepuestos;
    }

    public void setListaRepuestos(List<Repuesto> listaRepuestos) {
        this.listaRepuestos = listaRepuestos;
    }

    public List<ManoDeObra> getListaManodeobra() {
        return listaManodeobra;
    }

    public void setListaManodeobra(List<ManoDeObra> listaManodeobra) {
        this.listaManodeobra = listaManodeobra;
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

    //metodos

    public boolean soyLaReparacion(int id){
        return this.idReparacion == id;
    }

    public void comenzarReparacion(){
        this.estado = EstadoReparacion.EN_PROCESO;
    }

    public void finalizarReparacion(){
        this.estado = EstadoReparacion.FINALIZADO;
    }

    public void agregarManoDeObra(String descripcionTrabajo, int cantidadHoras, float valorPorHora, int dniTecnico) {
        System.out.println(this.estado);
        if(this.estado == EstadoReparacion.EN_PROCESO){     //solo se puede agregar cuando la reparacion esta inicializada
            System.out.println("llegue???");
            this.listaManodeobra.add(new ManoDeObra(descripcionTrabajo, cantidadHoras, valorPorHora, dniTecnico));
        }
    }

    public void agregarRepuesto(String descripcionRepuesto, float precioRepuesto, int cantidades){
        if(this.estado == EstadoReparacion.EN_PROCESO){     //solo se puede agregar cuando la reparacion esta inicializada
        this.listaRepuestos.add(new Repuesto(descripcionRepuesto, precioRepuesto, cantidades));
        }
    }

    public float iterarManosDeObra(int dniTecnico){
        float salario = 0;
        for (ManoDeObra m: listaManodeobra){
            if(m.getDniTecnico() == dniTecnico){ // todas las manos de obra del tecnico
                salario += m.getValorPorHora() * m.getCantidadHoras(); // salario total
            }
        }
        return salario;
    }

    public float calcularImporteReparacion(){
        int importe = 0;
        for (Repuesto rep: listaRepuestos){
            importe += rep.getPrecioRepuesto() * rep.getCantidades();
        }
        return importe;
    }

    public ReparacionesView toView(){
        return new ReparacionesView(this.idReparacion, this.fechaReparacion, this.patente, this.dniCliente, this.listaManodeobra, this.listaRepuestos);
    }
}
