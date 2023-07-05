package Model;

public class Tecnicos {
    private int idTecnico;
    private String nombre;
    private String tipoDocumento;
    private int numeroDocumento;
    private float salarioBase;
    private int trabajosExitosos;

    public Tecnicos(){
    }
    public Tecnicos(int idTecnico, String nombre, String tipoDocumento, int numeroDocumento, float salarioBase, int trabajosExitosos) {
        this.idTecnico = idTecnico;
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.salarioBase = salarioBase;
        this.trabajosExitosos = trabajosExitosos;
    }

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
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
