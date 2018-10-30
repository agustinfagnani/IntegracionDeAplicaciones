package swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Cliente.Cliente;
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

	/**
	 * Create the frame.
	 */
	public CrearEmpleado() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearEmpleado.class.getResource("/images/Escuela.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
							.addGap(404)
							.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblCrearEmpleado, GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(61)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblTelefono, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDireccion, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(82)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblMail, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCargo))
									.addGap(50))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblDni, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
									.addGap(41)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCargo, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMail, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(246)
							.addComponent(lblSalario)
							.addGap(37)
							.addComponent(txtSalario, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCrearEmpleado)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(72)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addGap(45))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDni, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(48)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtMail, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDireccion, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMail, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(52)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCargo, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefono, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCargo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSalario)
						.addComponent(txtSalario, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
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
					Cliente.getInstance().crearEmpleado(Integer.parseInt(txtDni.getText()), txtCargo.getText(), textNombre.getText(), txtDireccion.getText(), txtMail.getText(), txtTelefono.getText(), Float.parseFloat(txtSalario.getText()));
					Menu frame = new Menu();
					frame.setVisible(true);
					crearInscripcion.setVisible(false);
				} catch (NumberFormatException | RemoteException e1) {
					JOptionPane.showMessageDialog(new JFrame(),"Falla al crear empleado", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
	}
}
