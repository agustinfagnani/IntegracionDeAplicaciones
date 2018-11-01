package swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Atxy2k.CustomTextField.RestrictedTextField;
import Cliente.Cliente;
import exception.TitularYaExisteException;
import negocio.Credito;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class TarjetaCredito extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtNumero;
	private JTextField txtCvc;


	public TarjetaCredito(JFrame crearTitular, String nombre, int dni, String direccion, String mail, String telefono) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearAlumno.class.getResource("/images/Escuela.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 408);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblDatosCuenta = new JLabel("Datos Cuenta");
		lblDatosCuenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosCuenta.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 30));
		
		ManejoBotones mb= new ManejoBotones();
		mb.obtenerFrameDatos(this, crearTitular, nombre, direccion, telefono, mail, dni);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.setBackground(Color.BLACK);
		btnAceptar.addActionListener(mb);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		
		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Century Gothic", Font.ITALIC, 15));
		txtNumero.setColumns(10);
		
		RestrictedTextField resCbu = new RestrictedTextField(txtNumero);
		resCbu.setLimit(16);
		resCbu.setOnlyNums(true);
		
		JLabel lblCvc = new JLabel("CVC");
		lblCvc.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		
		txtCvc = new JTextField();
		txtCvc.setFont(new Font("Century Gothic", Font.ITALIC, 15));
		txtCvc.setColumns(10);
		
		RestrictedTextField resCbu2 = new RestrictedTextField(txtCvc);
		resCbu2.setLimit(3);
		resCbu2.setOnlyNums(true);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDatosCuenta, GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblCvc, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addGap(26)
									.addComponent(txtCvc, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNumero, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txtNumero, GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)))
							.addGap(42))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(171)
					.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(182, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDatosCuenta)
					.addGap(69)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumero, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCvc, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCvc, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(58)
					.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(26))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public class ManejoBotones implements ActionListener {
		
		JFrame tarjetaCredito = new JFrame();
		JFrame crearTitular = new JFrame();
		String nombre, direccion, telefono, mail;
		int dni;
		
		public void obtenerFrameDatos(JFrame tarjetaCredito,JFrame crearTitular,String nombre,String direccion,String telefono,String mail, int dni) {
			this.tarjetaCredito=tarjetaCredito;
			this.nombre=nombre;
			this.direccion=direccion;
			this.telefono=telefono;
			this.mail=mail;
			this.dni=dni;
			this.crearTitular=crearTitular;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Aceptar")) {
				try {
					Cliente.getInstance().crearTitular(nombre, dni, direccion, mail, telefono, new Credito(txtNumero.getText(),Integer.parseInt(txtCvc.getText())));
					Menu frame = new Menu();
					frame.setVisible(true);
					tarjetaCredito.setVisible(false);
					crearTitular.setVisible(false);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(new JFrame(),"No se puede crear el titular.", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (RemoteException e1) {
					JOptionPane.showMessageDialog(new JFrame(),"No se puede crear el titular.", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (TitularYaExisteException e1) {
					JOptionPane.showMessageDialog(new JFrame(),"El titular ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
	}
}
