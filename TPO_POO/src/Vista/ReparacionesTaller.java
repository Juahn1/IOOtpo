package Vista;
import Controller.TallerController;
import Views.ClienteView;
import Views.ReparacionesView;
import Views.TecnicoView;
import Views.VehiculoView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ReparacionesTaller extends JFrame{
    private JLabel lblCliente, lblVehiculo, lblMes, lblTecnico, lblManoDeObra, lblDescripcion,
            lblCantHoras, lblValorHora, lblReparaciones, lbldescripcionRepuesto, lblPrecioRepuesto, lblCantidadRepuesto, lblRepuesto;
    private JComboBox<ClienteView> clientesCombo;
    private JComboBox<VehiculoView> vehiculosCombo;
    private JComboBox<TecnicoView> tecnicosCombo;
    private JComboBox<Integer> mesCombo;
    private JComboBox<ReparacionesView> reparacionesCombo;

    private JButton btnIniciarReparacion, btnCalcularSalario, btnSalir, btnAgregarManoDeObra,
            btnComenzarReparacion, btnFinalizarReparacion,btnRetirarVehiculo, btnAgregarRepuesto;
    private JTextField txtDescripcion, txtCantHoras, txtValorHora, txtdescripcionRepuesto, txtPrecioRepuesto, txtCantidadRepuesto;


    public ReparacionesTaller(){
        construirInterfaz();
        manejoEventos();
        this.setVisible(true);
        this.setSize(600, 700);
    }

    private void construirInterfaz(){
        Container c = this.getContentPane();
        c.setLayout(null);

        //instancio todos los J_items del container
        declararItems();

        //lleno los comboboxes
        fillComboBoxes();

        //agrego los items al layout
        addItemsToLayout(c);
    }

    private void setDefaultNull(){
        //default = empty
        clientesCombo.setSelectedItem(null);
        vehiculosCombo.setSelectedItem(null);
        tecnicosCombo.setSelectedItem(null);
        mesCombo.setSelectedItem(null);
        reparacionesCombo.setSelectedItem(null);
    }

    private void declararItems(){
        //labels
        lblCliente = new JLabel("Cientes");
        lblCliente.setBounds(20, 10, 130, 30);

        lblVehiculo = new JLabel("Vehiculos");
        lblVehiculo.setBounds(170, 10, 150, 30);

        lblTecnico = new JLabel("Tecnicos");
        lblTecnico.setBounds(20, 150, 130, 30);

        lblMes = new JLabel("Ingrese el mes");
        lblMes.setBounds(170, 150, 150, 30);

        lblManoDeObra = new JLabel("AGREGAR MANO DE OBRA:");
        lblManoDeObra.setBounds(20, 260, 180, 20);

        lblDescripcion = new JLabel("Descripción");
        lblDescripcion.setBounds(20, 290, 130, 20);

        lblCantHoras = new JLabel("Cantidad de horas");
        lblCantHoras.setBounds(20, 330, 130, 20);

        lblValorHora = new JLabel("Valor por hora");
        lblValorHora.setBounds(20, 370, 130, 20);

        lblReparaciones = new JLabel("Reparaciones:");
        lblReparaciones.setBounds(400, 260, 160, 20);

        lblRepuesto = new JLabel("AGREGAR REPUESTOS:");
        lblRepuesto.setBounds(20, 480, 180, 20);

        lbldescripcionRepuesto = new JLabel("Descripción");
        lbldescripcionRepuesto.setBounds(20, 510, 130, 20);

        lblPrecioRepuesto = new JLabel("Precio");
        lblPrecioRepuesto.setBounds(20, 550, 130, 20);

        lblCantidadRepuesto = new JLabel("Cantidad");
        lblCantidadRepuesto.setBounds(20, 590, 130, 20);

        //combo boxes
        clientesCombo = new JComboBox<ClienteView>();
        clientesCombo.setBounds(20, 45, 130, 40);

        vehiculosCombo = new JComboBox<VehiculoView>();
        vehiculosCombo.setBounds(170, 45, 150, 40);

        tecnicosCombo = new JComboBox<TecnicoView>();
        tecnicosCombo.setBounds(20, 185, 130, 40);

        mesCombo = new JComboBox<Integer>();
        mesCombo.setBounds(170, 185, 150, 40);

        reparacionesCombo = new JComboBox<ReparacionesView>();
        reparacionesCombo.setBounds(400, 280, 160, 50);

        //botones
        btnIniciarReparacion = new JButton("Agregar Reparación");
        btnIniciarReparacion.setBounds(400, 10, 160, 50);

        btnCalcularSalario = new JButton("Calcular Salario");
        btnCalcularSalario.setBounds(400, 180, 160, 50);

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(400, 70, 160, 50);

        btnAgregarManoDeObra = new JButton("Agregar M");
        btnAgregarManoDeObra.setBounds(170, 340, 130, 40);

        btnComenzarReparacion = new JButton("C");
        btnComenzarReparacion.setBounds(400, 350, 80, 50);

        btnFinalizarReparacion = new JButton("F");
        btnFinalizarReparacion.setBounds(480, 350, 80, 50);

        btnRetirarVehiculo = new JButton("Retirar Vehiculo");
        btnRetirarVehiculo.setBounds(400, 430, 160, 70);

        btnAgregarRepuesto = new JButton("Agregar R");
        btnAgregarRepuesto.setBounds(170, 560, 130, 40);


        //txtfields
        txtDescripcion = new JTextField();
        txtDescripcion.setBounds(20, 310, 130, 20);

        txtCantHoras = new JTextField();
        txtCantHoras.setBounds(20, 350, 130, 20);

        txtValorHora = new JTextField();
        txtValorHora.setBounds(20, 390, 130, 20);

        txtdescripcionRepuesto = new JTextField();
        txtdescripcionRepuesto.setBounds(20, 530, 130, 20);

        txtPrecioRepuesto = new JTextField();
        txtPrecioRepuesto.setBounds(20, 570, 130, 20);

        txtCantidadRepuesto = new JTextField();
        txtCantidadRepuesto.setBounds(20, 610, 130, 20);
    }

    private void fillComboBoxes(){
        //los vacio para que refresque la pagina y no se dupliquen
        vehiculosCombo.removeAllItems();
        clientesCombo.removeAllItems();
        tecnicosCombo.removeAllItems();
        mesCombo.removeAllItems();
        reparacionesCombo.removeAllItems();

        //lleno ComboBox clientes
        List<ClienteView> clientesList = TallerController.getInstance().getClientes();
        for (ClienteView cv: clientesList){
            clientesCombo.addItem(cv);
        }
        //lleno ComboBox vehiculos
        List<VehiculoView> vehiculosList = TallerController.getInstance().getVehiculos();
        for (VehiculoView vv: vehiculosList){
            vehiculosCombo.addItem(vv);
        }
        //lleno ComboBox tecnicos
        List<TecnicoView> tecnicosList = TallerController.getInstance().getTecnicos();
        for (TecnicoView tv: tecnicosList){
            tecnicosCombo.addItem(tv);
        }
        //lleno ComboBox meses
        for (int i = 1; i < 13; i++){
             mesCombo.addItem(i);
        }
        //lleno ComboBox reparaciones
        List<ReparacionesView> reparacionesList = TallerController.getInstance().getReparaciones();
        for (ReparacionesView rv: reparacionesList){
            reparacionesCombo.addItem(rv);
        }
        //seteo que se seleccionen en null
        setDefaultNull();
    }

    private void addItemsToLayout(Container c){
        c.add(lblCliente);
        c.add(lblVehiculo);
        c.add(lblTecnico);
        c.add(lblMes);
        c.add(lblManoDeObra);
        c.add(lblDescripcion);
        c.add(lblCantHoras);
        c.add(lblValorHora);
        c.add(lblReparaciones);
        c.add(lblRepuesto);
        c.add(lbldescripcionRepuesto);
        c.add(lblCantidadRepuesto);
        c.add(lblPrecioRepuesto);
        //comboxes
        c.add(clientesCombo);
        c.add(vehiculosCombo);
        c.add(tecnicosCombo);
        c.add(mesCombo);
        c.add(reparacionesCombo);
        //botones
        c.add(btnIniciarReparacion);
        c.add(btnCalcularSalario);
        c.add(btnSalir);
        c.add(btnAgregarManoDeObra);
        c.add(btnComenzarReparacion);
        c.add(btnFinalizarReparacion);
        c.add(btnRetirarVehiculo);
        c.add(btnAgregarRepuesto);
        //txtfields
        c.add(txtCantHoras);
        c.add(txtValorHora);
        c.add(txtDescripcion);
        c.add(txtdescripcionRepuesto);
        c.add(txtCantidadRepuesto);
        c.add(txtPrecioRepuesto);
    }

    private void manejoEventos(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnIniciarReparacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClienteView cSelect = (ClienteView) clientesCombo.getSelectedItem();
                VehiculoView vSelect = (VehiculoView) vehiculosCombo.getSelectedItem();

                //genero una nueva reparacion
                TallerController.getInstance().altaDeReparacion(
                        cSelect.getNumeroDocumento(), vSelect.getPatente(), cSelect.getNombre(),
                        cSelect.getTipoDocumento(), vSelect.getAñoVehiculo());
                fillComboBoxes();
            }
        });
        btnCalcularSalario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float salario = 0;
                TecnicoView tSelect = (TecnicoView) tecnicosCombo.getSelectedItem();
                Integer mesSelect = (Integer) mesCombo.getSelectedItem();
                salario = TallerController.getInstance().calcularSalarioTecnico(tSelect.getNumeroDocumento(), mesSelect);
                JOptionPane.showMessageDialog(null, "El salario es: " + salario);
                // buscar un alert mas lindo
            }
        });
        btnAgregarManoDeObra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReparacionesView rSelect = (ReparacionesView) reparacionesCombo.getSelectedItem();
                TecnicoView tSelect = (TecnicoView) tecnicosCombo.getSelectedItem();
                String descripcion = txtDescripcion.getText();
                String cantHoras = txtCantHoras.getText();
                String valorHora = txtValorHora.getText();
                int cantHorasInt = 0;
                float valorXhoraFloat = 0;
                try {
                    cantHorasInt = Integer.parseInt(cantHoras);
                    valorXhoraFloat = Float.parseFloat(valorHora);
                } catch (NumberFormatException x){
                    System.out.println("El texto ingresado no es un número válido");
                }
                TallerController.getInstance().modificarReparacionManoObra(rSelect.getIdReparacion(), descripcion, cantHorasInt,
                        valorXhoraFloat, tSelect.getNumeroDocumento());

                /* ver mano de obra -->
                for (ManoDeObra t: rSelect.getListaManodeobra()){
                    System.out.println(t.getDescripcionTrabajo());
                }*/
            }
        });
        btnComenzarReparacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReparacionesView rSelect = (ReparacionesView) reparacionesCombo.getSelectedItem();
                TallerController.getInstance().comenzarRep(rSelect.getIdReparacion());
            }
        });
        btnFinalizarReparacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReparacionesView rSelect = (ReparacionesView) reparacionesCombo.getSelectedItem();
                TallerController.getInstance().finalizarRep(rSelect.getIdReparacion());
            }
        });
        btnRetirarVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VehiculoView vSelect = (VehiculoView) vehiculosCombo.getSelectedItem();
                ReparacionesView rSelect = (ReparacionesView) reparacionesCombo.getSelectedItem();
                try{
                    TallerController.getInstance().retirarAuto(vSelect.getDueñoVehiculo(),vSelect.getPatente(),rSelect.getIdReparacion());
                }catch(NullPointerException x){
                    System.out.println("Seleccione un vehiculo a retirar");
                }
                fillComboBoxes();
            }
        });
        btnAgregarRepuesto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReparacionesView rSelect = (ReparacionesView) reparacionesCombo.getSelectedItem();
                String descripcion = txtdescripcionRepuesto.getText();
                String precioRepuesto = txtPrecioRepuesto.getText();
                String cantidadRepuesto = txtCantidadRepuesto.getText();
                float precioRepuestoFloat = 0;
                int cantidadRepuestoInt = 0;
                try {
                    cantidadRepuestoInt = Integer.parseInt(precioRepuesto);
                    precioRepuestoFloat = Float.parseFloat(cantidadRepuesto);
                } catch (NumberFormatException x){
                    System.out.println("El texto ingresado no es un número válido");
                }
                TallerController.getInstance().modificarReparacionRepuesto(rSelect.getIdReparacion(), descripcion,
                        precioRepuestoFloat, cantidadRepuestoInt);

                /*for (Repuesto r: rSelect.getListaRepuestos()){
                    System.out.println(r.getDescripcionRepuesto());
                } */
            }
        });
    }
}
