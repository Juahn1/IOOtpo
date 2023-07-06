package Views;
public class VehiculoView {
    private String patente;
    private String marca;
    private String modelo;
    private int añoVehiculo;
    private int dueñoVehiculo; // dni del cliente

    public VehiculoView(){}

    public VehiculoView(String patente, String marca, String modelo, int añoVehiculo, int dueñoVehiculo) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.añoVehiculo = añoVehiculo;
        this.dueñoVehiculo = dueñoVehiculo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAñoVehiculo() {
        return añoVehiculo;
    }

    public void setAñoVehiculo(int añoVehiculo) {
        this.añoVehiculo = añoVehiculo;
    }

    public int getDueñoVehiculo() {
        return dueñoVehiculo;
    }

    public void setDueñoVehiculo(int dueñoVehiculo) {
        this.dueñoVehiculo = dueñoVehiculo;
    }

    public String toString(){
        return this.marca + ", " + this.modelo + " : " + this.patente;
    }
}
