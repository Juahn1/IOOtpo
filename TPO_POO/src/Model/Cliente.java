package Model;

import Views.ClienteView;

public class Cliente {
    private String nombre;
    private String tipoDocumento;
    private int numeroDocumento;
    private CuentaCorriente ctaCorriente;

    public Cliente(String nombre, String tipoDocumento, int numeroDocumento) {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.ctaCorriente = new CuentaCorriente(); // vacio porque todavia no quiero cargarle datos (:
    }

    public boolean soyElCliente(int dni){
        return this.numeroDocumento == dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public CuentaCorriente getCtaCorriente() {
        return ctaCorriente;
    }

    public void setCtaCorriente(CuentaCorriente ctaCorriente) {
        this.ctaCorriente = ctaCorriente;
    }

    public void cargarImporteReparacionCC(int importe, int limite){
        ctaCorriente.setImporteReparacion(importe);
        ctaCorriente.setLimiteCredito(limite);
    }

    public ClienteView toView(){
        return new ClienteView(this.nombre, this.tipoDocumento, this.numeroDocumento);
    }
}
