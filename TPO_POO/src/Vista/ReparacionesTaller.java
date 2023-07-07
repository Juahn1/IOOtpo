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
    private JLabel lblCliente, lblVehiculo, lblMes, lblTecnico, lblManoDeObra, lblDescripcion, lblCantHoras, lblValorHora;
    private JComboBox<ClienteView> clientesCombo;
    private JComboBox<VehiculoView> vehiculosCombo;
    private JComboBox<TecnicoView> tecnicosCombo;
    private JComboBox<Integer> mesCombo;
    private JComboBox<ReparacionesView> reparacionesCombo;
    private JButton btnIniciarReparacion, btnCalcularSalario, btnSalir, btnAgregarManoDeObra, btnRetirarVehiculo;
    private JTextField txtDescripcion, txtCantHoras, txtValorHora;

    public ReparacionesTaller(){
        construirInterfaz();
        manejoEventos();
        this.setVisible(true);
        this.setSize(600, 600);
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
        lblCantHoras.setBounds(20, 350, 130, 20);

        lblValorHora = new JLabel("Valor por hora");
        lblValorHora.setBounds(20, 410, 130, 20);

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
        reparacionesCombo.setBounds(310, 370, 130, 40);

        //botones
        btnIniciarReparacion = new JButton("Iniciar Reparación");
        btnIniciarReparacion.setBounds(400, 10, 160, 50);

        btnCalcularSalario = new JButton("Calcular Salario");
        btnCalcularSalario.setBounds(400, 180, 160, 50);

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(400, 70, 160, 50);

        btnAgregarManoDeObra = new JButton("Agregar");
        btnAgregarManoDeObra.setBounds(170, 370, 130, 40);

        //txtfields
        txtDescripcion = new JTextField();
        txtDescripcion.setBounds(20, 320, 130, 20);

        txtCantHoras = new JTextField();
        txtCantHoras.setBounds(20, 380, 130, 20);

        txtValorHora = new JTextField();
        txtValorHora.setBounds(20, 440, 130, 20);
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
        //txtfields
        c.add(txtCantHoras);
        c.add(txtValorHora);
        c.add(txtDescripcion);
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
                        cSelect.getNumeroDocumento(), vSelect.getPatente(), cSelect.getNombre(), cSelect.getTipoDocumento(),
                        vSelect.getMarca(), vSelect.getModelo(), vSelect.getAñoVehiculo());
                for (VehiculoView v: TallerController.getInstance().getVehiculos()){
                    System.out.println(v.getPatente());
                }
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

            }
        });
    }
}
