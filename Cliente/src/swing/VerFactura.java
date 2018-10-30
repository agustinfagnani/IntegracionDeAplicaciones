package swing;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

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
import java.time.LocalDateTime;

import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class VerFactura extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public VerFactura(Factura f) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VerFactura.class.getResource("/images/Escuela.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 810);
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
		
		
		
		JLabel lblFchEmsion2 = new JLabel(f.getFechaEmision().toLocalDate().toString());
		lblFchEmsion2.setHorizontalAlignment(SwingConstants.CENTER);
		lblFchEmsion2.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 25));
		
		JLabel lblTitular2 = new JLabel(f.getAlumno().getTitular().getNombre());
		lblTitular2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitular2.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 25));
		
		JLabel lblAlumno2 = new JLabel(f.getAlumno().getNombre());
		lblAlumno2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlumno2.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 25));
		
		JLabel lblTotal2 = new JLabel(Float.toString(f.getCostoTotal()));
		lblTotal2.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 30));
		
		JLabel lblNroFactura = new JLabel("Numero");
		lblNroFactura.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		
		JLabel lblNroFactura2 = new JLabel(Integer.toString(f.getNumero()));
		lblNroFactura2.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 25));
		
		JLabel lbltipo = new JLabel(f.getTipo());
		lbltipo.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 25));
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(Color.WHITE);
		textPane.setEditable(false);
		textPane.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		textPane.setText(f.toString());
		StyledDocument doc = textPane.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(252, Short.MAX_VALUE)
							.addComponent(lblFactura, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
							.addGap(121)
							.addComponent(lbltipo, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(563, Short.MAX_VALUE)
							.addComponent(lblTotal)
							.addGap(29)
							.addComponent(lblTotal2, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(62)
							.addComponent(lblTitular, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblTitular2, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
							.addComponent(lblAlumno, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblAlumno2, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
							.addGap(18))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(45)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 674, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNroFactura, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
									.addGap(66)
									.addComponent(lblNroFactura2, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
									.addGap(77)
									.addComponent(lblFchEmision, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblFchEmsion2, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
								.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbltipo, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFactura))
					.addGap(56)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFchEmsion2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFchEmision, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNroFactura2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNroFactura, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTitular, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTitular2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAlumno, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAlumno2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(72)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTotal)
						.addComponent(lblTotal2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(31))
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
