package Vista;
import Controller.TallerController;
import Views.ClienteView;
import Views.TecnicoView;
import Views.VehiculoView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ReparacionesTaller extends JFrame{
    private JLabel lblCliente, lblVehiculo, lblMes, lblTecnico;
    private JComboBox<ClienteView> clientesCombo;
    private JComboBox<VehiculoView> vehiculosCombo;
    private JComboBox<TecnicoView> tecnicosCombo;
    private JComboBox<Integer> mesCombo;
    private JButton btnIniciarReparacion, btnCalcularSalario, btnSalir;

    public ReparacionesTaller(){
        construirInterfaz();
        manejoEventos();
        this.setVisible(true);
        this.setSize(600, 500);
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

        //seteo que se seleccionen en null
        setDefaultNull();
    }

    private void setDefaultNull(){
        //default = empty
        clientesCombo.setSelectedItem(null);
        vehiculosCombo.setSelectedItem(null);
        tecnicosCombo.setSelectedItem(null);
        mesCombo.setSelectedItem(null);
    }
    private void declararItems(){
        //labels
        lblCliente = new JLabel("Cientes");
        lblCliente.setBounds(20, 10, 130, 30);

        lblVehiculo = new JLabel("Vehiculos");
        lblVehiculo.setBounds(170, 10, 150, 30);

        lblTecnico = new JLabel("Tecnicos");
        lblTecnico.setBounds(20, 170, 130, 30);

        lblMes = new JLabel("Ingrese el mes");
        lblMes.setBounds(170, 170, 150, 30);

        //combo boxes
        clientesCombo = new JComboBox<ClienteView>();
        clientesCombo.setBounds(20, 45, 130, 40);

        vehiculosCombo = new JComboBox<VehiculoView>();
        vehiculosCombo.setBounds(170, 45, 150, 40);

        tecnicosCombo = new JComboBox<TecnicoView>();
        tecnicosCombo.setBounds(20, 205, 130, 40);

        mesCombo = new JComboBox<Integer>();
        mesCombo.setBounds(170, 205, 150, 40);

        //botones
        btnIniciarReparacion = new JButton("Iniciar Reparación");
        btnIniciarReparacion.setBounds(400, 10, 160, 50);

        btnCalcularSalario = new JButton("Calcular Salario");
        btnCalcularSalario.setBounds(400, 200, 160, 50);

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(400, 70, 160, 50);
    }
    private void fillComboBoxes(){
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
    }
    private void addItemsToLayout(Container c){
        c.add(lblCliente);
        c.add(lblVehiculo);
        c.add(lblTecnico);
        c.add(lblMes);
        //comboxes
        c.add(clientesCombo);
        c.add(vehiculosCombo);
        c.add(tecnicosCombo);
        c.add(mesCombo);
        //botones
        c.add(btnIniciarReparacion);
        c.add(btnCalcularSalario);
        c.add(btnSalir);
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
    }
}
