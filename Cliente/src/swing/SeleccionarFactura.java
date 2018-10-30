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
import exception.PeriodoNoFacturadoException;
import exception.TitularNoExisteException;
import negocio.Factura;
import negocio.Titular;

import javax.swing.JComboBox;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SeleccionarFactura extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JComboBox comboBox, comboBox_1;
	private JComboBox <Titular> cmBoxTitular;

	/**
	 * Create the frame.
	 */
	public SeleccionarFactura() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Facturar.class.getResource("/images/Escuela.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		ManejoBotones mb= new ManejoBotones();
		mb.obtenerFrame(this);
		
		JLabel lblFacturar = new JLabel("Facturar");
		lblFacturar.setHorizontalAlignment(SwingConstants.CENTER);
		lblFacturar.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 30));
		
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
		
		JLabel lblPeriodo = new JLabel("Periodo");
		lblPeriodo.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		
		JLabel lblAno = new JLabel("A\u00F1o");
		lblAno.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		
		comboBox = new JComboBox();
		comboBox.setForeground(Color.WHITE);
		comboBox.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		comboBox.setBackground(Color.BLACK);
		
		for(int i=1;i<13;i++)
			comboBox.addItem(i);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setForeground(Color.WHITE);
		comboBox_1.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		comboBox_1.setBackground(Color.BLACK);
		
		for(int i=2018;i<2022;i++)
			comboBox_1.addItem(i);
		
		JLabel lblTitular = new JLabel("Titular");
		lblTitular.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		
		cmBoxTitular = new JComboBox<Titular>();
		cmBoxTitular.setForeground(Color.WHITE);
		cmBoxTitular.setFont(new Font("Century Gothic", Font.ITALIC, 20));
		cmBoxTitular.setBackground(Color.BLACK);
		
		try {
			for(Titular t: Cliente.getInstance().getTitulares())
				cmBoxTitular.addItem(t);
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(new JFrame(),"Falla al cargar titulares", "Error", JOptionPane.ERROR_MESSAGE);
		}

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
							.addComponent(lblFacturar, GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(148)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAno, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPeriodo, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTitular, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
							.addGap(57)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(cmBoxTitular, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(comboBox, 0, 298, Short.MAX_VALUE)
								.addComponent(comboBox_1, 0, 298, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addComponent(lblFacturar)
					.addGap(66)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTitular, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmBoxTitular, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(58)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPeriodo, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(57)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAno, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public class ManejoBotones implements ActionListener {
		
		JFrame facturar = new JFrame();
		
		public void obtenerFrame(JFrame facturar) {
			this.facturar=facturar;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Salir")) {
				Menu frame = new Menu();
				frame.setVisible(true);
				facturar.setVisible(false);
			}
			if(e.getActionCommand().equals("Aceptar")) {
				try {
					Titular t= (Titular) cmBoxTitular.getSelectedItem();
					Factura f = Cliente.getInstance().verFacturaTitular(t.getDNI(),Integer.parseInt(comboBox.getSelectedItem().toString()),Integer.parseInt(comboBox_1.getSelectedItem().toString()));
					VerFactura frame = new VerFactura(f);
					frame.setVisible(true);
					facturar.setVisible(false);
				} catch (RemoteException e1) {
					JOptionPane.showMessageDialog(new JFrame(),"No se puede crear la factura deseada", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(new JFrame(),"No se puede crear la factura deseada", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (PeriodoNoFacturadoException e1) {
					JOptionPane.showMessageDialog(new JFrame(),"Periodo no facturado", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (TitularNoExisteException e1) {
					JOptionPane.showMessageDialog(new JFrame(),"El titular no existe", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
	}
}
