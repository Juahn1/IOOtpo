package Model;

public class Tecnico {
    private String nombre;
    private String tipoDocumento;
    private int numeroDocumento;
    private float salarioBase;
    private int trabajosExitosos;

    public Tecnico(String nombre, String tipoDocumento, int numeroDocumento, float salarioBase) {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.salarioBase = salarioBase;
    }

    public boolean soyElTecnico(int dni){
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

    public float getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getTrabajosExitosos() {
        return trabajosExitosos;
    }

    public void setTrabajosExitosos(int trabajosExitosos) {
        this.trabajosExitosos = trabajosExitosos;
    }
}
