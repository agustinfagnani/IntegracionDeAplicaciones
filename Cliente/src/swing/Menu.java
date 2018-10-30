package swing;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public Menu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/images/Escuela.png")));
		setForeground(Color.BLACK);
		setFont(new Font("Century", Font.BOLD | Font.ITALIC, 17));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.BLACK);
		setJMenuBar(menuBar);
		menuBar.setBounds(20, 20, 800, 500);
		
		ManejoBotones mb= new ManejoBotones();
		mb.obtenerFrame(this);
		
		JMenu mnAlumnos = new JMenu("Alumnos");
		mnAlumnos.setForeground(Color.WHITE);
		mnAlumnos.setHorizontalAlignment(SwingConstants.CENTER);
		mnAlumnos.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		menuBar.add(mnAlumnos);
		
		JMenuItem itemCrearAlumno = new JMenuItem("Crear Alumno");
		itemCrearAlumno.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		itemCrearAlumno.setForeground(Color.WHITE);
		itemCrearAlumno.setBackground(Color.BLACK);
		itemCrearAlumno.addActionListener(mb);
		mnAlumnos.add(itemCrearAlumno);
		
		
		JMenuItem itemModificarAlumno = new JMenuItem("Modificar Alumno");
		itemModificarAlumno.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		itemModificarAlumno.setForeground(Color.WHITE);
		itemModificarAlumno.setBackground(Color.BLACK);
		itemModificarAlumno.addActionListener(mb);
		mnAlumnos.add(itemModificarAlumno);
		
		JMenuItem itemBajaAlumno = new JMenuItem("Baja Alumno");
		itemBajaAlumno.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		itemBajaAlumno.setForeground(Color.WHITE);
		itemBajaAlumno.setBackground(Color.BLACK);
		itemBajaAlumno.addActionListener(mb);
		mnAlumnos.add(itemBajaAlumno);
		
		JMenu mnEmpleados = new JMenu("Empleados");
		mnEmpleados.setForeground(Color.WHITE);
		mnEmpleados.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		menuBar.add(mnEmpleados);
		
		JMenuItem itemCrearEmpleado = new JMenuItem("Crear Empleado");
		itemCrearEmpleado.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		itemCrearEmpleado.setForeground(Color.WHITE);
		itemCrearEmpleado.setBackground(Color.BLACK);
		mnEmpleados.add(itemCrearEmpleado);
		itemCrearEmpleado.addActionListener(mb);
		
		JMenuItem itemModificarEmpleado = new JMenuItem("Modificar Empleado");
		itemModificarEmpleado.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		itemModificarEmpleado.setBackground(Color.BLACK);
		itemModificarEmpleado.setForeground(Color.WHITE);
		itemModificarEmpleado.addActionListener(mb);
		mnEmpleados.add(itemModificarEmpleado);
		
		JMenuItem itemBajaEmpleado = new JMenuItem("Baja Empleado");
		itemBajaEmpleado.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		itemBajaEmpleado.setForeground(Color.WHITE);
		itemBajaEmpleado.setBackground(Color.BLACK);
		itemBajaEmpleado.addActionListener(mb);
		mnEmpleados.add(itemBajaEmpleado);
		
		JMenu mnTitulares = new JMenu("Titulares");
		mnTitulares.setForeground(Color.WHITE);
		mnTitulares.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		menuBar.add(mnTitulares);
		
		JMenuItem itemCrearTitular = new JMenuItem("Crear Titular");
		itemCrearTitular.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		itemCrearTitular.setForeground(Color.WHITE);
		itemCrearTitular.setBackground(Color.BLACK);
		itemCrearTitular.addActionListener(mb);
		mnTitulares.add(itemCrearTitular);
		
		JMenuItem itemModificarTitular = new JMenuItem("Modificar Titular");
		itemModificarTitular.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		itemModificarTitular.setForeground(Color.WHITE);
		itemModificarTitular.setBackground(Color.BLACK);
		itemModificarTitular.addActionListener(mb);
		mnTitulares.add(itemModificarTitular);
		
		JMenuItem itemBajaTitular = new JMenuItem("Baja Titular");
		itemBajaTitular.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		itemBajaTitular.setForeground(Color.WHITE);
		itemBajaTitular.setBackground(Color.BLACK);
		itemBajaTitular.addActionListener(mb);
		mnTitulares.add(itemBajaTitular);
		
		JMenu mnInscripcionesYFacturacion = new JMenu("Inscripciones y Facturacion");
		mnInscripcionesYFacturacion.setForeground(Color.WHITE);
		mnInscripcionesYFacturacion.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		menuBar.add(mnInscripcionesYFacturacion);
		
		JMenuItem itemFacturar = new JMenuItem("Facturar");
		itemFacturar.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		itemFacturar.setForeground(Color.WHITE);
		itemFacturar.setBackground(Color.BLACK);
		itemFacturar.addActionListener(mb);
		mnInscripcionesYFacturacion.add(itemFacturar);
		
		JMenuItem itemCrearInscripcion = new JMenuItem("Crear Inscripcion");
		itemCrearInscripcion.setForeground(Color.WHITE);
		itemCrearInscripcion.setBackground(Color.BLACK);
		itemCrearInscripcion.addActionListener(mb);
		itemCrearInscripcion.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		mnInscripcionesYFacturacion.add(itemCrearInscripcion);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblEscuela = new JLabel("Escuela");
		lblEscuela.setForeground(Color.BLACK);
		lblEscuela.setBackground(new Color(255, 255, 255));
		lblEscuela.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 80));
		lblEscuela.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblEscuela, BorderLayout.CENTER);
	}
	
	public class ManejoBotones implements ActionListener {

		JFrame menu = new JFrame();
		
		public void obtenerFrame(JFrame menu) {
			this.menu=menu;
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Crear Alumno")) {
				CrearAlumno frame = new CrearAlumno();
				frame.setVisible(true);
				menu.setVisible(false);
				
			}
			if(e.getActionCommand().equals("Crear Titular")) {
				CrearTitular frame = new CrearTitular();
				frame.setVisible(true);
				menu.setVisible(false);
				
			}
			if(e.getActionCommand().equals("Facturar")) {
				Facturar frame = new Facturar();
				frame.setVisible(true);
				menu.setVisible(false);
				
			}
			if(e.getActionCommand().equals("Crear Inscripcion")) {
				CrearInscripcion frame = new CrearInscripcion();
				frame.setVisible(true);
				menu.setVisible(false);
				
			}
			if(e.getActionCommand().equals("Crear Empleado")) {
				CrearEmpleado frame = new CrearEmpleado();
				frame.setVisible(true);
				menu.setVisible(false);
				
			}
			
		}
		
	}

}


