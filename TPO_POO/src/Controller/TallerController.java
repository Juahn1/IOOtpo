package Controller;
import java.util.ArrayList;
import java.util.List;

import Model.*;
import Views.ClienteView;
import Views.ReparacionesView;
import Views.VehiculoView;

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
        cargarDatos();
    }

    public static TallerController getInstance(){
        if (instancia == null){
            instancia = new TallerController();
        }
        return instancia;
    }

    public void cargarDatos(){
        clientes.add(new Cliente("Gabriel", "DNI", 44799040));
        clientes.add(new Cliente("Omi", "DNI", 95935019));

        vehiculos.add(new Vehiculo("ARG080", "Toyota", "Etios", 2023, 44799040));
        vehiculos.add(new Vehiculo("ARG081", "Ferrari", "Spider", 2023, 95935019));
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
        if(verificarExistenciaCliente(dni)){ // si existe el cliente, podes agregar vehiculos
            vehiculos.add(new Vehiculo(patente, marca, modelo, año, dni));
        }
    }

    public void altaDeReparacion(int dni, String patente, String nombre, String tipoDocumento, String marca, String modelo, int año){
        /*  verifica que el cliente y el vehículo se encuentren registrados, de no ser así
            los registra. Cuando ambos se encuentren registrados, se confecciona una nueva
            reparación y se le coloca como estado “Pendiente”. */
        if (!verificarExistenciaCliente(dni)){
            altaDeCliente(nombre, tipoDocumento, dni);
        }
        if (!verificarExistenciaVehiculo(dni, patente)){
            altaDeVehiculo(patente, marca, modelo, año, dni);
        }
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

    public void retirarAuto(int dniCliente,String patente,int idReparacion){
        Vehiculo v = buscarVehiculo(dniCliente, patente);
        Reparacion r = buscarReparacion(idReparacion);// retiro el vehiculo
        if (v.getDueñoVehiculo() == dniCliente){
            r.finalizarReparacion(); // se finaliza la reparacion
            calcularImportesYlimites(idReparacion,dniCliente); // borro el auto si es el del cliente que lo retira
        }
         // se calcula el importe de la reparacion y luego se aagrega a la cta cte
        vehiculos.remove(v);
    }


    private void calcularImportesYlimites(int dniCliente, int idReparacion){
        Cliente c = buscarCliente(dniCliente);
        if (c == null){
            return;
        }
        int limite = 0; // sale de la interfaz
        int importe = 0;

        Reparacion r = buscarReparacion(idReparacion); // recordar que las iteraciones sobre los arrays las hace el metodo buscarTal
            if(r.getDniCliente() == dniCliente){
                importe += r.calcularImporteReparacion();
            }
        c.cargarImporteReparacionCC(importe, limite); // limite sale de la interfaz // modificar esto

    }


    public List<ClienteView> getClientes(){
        List<ClienteView> listaC = new ArrayList<ClienteView>();
        for (Cliente c: clientes){
            listaC.add(c.toView());
        }
        return listaC;
    }

    public List<VehiculoView> getVehiculos(){
        List<VehiculoView> listaV = new ArrayList<VehiculoView>();
        for (Vehiculo v: vehiculos){
            listaV.add(v.toView());
        }
        return listaV;
    }

    public List<ReparacionesView> getReparaciones(){
        List<ReparacionesView> listaR = new ArrayList<ReparacionesView>();
        for (Reparacion v: reparaciones){
            listaR.add(v.toView());
        }
        return listaR;
    }
}