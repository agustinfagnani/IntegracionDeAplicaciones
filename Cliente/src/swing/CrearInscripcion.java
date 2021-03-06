package swing;

import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import Cliente.Cliente;
import exception.AdicionalNoExisteException;
import exception.AdicionalYaAsignadoException;
import exception.AlumnoNoExisteException;
import negocio.Adicional;
import negocio.Alumno;
import javax.swing.JComboBox;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class CrearInscripcion extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	JComboBox<Adicional> comboBox;
	JComboBox<Alumno> cmBoxLegajo;

	/**
	 * Create the frame.
	 */
	public CrearInscripcion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearInscripcion.class.getResource("/images/Escuela.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		ManejoBotones mb = new ManejoBotones();
		mb.obtenerFrame(this);
		
		JLabel lblCrearInscripcion = new JLabel("Crear Inscripcion");
		lblCrearInscripcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrearInscripcion.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 30));
		
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
		
		JLabel lblAdicional = new JLabel("Adicional");
		lblAdicional.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		
		JLabel lblSeleccioneElLegajo = new JLabel("Seleccione el legajo del alumno al cual se desea inscribir");
		lblSeleccioneElLegajo.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		
		JLabel lblLegajo = new JLabel("Legajo");
		lblLegajo.setHorizontalAlignment(SwingConstants.LEFT);
		lblLegajo.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		
		cmBoxLegajo = new JComboBox<Alumno>();
		cmBoxLegajo.setForeground(Color.WHITE);
		cmBoxLegajo.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		cmBoxLegajo.setBackground(Color.BLACK);
	
		
		try {
			for (Alumno alu: Cliente.getInstance().getAlumnos())
			{
				cmBoxLegajo.addItem(alu);
			}
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(new JFrame(),"Falla al cargar los alumnos", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
		comboBox = new JComboBox<Adicional>();
		comboBox.setForeground(Color.WHITE);
		comboBox.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		comboBox.setBackground(Color.BLACK);
		
		try {
			for (Adicional adic: Cliente.getInstance().getAdicionales())
			{
				comboBox.addItem(adic);
			}
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(new JFrame(),"Falla al cargar los adicionales", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
		JLabel lblSeleccioneElAdicional = new JLabel("Seleccione el adicional que se quiere contratar para el alumno");
		lblSeleccioneElAdicional.setFont(new Font("Century Gothic", Font.ITALIC, 20));
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
							.addComponent(lblCrearInscripcion, GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(156)
					.addComponent(lblLegajo, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(cmBoxLegajo, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(216, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(143, Short.MAX_VALUE)
					.addComponent(lblAdicional, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
					.addGap(220))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(104)
					.addComponent(lblSeleccioneElLegajo)
					.addContainerGap(109, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(79, Short.MAX_VALUE)
					.addComponent(lblSeleccioneElAdicional)
					.addGap(71))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addComponent(lblCrearInscripcion)
					.addGap(51)
					.addComponent(lblSeleccioneElAdicional, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAdicional, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addComponent(lblSeleccioneElLegajo, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLegajo, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
						.addComponent(cmBoxLegajo, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
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
				Alumno alum= (Alumno) cmBoxLegajo.getSelectedItem();
				Adicional adic =(Adicional) comboBox.getSelectedItem();
				try {
					Cliente.getInstance().asignarInscripcion(alum.getLegajo(), adic.getId());
					Menu frame = new Menu();
					frame.setVisible(true);
					crearInscripcion.setVisible(false);
				} catch (RemoteException e1) {
					JOptionPane.showMessageDialog(new JFrame(),"Falla al asignar el adicional.", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (AlumnoNoExisteException e1) {
					JOptionPane.showMessageDialog(new JFrame(),"El alumno no existe.", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (AdicionalNoExisteException e1) {
					JOptionPane.showMessageDialog(new JFrame(),"El adicional no existe.", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (AdicionalYaAsignadoException e1) {
					JOptionPane.showMessageDialog(new JFrame(),"Ya inscripto.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
	}

}
