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
        for (Clientes c: clientes){
            if (c.soyElCliente(dni)){
                return c;
            }
        }
        return null;
    }

    private Vehiculos buscarVehiculo(int dni, String patente){
        Clientes c1 = buscarCliente(dni); // agarro el cliente y ahora busco un auto de el
        for (Vehiculos v: vehiculo){
            if(c1.soyElCliente(v.getDueñoVehiculo()) && v.esElAuto(patente)){
                return v;
            }
        }
        return null;
    }

    private Reparacion buscarReparacion(int idReparacion){
        for (Reparacion r: reparacion){
            if (r.soyLaReparacion(idReparacion)){
                return r;
            }
        }
        return null;
    }

    public boolean verificarExistenciaCliente(int dni){
        if (buscarCliente(dni) != null){ // si no retorna null, el cliente existe
            return true;
        }
        return false; // no existe
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
