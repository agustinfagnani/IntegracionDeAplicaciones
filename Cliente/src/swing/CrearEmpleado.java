package swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Atxy2k.CustomTextField.RestrictedTextField;
import Cliente.Cliente;
import exception.EmpleadoYaExisteException;
import exception.SistemaLiquidacionException;

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
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

public class CrearEmpleado extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtSalario;
	private JTextField textNombre;
	private JTextField txtDireccion;
	private JTextField txtMail;
	private JTextField txtTelefono;
	private JTextField txtCargo;
	private JTextField txtDni;
	private JTextField txtApellido;
	private JTextField txtCbu;

	/**
	 * Create the frame.
	 */
	public CrearEmpleado() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearEmpleado.class.getResource("/images/Escuela.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 631);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblCrearEmpleado = new JLabel("Crear Empleado");
		lblCrearEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrearEmpleado.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 30));
		
		JLabel lblSalario = new JLabel("Salario");
		lblSalario.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		
		txtSalario = new JTextField();
		txtSalario.setFont(new Font("Century Gothic", Font.ITALIC, 15));
		txtSalario.setColumns(10);
		
		ManejoBotones mb= new ManejoBotones();
		mb.obtenerFrame(this);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(mb);
		btnAceptar.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		btnAceptar.setBackground(Color.BLACK);
		btnAceptar.setForeground(Color.WHITE);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(mb);
		btnSalir.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.BLACK);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Century Gothic", Font.ITALIC, 15));
		textNombre.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		
		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Century Gothic", Font.ITALIC, 15));
		txtDireccion.setColumns(10);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		
		txtMail = new JTextField();
		txtMail.setFont(new Font("Century Gothic", Font.ITALIC, 15));
		txtMail.setColumns(10);
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Century Gothic", Font.ITALIC, 15));
		txtTelefono.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		
		txtCargo = new JTextField();
		txtCargo.setFont(new Font("Century Gothic", Font.ITALIC, 15));
		txtCargo.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setFont(new Font("Century Gothic", Font.ITALIC, 15));
		txtDni.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Century Gothic", Font.ITALIC, 15));
		txtApellido.setColumns(10);
		
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 447, Short.MAX_VALUE)
							.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblCrearEmpleado, GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(259)
							.addComponent(lblDni, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(61)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDireccion, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTelefono, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSalario))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtSalario)
								.addComponent(txtTelefono, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCargo)
						.addComponent(lblMail, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblApellido, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCbu, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtCbu, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCargo, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtMail, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
					.addGap(82))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCrearEmpleado)
					.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDni, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(51)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblApellido, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(45)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDireccion, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(52)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTelefono, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtMail, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMail, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addGap(52)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCargo, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCargo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))))
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSalario)
						.addComponent(txtSalario, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCbu, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCbu, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(52)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public class ManejoBotones implements ActionListener {
		
		JFrame crearInscripcion = new JFrame();
		
		public void obtenerFrame(JFrame crearInscripcion) {
			this.crearInscripcion=crearInscripcion;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Salir")) {
				Menu frame = new Menu();
				frame.setVisible(true);
				crearInscripcion.setVisible(false);
			}
			if(e.getActionCommand().equals("Aceptar")) {
				try {
					Cliente.getInstance().crearEmpleado(Integer.parseInt(txtDni.getText()), txtCargo.getText(), textNombre.getText(),txtApellido.getText(), txtDireccion.getText(), txtMail.getText(), txtTelefono.getText(), Float.parseFloat(txtSalario.getText()),txtCbu.getText());
					Menu frame = new Menu();
					frame.setVisible(true);
					crearInscripcion.setVisible(false);
				} catch (NumberFormatException | RemoteException e1) {
					JOptionPane.showMessageDialog(new JFrame(),"Falla al crear empleado", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (EmpleadoYaExisteException e1) {
					JOptionPane.showMessageDialog(new JFrame(),"Empleado ya existe", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (SistemaLiquidacionException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
	}
}
