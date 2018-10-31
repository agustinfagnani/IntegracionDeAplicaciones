package swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import javax.swing.JComboBox;

public class CrearTitular extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtMail;
	private JTextField txtTelefono;
	private JComboBox cmBoxFP;

	/**
	 * Create the frame.
	 */
	public CrearTitular() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearTitular.class.getResource("/images/Escuela.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 661);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		ManejoBotones mb= new ManejoBotones();
		mb.obtenerFrame(this);
		
		JLabel lblCrearTitular = new JLabel("Crear Titular");
		lblCrearTitular.setBackground(Color.BLACK);
		lblCrearTitular.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrearTitular.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 30));
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		
		txtDni = new JTextField();
		txtDni.setFont(new Font("Century Gothic", Font.ITALIC, 15));
		txtDni.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		btnAceptar.setBackground(Color.BLACK);
		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.addActionListener(mb);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.BLACK);
		btnSalir.addActionListener(mb);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Century Gothic", Font.ITALIC, 15));
		txtNombre.setColumns(10);
		
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
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Century Gothic", Font.ITALIC, 15));
		txtTelefono.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		
		JLabel lblFormaDePago = new JLabel("Forma de Pago");
		lblFormaDePago.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		
		cmBoxFP = new JComboBox();
		cmBoxFP.setForeground(Color.WHITE);
		cmBoxFP.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		cmBoxFP.setBackground(Color.BLACK);
		cmBoxFP.addItem("Debito");
		cmBoxFP.addItem("Credito");
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
							.addGap(404)
							.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblCrearTitular, GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(245)
							.addComponent(lblDni)
							.addGap(50)
							.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(51, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDireccion, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblFormaDePago)
							.addGap(18)
							.addComponent(cmBoxFP, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
									.addGap(72)
									.addComponent(lblMail, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
									.addGap(64))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblTelefono, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
									.addGap(26)))
							.addGap(26)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMail, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))))
					.addGap(48))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCrearTitular)
					.addGap(76)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDni)
						.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(77)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtMail, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMail, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefono, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDireccion, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(95)
							.addComponent(lblFormaDePago, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cmBoxFP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(136))))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public class ManejoBotones implements ActionListener {
		
		JFrame crearTitular = new JFrame();
		
		public void obtenerFrame(JFrame crearTitular) {
			this.crearTitular=crearTitular;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Salir")) {
				Menu frame = new Menu();
				frame.setVisible(true);
				crearTitular.setVisible(false);
			}
			if(e.getActionCommand().equals("Aceptar")) {
				try {
					
					if(cmBoxFP.getSelectedItem().equals("Debito")) {
						Debito frame = new Debito(crearTitular, txtNombre.getText(), Integer.parseInt(txtDni.getText()), txtDireccion.getText(), txtMail.getText(), txtTelefono.getText());
						frame.setVisible(true);
					}
					if(cmBoxFP.getSelectedItem().equals("Credito")) {
						TarjetaCredito frame = new TarjetaCredito(crearTitular, txtNombre.getText(), Integer.parseInt(txtDni.getText()), txtDireccion.getText(), txtMail.getText(), txtTelefono.getText());
						frame.setVisible(true);
					}

				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(new JFrame(),"El DNI ingresado es invalido", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
	}
}
