package Model;

public class ManoDeObra {
    private int codigo;
    private String descripcionTrabajo;
    private int cantidadHoras;
    private float valorPorHora;

    public ManoDeObra(int codigo, String descripcionTrabajo, int cantidadHoras, float valorPorHora) {
        this.codigo = codigo;
        this.descripcionTrabajo = descripcionTrabajo;
        this.cantidadHoras = cantidadHoras;
        this.valorPorHora = valorPorHora;
    }

    public ManoDeObra(){
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
}
