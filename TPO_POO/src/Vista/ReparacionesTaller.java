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
    private JButton btnIniciarReparacion, btnCalcularSalario, btnSalir;
    private JTextField txtMes;

    public ReparacionesTaller(){
        construirInterfaz();
        manejoEventos();
        this.setVisible(true);
        this.setSize(500, 500);
    }

    private void construirInterfaz(){
        Container c = this.getContentPane();
        c.setLayout(null);

        //labels
        lblCliente = new JLabel("Cientes");
        lblCliente.setBounds(20, 10, 130, 50);

        lblVehiculo = new JLabel("Vehiculos");
        lblVehiculo.setBounds(170, 10, 150, 50);

        lblMes = new JLabel("Ingrese el mes para facturar");
        lblMes.setBounds(20, 170, 130, 50);
        //combo boxes
        clientesCombo = new JComboBox<ClienteView>();
        clientesCombo.setBounds(20, 60, 130, 40);

        vehiculosCombo = new JComboBox<VehiculoView>();
        vehiculosCombo.setBounds(170, 60, 150, 40);

        tecnicosCombo = new JComboBox<TecnicoView>();
        tecnicosCombo.setBounds(20, 180, 130, 40);

        //botones
        btnIniciarReparacion = new JButton("Iniciar Reparación");
        btnIniciarReparacion.setBounds(350, 10, 120, 50);

        btnCalcularSalario = new JButton("Calcular Salario");
        btnCalcularSalario.setBounds(350, 200, 120, 50);

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(350, 70, 120, 50);

        //txt
        txtMes = new JTextField();
        txtMes.setBounds(20, 220, 130, 50);

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

        c.add(lblCliente);
        c.add(lblVehiculo);
        c.add(clientesCombo);
        c.add(vehiculosCombo);
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

                TallerController.getInstance().calcularSalarioTecnico();
            }
        });
    }
}
