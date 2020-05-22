package front.pantalla.recibos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Panel;
import java.awt.ScrollPane;

public class ConceptosConceptos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConceptosConceptos frame = new ConceptosConceptos();
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
	public ConceptosConceptos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConsultaDeConceptos = new JLabel("Consulta de conceptos");
		lblConsultaDeConceptos.setBounds(238, 11, 109, 14);
		contentPane.add(lblConsultaDeConceptos);
		
		JLabel lblSeleccioneLosFiltros = new JLabel("Seleccione los filtros para poder realizar las consultas");
		lblSeleccioneLosFiltros.setBounds(160, 36, 276, 14);
		contentPane.add(lblSeleccioneLosFiltros);
		
		JLabel lblPeriodo = new JLabel("Periodo");
		lblPeriodo.setBounds(171, 80, 46, 14);
		contentPane.add(lblPeriodo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(260, 76, 129, 22);
		contentPane.add(comboBox);
		
		Panel panel = new Panel();
		panel.setBounds(32, 125, 509, 231);
		contentPane.add(panel);
		
		ScrollPane scrollPane = new ScrollPane();
		panel.add(scrollPane);
	}
}
