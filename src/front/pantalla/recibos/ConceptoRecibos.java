package front.pantalla.recibos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class ConceptoRecibos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConceptoRecibos frame = new ConceptoRecibos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConceptoRecibos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConsultaRecibos = new JLabel("Consulta Recibos");
		lblConsultaRecibos.setBounds(250, 11, 100, 14);
		contentPane.add(lblConsultaRecibos);
		
		JLabel lblIngreseParamentrosPara = new JLabel("Ingrese paramentros para poder realizar la consulta");
		lblIngreseParamentrosPara.setBounds(175, 46, 268, 14);
		contentPane.add(lblIngreseParamentrosPara);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(70, 79, 46, 14);
		contentPane.add(lblUsuario);
		
		textField = new JTextField();
		textField.setBounds(150, 76, 119, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNroDocumento = new JLabel("Nro Documento");
		lblNroDocumento.setBounds(42, 118, 74, 14);
		contentPane.add(lblNroDocumento);
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 115, 119, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNroRecibo = new JLabel("Nro Recibo");
		lblNroRecibo.setBounds(314, 79, 59, 14);
		contentPane.add(lblNroRecibo);
		
		JLabel lblPeriodo = new JLabel("Periodo");
		lblPeriodo.setBounds(327, 118, 46, 14);
		contentPane.add(lblPeriodo);
		
		textField_2 = new JTextField();
		textField_2.setBounds(383, 76, 119, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(383, 114, 119, 22);
		contentPane.add(comboBox);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(431, 164, 91, 23);
		contentPane.add(btnBuscar);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 212, 516, 250);
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
	}
}
