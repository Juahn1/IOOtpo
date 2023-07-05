package Model;

public class Repuestos {
    private int codigoRepuesto;
    private String descripcionRepuesto;
    private float precioRepuesto;
    private int cantidades;

    public Repuestos(int codigoRepuesto, String descripcionRepuesto, float precioRepuesto, int cantidades) {
        this.codigoRepuesto = codigoRepuesto;
        this.descripcionRepuesto = descripcionRepuesto;
        this.precioRepuesto = precioRepuesto;
        this.cantidades = cantidades;
    }

    public Repuestos(){

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
