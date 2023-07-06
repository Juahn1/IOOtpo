package Views;

import Model.CuentaCorriente;

public class ClienteView {
    private String nombre;
    private String tipoDocumento;
    private int numeroDocumento;
    private CuentaCorriente ctaCorriente;

    public ClienteView(){}

    public ClienteView(String nombre, String tipoDocumento, int numeroDocumento) {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.ctaCorriente = new CuentaCorriente(); // vacio porque todavia no quiero cargarle datos (:
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String toString(){
        return this.nombre + " : " + this.numeroDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public CuentaCorriente getCtaCorriente() {
        return ctaCorriente;
    }

    public void setCtaCorriente(CuentaCorriente ctaCorriente) {
        this.ctaCorriente = ctaCorriente;
    }
}
