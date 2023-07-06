package Model;

public class CuentaCorriente {
    private int limiteCredito;
    private int importeReparacion;

    public CuentaCorriente(int limiteCredito, int importeReparacion) {
        this.limiteCredito = limiteCredito;
        this.importeReparacion = importeReparacion;
    }

    public int getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(int limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public int getImporteReparacion() {
        return importeReparacion;
    }

    public void setImporteReparacion(int importeReparacion) {
        this.importeReparacion = importeReparacion;
    }
}
