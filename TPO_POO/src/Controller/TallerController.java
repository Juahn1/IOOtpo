package Controller;
import java.util.ArrayList;
import java.util.List;

import Model.*;

public class TallerController {
    private static TallerController instancia;
    private List<Reparacion> reparaciones;
    private List<Tecnico> tecnicos;
    private List<Cliente> clientes;
    private List<Vehiculo> vehiculos;

    private TallerController(){
        clientes = new ArrayList<Cliente>();
        reparaciones = new ArrayList<Reparacion>();
        tecnicos = new ArrayList<Tecnico>();
        vehiculos = new ArrayList<Vehiculo>();
        //cargarDatos();
    }

    public static TallerController getInstance(){
        if (instancia == null){
            instancia = new TallerController();
        }
        return instancia;
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
        //verificar que dni este registrado: El dueño de un vehículo, siempre es un cliente registrado.
        vehiculos.add(new Vehiculo(patente, marca, modelo, año, dni));
    }

    public void altaDeReparacion(int dni, String patente){
        /*  verifica que el cliente y el vehículo se encuentren registrados, de no ser así
            los registra. Cuando ambos se encuentren registrados, se confecciona una nueva
            reparación y se le coloca como estado “Pendiente”. */
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

    public void retirarAuto(int dniCliente){
        for (Vehiculo v: vehiculos){ // retiro el vehiculo
            if (v.getDueñoVehiculo() == dniCliente){
                vehiculos.remove(v); // borro el auto si es el del cliente que lo retira
            }
        }
        calcularImportesYlimites(dniCliente);
    }

    public void calcularImportesYlimites(int dniCliente){
        Cliente c = buscarCliente(dniCliente);
        if (c == null){
            return;
        }
        int limite = 0; // sale de la interfaz
        int importe = 0;

        for (Reparacion r: reparaciones){
            if(r.getDniCliente() == dniCliente){
                importe += r.calcularImporteReparacion();
            }
        }
        c.cargarImporteReparacionCC(importe, limite); // limite sale de la interfaz
    }
}