package swing;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.Factura;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;
import java.text.SimpleDateFormat;

public class VerFactura extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public VerFactura(Factura f) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VerFactura.class.getResource("/images/Escuela.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		ManejoBotones mb = new ManejoBotones();
		mb.obtenerFrame(this);
		
		JLabel lblFactura = new JLabel("Factura");
		lblFactura.setHorizontalAlignment(SwingConstants.CENTER);
		lblFactura.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 30));
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Century Gothic", Font.ITALIC, 25));
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.BLACK);
		btnSalir.addActionListener(mb);
		
		JLabel lblTitular = new JLabel("Titular");
		lblTitular.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		
		JLabel lblAlumno = new JLabel("Alumno");
		lblAlumno.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		
		JLabel lblFchEmision = new JLabel("Fecha de Emision");
		lblFchEmision.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		
		Format formato=new SimpleDateFormat("yyyy-MM-dd");
		String fecha=formato.format(f.getFechaEmision());
		
		JLabel lblFchEmsion2 = new JLabel(fecha);
		lblFchEmsion2.setHorizontalAlignment(SwingConstants.CENTER);
		lblFchEmsion2.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 25));
		
		JLabel lblTitular2 = new JLabel(f.getAlumno().getTitular().getNombre());
		lblTitular2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitular2.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 25));
		
		JLabel lblAlumno2 = new JLabel(f.getAlumno().getNombre());
		lblAlumno2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlumno2.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 25));
		
		JLabel lblTotal2 = new JLabel("(Total)");
		lblTotal2.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 30));
		
		JLabel lblNroFactura = new JLabel("Numero");
		lblNroFactura.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		
		JLabel lblNroFactura2 = new JLabel(Integer.toString(f.getNumero()));
		lblNroFactura2.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 25));
		
		JLabel lbltipo = new JLabel(f.getTipo());
		lbltipo.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 25));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
							.addGap(465))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblFactura, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
							.addGap(121)))
					.addComponent(lbltipo, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(84)
							.addComponent(lblTitular, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblTitular2, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
							.addComponent(lblAlumno, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNroFactura, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(lblNroFactura2, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(lblFchEmision, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblAlumno2, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
							.addGap(40))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblFchEmsion2, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
							.addContainerGap())))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(242)
					.addComponent(lblTotal)
					.addGap(97)
					.addComponent(lblTotal2, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(286, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbltipo, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFactura))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(56)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFchEmsion2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFchEmision, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNroFactura2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(57)
							.addComponent(lblNroFactura, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addGap(81)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTitular, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAlumno, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTitular2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAlumno2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(70)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTotal)
							.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
							.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTotal2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		contentPane.setLayout(gl_contentPane);
	}
	
	public class ManejoBotones implements ActionListener {
		
		JFrame verFactura = new JFrame();
		
		public void obtenerFrame(JFrame verFactura) {
			this.verFactura=verFactura;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Salir")) {
				Menu frame = new Menu();
				frame.setVisible(true);
				verFactura.setVisible(false);
			}
		}
		
	}
}
