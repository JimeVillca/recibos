package front.pantalla.recibos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JSpinner;
import javax.swing.JButton;

public class GenerarRecibos  extends JDialog implements ChangeListener {

	private JPanel contentPane;
	private final JPanel contentPanel = new JPanel();
	private JYearChooser yearChooser;
	private JMonthChooser monthChooser;

	private JSpinner spinner_1;
	private JComboBox<String> comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerarRecibos frame = new GenerarRecibos();
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
	public GenerarRecibos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGenerarRecibos = new JLabel("Generar recibos");
		lblGenerarRecibos.setBounds(196, 11, 82, 14);
		contentPane.add(lblGenerarRecibos);
		
		JLabel lblSeleccionaElPeriodo = new JLabel("Selecciona el periodo para el cual se desea generar el recibo.");
		lblSeleccionaElPeriodo.setBounds(60, 40, 339, 14);
		contentPane.add(lblSeleccionaElPeriodo);
		
		JComboBox<String> comboBox = new JComboBox();
		comboBox.setBounds(214, 73, 98, 22);
		contentPane.add(comboBox);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(322, 75, 51, 18);
		contentPane.add(spinner_1);
		
		JLabel lblPeriodo = new JLabel("PERIODO:");
		lblPeriodo.setBounds(60, 77, 98, 14);
		contentPane.add(lblPeriodo);
		
		JButton btnGenerar = new JButton("GENERAR");
		btnGenerar.setBounds(282, 122, 91, 23);
		contentPane.add(btnGenerar);
		limitarfecha();
		cargarComboMes();
		cargaListeners();
	}


private void cargaListeners() {
	// TODO Auto-generated method stub
	spinner_1.addChangeListener((ChangeListener) this);
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

public void stateChanged(ChangeEvent arg0) {
	// TODO Auto-generated method stub
	if (spinner_1 == arg0.getSource()) {
		System.out.println(spinner_1.getValue().toString());
		cargarComboMes();
		}

	}
}

