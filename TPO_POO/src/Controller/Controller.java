package Controller;
import java.util.ArrayList;
import java.util.List;

import Model.Clientes;
import Model.Reparacion;
import Model.Tecnicos;
import Model.Vehiculos;

public class Controller {
    private List<Reparacion> reparacion;
    private List<Tecnicos> tecnico;
    private List<Clientes> clientes;
    private List<Vehiculos> vehiculo;

    public Controller(){
        clientes = new ArrayList<Clientes>();
        reparacion = new ArrayList<Reparacion>();
        tecnico = new ArrayList<Tecnicos>();
        vehiculo = new ArrayList<Vehiculos>();
        //cargarDatos();
    }


    private Clientes buscarCliente(int dni){
        return null;
    }

    private Vehiculos buscarVehiculo(int dni, String patente){
        return null;
    }

    private Reparacion buscarReparacion(int idReparacion){
        return null;
    }

    public boolean verificarExistenciaCliente(int dni){
        return true;
    }

    public int altaDeCliente(String nombre, String tipoDocumento, int dni){
        return 0;
    }

    public void altaDeVehiculo(String patente, String marca, String modelo, int año, int dni){}

    public int nuevaReparacion(int dni, String patente, int idTecnico){
        return 0;
    }

    public float calcularSalarioTecnico(int idTecnico, int idReparacion){
        return 0;
    }




}
