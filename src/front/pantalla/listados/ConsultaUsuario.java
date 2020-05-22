package front.pantalla.listados;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import back.dtos.UsuarioDto;
import front.complementos.MyTableModel;
import front.pantalla.ejecutora.Fachada;

public class ConsultaUsuario extends JDialog implements ActionListener, MouseListener, CaretListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnBuscar;
	private JTable table;
	private MyTableModel modelo;
	private TableRowSorter<MyTableModel> sorter;
	private Fachada fac;
	private List<UsuarioDto> usuarios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaUsuario frame = new ConsultaUsuario();
//					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConsultaUsuario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 625, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblConsultaDeUsuarios = new JLabel("Consulta de usuarios");
		lblConsultaDeUsuarios.setBounds(242, 23, 119, 16);
		contentPane.add(lblConsultaDeUsuarios);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(41, 70, 55, 16);
		contentPane.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(395, 70, 55, 16);
		contentPane.add(lblApellido);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(41, 125, 55, 16);
		contentPane.add(lblUsuario);

		JLabel lblNumeroDeDocumento = new JLabel("Numero de documento");
		lblNumeroDeDocumento.setBounds(328, 125, 133, 16);
		contentPane.add(lblNumeroDeDocumento);

		textField = new JTextField();
		textField.setToolTipText("click");
		textField.setBounds(117, 67, 133, 22);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(117, 122, 133, 22);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(462, 67, 133, 22);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setBounds(462, 119, 133, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		btnBuscar = new JButton("BUSCAR");

		btnBuscar.setBounds(505, 164, 90, 28);
		contentPane.add(btnBuscar);

		JPanel panel = new JPanel();
		panel.setBounds(10, 194, 540, 269);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 11, 531, 247);
		panel.add(scrollPane);
//		importante no cargar nada en la tabla
		table = new JTable();
		cargatabla();
//		ojo donde se cargan los listener puede que no se carguen
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
	textField_2.addMouseListener(this);
	textField_2.addCaretListener(this);
	table.addMouseListener(this);
	}

	private void cargatabla() {
		// TODO Auto-generated method stub
//		creamos el modelo
		modelo = new MyTableModel();
//		le agregamos el nombre de las columnas
		modelo.addColums(new String[] { "nombre", "apellido", "numeroDocumento","usuario","email"});
		buscaUsuarios();

//		Agregamos el modelo a la tabla
		table.setModel(modelo);
	}

	private void buscaUsuarios() {
		// TODO Auto-generated method stub
		if (fac == null) {
			fac = new Fachada();
		}
		usuarios = fac.selectUsuario();
		for (UsuarioDto usuarioDto : usuarios) {
			System.out.println(usuarioDto.toString() + "  " + usuarioDto.getApellido());
//			aui se carga el modelo linea a line a de  la tabla
			modelo.addRow(new Object[] {usuarioDto.getNombre(),usuarioDto.getApellido(),usuarioDto.getNumerodocumento(),usuarioDto.getUsuario(),usuarioDto.getCorreoElectrinico()});
		}
//		aqui evitamos que se puedan editar los valores de las celdas 
		modelo.setCellEditing(false);
//		aca le  pasamos el modelo al sorter para que pueda indexar y filtrar
		sorter=new TableRowSorter<MyTableModel>(modelo);
//		luego le pasamos el sorter a la tabla para que adquiera los atributos de indexado 
//		y busqueda
		table.setRowSorter(sorter);
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		eliminarUsuario();
		
	}

	private void eliminarUsuario() {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (textField == e.getSource()) {
			System.out.println("holaaaa");
//			este click lo hace para borrar el contenido
			borraTextos();
		}
		if (textField_2==e.getSource()) {
			borraTextos();
		}
	}

	private void borraTextos() {
		// TODO Auto-generated method stub
		textField.setText("");
		textField_2.setText("");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (table==e.getSource()) {
			System.out.println("click");
//			como obtener valores de la tabla
//			table.getValueAt le dice la quiero el valor de esta celda, table.getSelectedRow()indica la fila
//			y 0 la columna
		
			
			System.out.println("nombre  "+table.getValueAt(table.getSelectedRow(), 0)+" apellido "+table.getValueAt(table.getSelectedRow(),1) );
			//probar con toString
			buscarUsuario(String.valueOf(table.getValueAt(table.getSelectedRow(),2)));
			
		}
	}

	
	
	private void buscarUsuario(String string) {
		// TODO Auto-generated method stub
		UsuarioDto name = new UsuarioDto();
		for (UsuarioDto usuarioDto : usuarios) {
			if(usuarioDto.getNumerodocumento().equals(string)) {
			name=usuarioDto;
//				verdetalle.recibirUsuario(usuarioDto);
				
			}
		
		}
		VerDetalle verdetalle = new VerDetalle (name);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void caretUpdate(CaretEvent e) {
		// TODO Auto-generated method stub
//		este metodo detecta los cambios de caracteres en cada pulsacion de teclado
		if (e.getSource()==textField) {
//			aqui lo que hago es que filtrecaracter por caracter en la tabla
//			a el objeto sorter que es el que filtra nuestro modelo le paso la funcion por la
//			cual quiero filtrar , se puede hacer de diferntes maneras, a traves de paramtros 
//			desde hasta por ej. en este caso le paso el text del cual voy a obtener el filtro
//			y la columna a partir de la cual voy a filtrar
			sorter.setRowFilter(RowFilter.regexFilter(textField.getText(), 0));
		}
		if (e.getSource()==textField_2) {
//			aqui lo que hago es que filtrecaracter por caracter en la tabla
//			a el objeto sorter que es el que filtra nuestro modelo le paso la funcion por la
//			cual quiero filtrar , se puede hacer de diferntes maneras, a traves de paramtros 
//			desde hasta por ej. en este caso le paso el text del cual voy a obtener el filtro
//			y la columna a partir de la cual voy a filtrar
			sorter.setRowFilter(RowFilter.regexFilter(textField_2.getText(), 1));
		}
	}
}
