package Model;

public class CuentaCorriente {
    private float limiteCredito;
    private float importeReparacion;

    public CuentaCorriente() {
        this.limiteCredito = 5000;
        this.importeReparacion = 0;
    }

    public float getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(int limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public float getImporteReparacion() {
        return importeReparacion;
    }

    public void setImporteReparacion(int importeReparacion) {
        this.importeReparacion = importeReparacion;
    }
}
