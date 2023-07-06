package Model;

public class Repuesto {
    private int codigoRepuesto;
    private static int contador = 0;
    private String descripcionRepuesto;
    private float precioRepuesto;
    private int cantidades;

    public Repuesto(String descripcionRepuesto, float precioRepuesto, int cantidades) {
        contador++;
        this.codigoRepuesto = contador;
        this.descripcionRepuesto = descripcionRepuesto;
        this.precioRepuesto = precioRepuesto;
        this.cantidades = cantidades;
    }

    public int getCodigoRepuesto() {
        return codigoRepuesto;
    }

    public void setCodigoRepuesto(int codigoRepuesto) {
        this.codigoRepuesto = codigoRepuesto;
    }

    public String getDescripcionRepuesto() {
        return descripcionRepuesto;
    }

    public void setDescripcionRepuesto(String descripcionRepuesto) {
        this.descripcionRepuesto = descripcionRepuesto;
    }

    public float getPrecioRepuesto() {
        return precioRepuesto;
    }

    public void setPrecioRepuesto(float precioRepuesto) {
        this.precioRepuesto = precioRepuesto;
    }

    public int getCantidades() {
        return cantidades;
    }

    public void setCantidades(int cantidades) {
        this.cantidades = cantidades;
    }
}
