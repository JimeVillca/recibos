package front.pantalla.recibos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class GenerarPdf extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerarPdf frame = new GenerarPdf();
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
	public GenerarPdf() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGenerarRecibos = new JLabel("GENERAR RECIBOS");
		lblGenerarRecibos.setBounds(161, 11, 94, 14);
		contentPane.add(lblGenerarRecibos);
		
		JLabel lblPeriodo = new JLabel("PERIODO:");
		lblPeriodo.setBounds(44, 82, 69, 14);
		contentPane.add(lblPeriodo);
		
		JButton btnGenerarPdf = new JButton("GENERAR PDF");
		btnGenerarPdf.setBounds(224, 185, 103, 23);
		contentPane.add(btnGenerarPdf);
		
		JLabel lblSeleccioneElPeriodo = new JLabel("Seleccione  el periodo o el mes al que pertenecen los registros a generar.");
		lblSeleccioneElPeriodo.setBounds(32, 46, 360, 14);
		contentPane.add(lblSeleccioneElPeriodo);
	}
}
