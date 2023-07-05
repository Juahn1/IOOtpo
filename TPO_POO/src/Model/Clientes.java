package Model;

public class Clientes {
    private String nombre;
    private String tipoDocumento;
    private int numeroDocumento;
    private float numCliente;

    public Clientes(){
    }

    public Clientes(String nombre, String tipoDocumento, int numeroDocumento, float numCliente) {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.numCliente = numCliente;
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

    public float getNumCliente() {
        return numCliente;
    }

    public void setNumCliente(float numCliente) {
        this.numCliente = numCliente;
    }
}
