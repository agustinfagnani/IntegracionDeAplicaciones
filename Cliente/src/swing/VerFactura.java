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
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextPane;
import javax.swing.ImageIcon;

public class VerFactura extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public VerFactura(Factura f) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VerFactura.class.getResource("/images/Escuela.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 885);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		ManejoBotones mb = new ManejoBotones();
		mb.obtenerFrame(this);
		
		JLabel lblFactura = new JLabel("Factura");
		lblFactura.setBounds(319, 30, 279, 38);
		lblFactura.setHorizontalAlignment(SwingConstants.CENTER);
		lblFactura.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 30));
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(630, 774, 61, 32);
		lblTotal.setFont(new Font("Century Gothic", Font.ITALIC, 25));
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(28, 776, 162, 33);
		btnSalir.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.BLACK);
		btnSalir.addActionListener(mb);
		
		JLabel lblTitular = new JLabel("Titular");
		lblTitular.setBounds(81, 198, 87, 26);
		lblTitular.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		
		JLabel lblFchEmision = new JLabel("Fecha de Emision");
		lblFchEmision.setBounds(347, 124, 179, 26);
		lblFchEmision.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		
		

		JLabel lblFchEmsion2 = new JLabel(f.getFechaEmision().toLocalDate().toString());
		lblFchEmsion2.setBounds(533, 124, 294, 26);
		lblFchEmsion2.setHorizontalAlignment(SwingConstants.CENTER);
		lblFchEmsion2.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 25));
		
		JLabel lblTitular2 = new JLabel(f.getTitular().getNombre());
		lblTitular2.setBounds(175, 198, 262, 26);
		lblTitular2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitular2.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 25));
		
		JLabel lblTotal2 = new JLabel(Float.toString(f.getCostoTotal()));
		lblTotal2.setBounds(720, 774, 107, 32);
		lblTotal2.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 30));
		
		JLabel lblNroFactura = new JLabel("Numero");
		lblNroFactura.setBounds(50, 124, 87, 26);
		lblNroFactura.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		
		JLabel lblNroFactura2 = new JLabel(Integer.toString(f.getNumero()));
		lblNroFactura2.setBounds(203, 124, 67, 26);
		lblNroFactura2.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 25));
		
		JLabel lbltipo = new JLabel(f.getTipo());
		lbltipo.setBounds(719, 30, 108, 26);
		lbltipo.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 25));
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(91, 328, 674, 315);
		textPane.setBackground(Color.WHITE);
		textPane.setEditable(false);
		textPane.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		textPane.setText(f.toString());
		StyledDocument doc = textPane.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		
		JLabel lblPeriodo = new JLabel("Periodo");
		lblPeriodo.setBounds(449, 198, 87, 26);
		lblPeriodo.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		
		JLabel lblPeriodo2 = new JLabel("0"+Integer.toString(f.getPeriodo()));
		lblPeriodo2.setBounds(554, 198, 129, 26);
		lblPeriodo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeriodo2.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 25));
		
		JLabel label = new JLabel("-");
		label.setBounds(701, 198, 24, 26);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 25));
		
		JLabel lblAno = new JLabel(Integer.toString(f.getAnio()));
		lblAno.setBounds(732, 198, 95, 26);
		lblAno.setHorizontalAlignment(SwingConstants.CENTER);
		lblAno.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 25));
		
		JLabel lblPaid = new JLabel();
		lblPaid.setIcon(new ImageIcon(VerFactura.class.getResource("/images/Paid4.png")));
		lblPaid.setBounds(239, 237, 560, 505);
		lblPaid.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		
		if(f.getFechaPago()==null) {
			lblPaid.setVisible(false);
		}
		
		contentPane.setLayout(null);
		contentPane.add(lblFactura);
		contentPane.add(lbltipo);
		contentPane.add(lblNroFactura);
		contentPane.add(lblNroFactura2);
		contentPane.add(lblFchEmision);
		contentPane.add(lblFchEmsion2);
		contentPane.add(lblTitular);
		contentPane.add(lblTitular2);
		contentPane.add(lblPeriodo);
		contentPane.add(lblPeriodo2);
		contentPane.add(label);
		contentPane.add(lblAno);
		contentPane.add(btnSalir);
		contentPane.add(lblPaid);
		contentPane.add(lblTotal);
		contentPane.add(lblTotal2);
		contentPane.add(textPane);
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
