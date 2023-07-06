package Controller;
import java.util.ArrayList;
import java.util.List;

import Model.Cliente;
import Model.Reparacion;
import Model.Tecnico;
import Model.Vehiculo;

public class TallerController {
    private List<Reparacion> reparaciones;
    private List<Tecnico> tecnicos;
    private List<Cliente> clientes;
    private List<Vehiculo> vehiculos;

    public TallerController(){
        clientes = new ArrayList<Cliente>();
        reparaciones = new ArrayList<Reparacion>();
        tecnicos = new ArrayList<Tecnico>();
        vehiculos = new ArrayList<Vehiculo>();
        //cargarDatos();
    }

    private Cliente buscarCliente(int dni){
        for (Cliente c: clientes){
            if (c.soyElCliente(dni)){
                return c;
            }
        }
        return null;
    }

    private Tecnico buscarTecnico(int dni){
        for (Tecnico t: tecnicos){
            if (t.soyElTecnico(dni)){
                return t;
            }
        }
        return null;
    }

    private Vehiculo buscarVehiculo(int dni, String patente){
        Cliente c1 = buscarCliente(dni); // agarro el cliente y ahora busco un auto de el
        for (Vehiculo v: vehiculos){
            if(c1.soyElCliente(v.getDueñoVehiculo()) && v.esElAuto(patente)){
                return v;
            }
        }
        return null;
    }

    private Reparacion buscarReparacion(int idReparacion){
        for (Reparacion r: reparaciones){
            if (r.soyLaReparacion(idReparacion)){
                return r;
            }
        }
        return null;
    }


    public void modificarReparacionManoObra(int idReparacion){ //cambiar parametros para agregar los valores  tanto a repuesto como a mano de obra, detallado en el diagrama
        Reparacion r = buscarReparacion(idReparacion);
        //r.altaManoObra(descripcionTrabajo, cantidadHoras, valorPorHora); // txt de view
    }

    public void modificarReparacionRepuesto(int idReparacion){ //cambiar parametros para agregar los valores  tanto a repuesto como a mano de obra, detallado en el diagrama
        Reparacion r = buscarReparacion(idReparacion);
        //r.altaRepuesto(descripcionTrabajo, cantidadHoras, valorPorHora); // txt de view
    }

    public boolean verificarExistenciaCliente(int dni){
        if (buscarCliente(dni) != null){ // si no retorna null, el cliente existe
            return true;
        }
        return false; // no existe
    }

    public boolean verificarExistenciaVehiculo(int dni, String patente){
        if(buscarVehiculo(dni,patente)!=null){
            return true;
        }
        return false;
    }
    public void altaDeCliente(String nombre, String tipoDocumento, int dni){
        clientes.add(new Cliente(nombre, tipoDocumento, dni));
    }

    public void altaDeVehiculo(String patente, String marca, String modelo, int año, int dni){
        vehiculos.add(new Vehiculo(patente, marca, modelo, año, dni));
    }

    public void altaDeReparacion(int dni, String patente){
        reparaciones.add(new Reparacion(dni, patente));
    }

    public void altaDeTecnico(String nombre, String tipoDocumento, int numeroDocumento, float salarioBase){
        tecnicos.add(new Tecnico(nombre, tipoDocumento, numeroDocumento, salarioBase));
    }

    public float calcularSalarioTecnico(int dniTecnico, int mes){ // --> reparaciones --> mano de obra
        Tecnico t = buscarTecnico(dniTecnico); // agarro al tecnico
        if (t == null) {
            throw new RuntimeException("No existe tal Tecnico");
        }
        float salarioTotal = t.getSalarioBase(); // el salario parte de el salario base del tecnico
        float salarioBruto = 0;

        for (Reparacion r: reparaciones){ // chequear que lo del mes funcione (:
            if (r.getFechaReparacion().getMonthValue() == mes){ // reparaciones en ese mes
                salarioBruto += r.iterarManosDeObra(dniTecnico);
            }
        }
        salarioTotal += salarioBruto / 10; // salario total = mas 10% del salario en manos de obra

        return salarioTotal;
    }
}
