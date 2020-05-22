package front.pantalla.recibos;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.TableRowSorter;

import back.dtos.ConceptoDTO;
import back.dtos.UsuarioDto;
import front.complementos.GeneraReporte;
import front.complementos.MyTableModel;
import front.pantalla.ejecutora.Fachada;
import front.pantalla.listados.VerDetalle;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ConsultaConcepto extends JDialog implements ActionListener, MouseListener, CaretListener {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private MyTableModel modelo;
	private TableRowSorter<MyTableModel> sorter;
	private Fachada fac;
	private List<ConceptoDTO> concepto;
	private JButton btnImprimir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaConcepto frame = new ConsultaConcepto();
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
	public ConsultaConcepto() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 657, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblConsultaDeConceptos = new JLabel("Consulta de conceptos");
		lblConsultaDeConceptos.setBounds(172, 11, 114, 14);
		contentPane.add(lblConsultaDeConceptos);

		JLabel lblConcepto = new JLabel("Concepto");
		lblConcepto.setBounds(32, 44, 46, 14);
		contentPane.add(lblConcepto);

		JPanel panel = new JPanel();
		panel.setBounds(10, 126, 597, 172);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblTipoConcepto = new JLabel("Tipo Concepto");
		lblTipoConcepto.setBounds(27, 97, 74, 14);
		contentPane.add(lblTipoConcepto);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 587, 156);
		panel.add(scrollPane);

		textField = new JTextField();
		textField.setBounds(123, 41, 196, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(123, 94, 97, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		table = new JTable();
		btnImprimir = new JButton("Imprimir");
		btnImprimir.setBounds(413, 40, 89, 23);
		contentPane.add(btnImprimir);
		cargatabla();

		cargaListeners();

		scrollPane.setViewportView(table);

		setModal(true);
//		setLocationRelativeTo obliga a la pantalla habrirse en el centro de la pantalla
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void cargaListeners() {
		// TODO Auto-generated method stub
//		no olvidar poner todos los escuchadores para los eventos a escuchar
//		ciertos elementon no escuchan action listener otros si
		textField.addCaretListener(this);
		textField.addMouseListener(this);
		textField_1.addMouseListener(this);
		textField_1.addCaretListener(this);
		table.addMouseListener(this);
		btnImprimir.addActionListener(this);
	}

	private void cargatabla() {
		// TODO Auto-generated method stub
//		creamos el modelo
		modelo = new MyTableModel();
//		le agregamos el nombre de las columnas
		modelo.addColums(new String[] { "Descripcion", "TipoConceptos", "Importe" });
		buscaConceptos();

//		Agregamos el modelo a la tabla
		table.setModel(modelo);
	}

	private void buscaConceptos() {
		// TODO Auto-generated method stub
		if (fac == null) {
			fac = new Fachada();
		}
		concepto = fac.selectConcepto();

		for (ConceptoDTO conceptoDto : concepto) {
			System.out.println(conceptoDto.toString() + " " + conceptoDto.getTipoConcepto());
			modelo.addRow(new Object[] { conceptoDto.getDescripcion(), conceptoDto.getTipoConcepto(),
					conceptoDto.getImporte() });
		}
		modelo.setCellEditing(false);
		sorter = new TableRowSorter<MyTableModel>(modelo);

		table.setRowSorter(sorter);

	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (textField == e.getSource()) {
			System.out.println("holaaaa");
//			este click lo hace para borrar el contenido
			borraTextos();
		}
		if (textField_1 == e.getSource()) {
			borraTextos();
		}

	}

	private void borraTextos() {
		// TODO Auto-generated method stub
		textField.setText("");
		textField_1.setText("");
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (table == e.getSource()) {
			System.out.println("click");
//			como obtener valores de la tabla
//			table.getValueAt le dice la quiero el valor de esta celda, table.getSelectedRow()indica la fila
//			y 0 la columna

			System.out.println("Descripcion  " + table.getValueAt(table.getSelectedRow(), 0) + " TipoConceptos "
					+ table.getValueAt(table.getSelectedRow(), 1));
			// probar con toString
			buscarConceptos(String.valueOf(table.getValueAt(table.getSelectedRow(), 2)));

		}
	}

	private void buscarConceptos(String string) {
		// TODO Auto-generated method stub
		ConceptoDTO concepto = new ConceptoDTO();

		/*
		 * UsuarioDto name = new UsuarioDto(); for (UsuarioDto usuarioDto : usuarios) {
		 * if(usuarioDto.getNumerodocumento().equals(string)) { name=usuarioDto;
		 */
//				verdetalle.recibirUsuario(usuarioDto);

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void caretUpdate(CaretEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (btnImprimir == arg0.getSource()) {
			generarPdf();
		}
	}

	private void generarPdf() {
		// TODO Auto-generated method stub
		GeneraReporte rep = new GeneraReporte();
		DateFormat formatoh = new SimpleDateFormat("HHmmss");
		java.util.Date hora = new java.util.Date();
//		La raiz del pdf sera la del proyecto
		rep.createPDF("Listado" + formatoh.format(hora).toString(), "Aqui pongo el titulo del documento");
//		Aqui pongo las columnas que voy crear
//		Armo los arrays y matrices que le voy a pasar a la tabla del documento
		LinkedList<String> columnas = new LinkedList<String>();

//	en este punto tomo el nombre de las columnas	
		for (int i = 0; i < table.getColumnCount(); i++) {
			columnas.add(table.getColumnName(i));
		}

//		Aca grego los valores seteados de las filas
		LinkedList<LinkedList<String>> filas = new LinkedList<LinkedList<String>>();
		for (int f = 0; f < table.getRowCount(); f++) {
			LinkedList<String> celdas = new LinkedList<String>();
			for (int c = 0; c < table.getColumnCount(); c++) {

				celdas.add(table.getValueAt(f, c).toString());

			}
			filas.add(celdas);
		}

		Vector<Object> fila = new Vector<Object>();
//		lo que sigue permite darle el tamanio a cada una de las columnas
		float[] tamanio = { 1.6f, 3f, 2f };
		Object[][] name = { { "Aqui va una matriz para armar un encabezado", "Podrias poner la hora etc" } };

		int cont = 0;

		for (int f = 1; f < name.length; f++) {
			for (int c = 0; c < name[f].length; c++) {
				name[f][c] = fila.get(cont);
				cont++;
			}
		}
//		en esta seccion se agregan los elementos creados al documento
		rep.setEncabezado("Aqui pongo encabezado", name, 0);

		rep.setTabla(columnas, filas, tamanio, -1);
		
		
		rep.setPie("Costo Produc", "Este es el pie", 1);
//		se ordena imprimir
//		todo tipo de formateo del documento personalizado deves hacerlo en la clase genera reporte
		if (!rep.print()) {
			JOptionPane.showMessageDialog(null, "No se pudo realizar", "Error en impresi�n", 0);
		} else {
			JOptionPane.showMessageDialog(null, "Operaci�n satisfactoria ", "Impresi�n realizada", 2);

		}
	}
}