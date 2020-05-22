package front.pantalla.recibos;

import front.pantalla.ejecutora.Fachada;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Calendar;

import javax.sound.midi.Soundbank;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import back.dtos.LoteDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class ImportarConceptos extends JDialog implements ChangeListener {
	// public class ImportarConceptos extends JFrame {
	// public class Pantallas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JYearChooser yearChooser;
	private JMonthChooser monthChooser;
	private String ruta;

	private JSpinner spinner_1;
	private JComboBox<String> comboBox;
	// private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImportarConceptos frame = new ImportarConceptos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the Dialog.
	 */
	public ImportarConceptos() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblImportarConceptosDe = new JLabel("IMPORTAR CONCEPTOS DE RECIBOS");
		lblImportarConceptosDe.setBounds(132, 12, 180, 14);
		contentPane.add(lblImportarConceptosDe);

		JLabel lblParaImportarDatos = new JLabel("Para importar datos de conceptos seleccione mes y a\u00F1o ");
		lblParaImportarDatos.setBounds(88, 37, 269, 14);
		contentPane.add(lblParaImportarDatos);

		JLabel lblEstosDatosSon = new JLabel("Estos datos son equivalentes al periodo ");
		lblEstosDatosSon.setBounds(130, 62, 193, 14);
		contentPane.add(lblEstosDatosSon);

		JLabel lblPeriodo = new JLabel("PERIODO:");
		lblPeriodo.setBounds(88, 127, 59, 14);
		contentPane.add(lblPeriodo);

		JButton btnImportar = new JButton("IMPORTAR");
		btnImportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fachada fac = new Fachada();
				// LoteDTO lo=fac.importarArchivo();

				JFileChooser file = new JFileChooser();
				file.setFileFilter(new FileNameExtensionFilter("csv", "csv"));
				int s = file.showOpenDialog(null);
				file.showOpenDialog(file);
				file.getSelectedFile();
				if (s == JFileChooser.APPROVE_OPTION) {
					if (file.getSelectedFile() != null) {

						JOptionPane.showMessageDialog(null, "El archivo importado es  " + file.getSelectedFile(),
								"ARCHIVOS", JOptionPane.INFORMATION_MESSAGE);
						ruta = file.getSelectedFile().toString();
						System.out.println(ruta);
						importarArchivos(ruta);
					}
				} else {
					System.out.println("Tipo de archivo incorrecto");
				}

			}
		});
		btnImportar.setBounds(292, 170, 91, 23);
		contentPane.add(btnImportar);

		spinner_1 = new JSpinner();
		spinner_1.setBounds(292, 125, 65, 18);
		contentPane.add(spinner_1);

		comboBox = new JComboBox();
		comboBox.setBounds(174, 123, 91, 22);
		contentPane.add(comboBox);

		limitarfecha();
		cargarComboMes();
		cargaListeners();
		setModal(true);
		// setLocationRelativeTo obliga a la pantalla habrirse en el centro de
		// la pantalla
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void importarArchivos(String ruta) {
		/*
		 * Fachada fac= new Fachada(); //LoteDTO lo=fac.importarArchivo();
		 */
		Fachada fac = new Fachada();
		fac.importarArchivo(ruta);
	}

	private void cargaListeners() {
		// TODO Auto-generated method stub
		spinner_1.addChangeListener(this);
		// if(){}

	}

	private void cargarComboMes() {
		// TODO Auto-generated method stub
		System.out.println(String.valueOf(spinner_1.getValue()));
		Calendar cal = Calendar.getInstance();
		int moth = cal.get(Calendar.MONTH);
		System.out.println(moth);
		if (cal.get(Calendar.YEAR) == Integer.valueOf(spinner_1.getValue().toString()))
			;
		{
		}

		if (comboBox.getItemCount() > 0) {
			comboBox.removeAllItems();
		}

		String[] meses = { "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE",
				"OCTUBRE", "NOVIEMBRE", "DICIEMBRE" };
		if (cal.get(Calendar.YEAR) != Integer.valueOf(spinner_1.getValue().toString())) {

			for (int i = 0; i < meses.length; i++) {
				comboBox.addItem(meses[i]);
			}
		} else {
			for (int i = 0; i < cal.get(Calendar.MONTH); i++) {
				comboBox.addItem(meses[i]);
			}
		}

	}

	private void limitarfecha() {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int moth = cal.get(Calendar.MONTH);
		{
			String[] meses = { "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE",
					"OCTUBRE", "NOVIEMBRE", "DICIEMBRE" };
			for (int i = 0; i < cal.get(Calendar.MONTH); i++) {
				comboBox.addItem(meses[i]);
			}
			comboBox.setSelectedIndex(cal.get(Calendar.MONTH) - 1);
			spinner_1.setModel(new SpinnerNumberModel(year, 0, year, 1));
		}

	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		if (spinner_1 == arg0.getSource()) {
			System.out.println(spinner_1.getValue().toString());
			cargarComboMes();
		}
	}

}
