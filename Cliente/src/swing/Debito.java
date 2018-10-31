package swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Atxy2k.CustomTextField.RestrictedTextField;
import Cliente.Cliente;
import exception.TitularYaExisteException;
import negocio.Deposito;

import javax.swing.JLabel;

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

public class Debito extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtCbu;


	public Debito(JFrame crearTitular, String nombre, int dni, String direccion, String mail, String telefono) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearAlumno.class.getResource("/images/Escuela.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 287);
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
		
		JLabel lblCbu = new JLabel("CBU");
		lblCbu.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		
		txtCbu = new JTextField();
		txtCbu.setFont(new Font("Century Gothic", Font.ITALIC, 15));
		txtCbu.setColumns(10);
		
		RestrictedTextField resCbu = new RestrictedTextField(txtCbu);
		resCbu.setLimit(22);
		resCbu.setOnlyNums(true);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDatosCuenta, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
							.addGap(131))))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addComponent(lblCbu, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtCbu, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
					.addGap(53))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDatosCuenta)
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCbu, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCbu, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(29))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public class ManejoBotones implements ActionListener {
		
		JFrame debito = new JFrame();
		JFrame crearTitular = new JFrame();
		String nombre, direccion, telefono, mail;
		int dni;
		
		public void obtenerFrameDatos(JFrame debito,JFrame crearTitular,String nombre,String direccion,String telefono,String mail, int dni) {
			this.debito=debito;
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
					Cliente.getInstance().crearTitular(nombre, dni, direccion, mail, telefono, new Deposito(txtCbu.getText()));
					Menu frame = new Menu();
					frame.setVisible(true);
					debito.setVisible(false);
					crearTitular.setVisible(false);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (TitularYaExisteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
	}
}

