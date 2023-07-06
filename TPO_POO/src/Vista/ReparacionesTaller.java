package Vista;
import Controller.TallerController;
import Model.Cliente;
import Model.Vehiculo;
import Views.ClienteView;
import Views.ReparacionesView;
import Views.VehiculoView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ReparacionesTaller extends JFrame{
    private JLabel lblCliente, lblVehiculo;
    private JComboBox<ClienteView> clientesCombo;
    private JComboBox<VehiculoView> vehiculosCombo;
    private JComboBox<ReparacionesView> reparacionesList;
    private JButton btnIniciarReparacion, btnBorrar, btnSalir;

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
        //combo boxes
        clientesCombo = new JComboBox<ClienteView>();
        clientesCombo.setBounds(20, 60, 130, 40);

        vehiculosCombo = new JComboBox<VehiculoView>();
        vehiculosCombo.setBounds(170, 60, 150, 40);
        //botones
        btnIniciarReparacion = new JButton("Iniciar Reparación");
        btnIniciarReparacion.setBounds(350, 10, 120, 50);

        btnBorrar = new JButton("Borrar todo");
        btnBorrar.setBounds(350, 70, 120, 50);

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(350, 140, 120, 50);

        //Jlist
        reparacionesList = new JComboBox<ReparacionesView>();
        reparacionesList.setBounds(50, 300, 200, 100);

        //lleno ComboBox?

        List<ClienteView> clientesList = TallerController.getInstance().getClientes();
        for (ClienteView cv: clientesList){
            clientesCombo.addItem(cv);
        }

        List<VehiculoView> vehiculosList = TallerController.getInstance().getVehiculos();
        for (VehiculoView vv: vehiculosList){
            vehiculosCombo.addItem(vv);
        }

        c.add(lblCliente);
        c.add(lblVehiculo);
        c.add(clientesCombo);
        c.add(vehiculosCombo);
        c.add(btnIniciarReparacion);
        c.add(btnBorrar);
        c.add(btnSalir);
        c.add(reparacionesList);
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

                //genero la reparacion
                TallerController.getInstance().altaDeReparacion(
                        cSelect.getNumeroDocumento(), vSelect.getPatente(), cSelect.getNombre(), cSelect.getTipoDocumento(),
                        vSelect.getMarca(), vSelect.getModelo(), vSelect.getAñoVehiculo());
                //agregarla a JListReparaciones
                List<ReparacionesView> reparaciones = TallerController.getInstance().getReparaciones();
                for (ReparacionesView rv: reparaciones) {
                    reparacionesList.addItem(rv);
                }
            }
        });
    }

}
