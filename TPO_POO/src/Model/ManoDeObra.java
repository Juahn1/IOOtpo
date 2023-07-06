package Model;

public class ManoDeObra {
    private int codigo;
    private static int contador = 0;
    private String descripcionTrabajo;
    private int cantidadHoras;
    private float valorPorHora;
    private int dniTecnico;

    public ManoDeObra(String descripcionTrabajo, int cantidadHoras, float valorPorHora, int dniTecnico) {
        contador++;
        this.codigo = contador;
        this.descripcionTrabajo = descripcionTrabajo;
        this.cantidadHoras = cantidadHoras;
        this.valorPorHora = valorPorHora;
        this.dniTecnico = dniTecnico;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcionTrabajo() {
        return descripcionTrabajo;
    }

    public void setDescripcionTrabajo(String descripcionTrabajo) {
        this.descripcionTrabajo = descripcionTrabajo;
    }

    public int getCantidadHoras() {
        return cantidadHoras;
    }

    public void setCantidadHoras(int cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }

    public float getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(float valorPorHora) {
        this.valorPorHora = valorPorHora;
    }

    public int getDniTecnico() {
        return dniTecnico;
    }

    public void setDniTecnico(int dniTecnico) {
        this.dniTecnico = dniTecnico;
    }
}
