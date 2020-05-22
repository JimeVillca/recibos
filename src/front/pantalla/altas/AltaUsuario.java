package front.pantalla.altas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import back.dtos.RolDTO;
import back.dtos.TipoDocumentoDTO;
import back.dtos.UsuarioDto;
import front.complementos.Comprobador;
import front.pantalla.ejecutora.Fachada;
import front.pantalla.loginejecutora.Menu;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;

public class AltaUsuario extends JDialog implements ActionListener {

	private JPanel contentPane;
	private JTextField tNombre;
	private JTextField tApellido;
	private JTextField tNumDoc;
	private JTextField tEmail;
	private JTextField tContrasena;
	private JTextField tUsuario;
	private JTextField tRepContrasena;
	private Fachada fac;
	private List<TipoDocumentoDTO> tip;
	private List<RolDTO> top;
	private JComboBox comboTipoDoc;
	private JComboBox comboRol;
	private JButton btnGuardar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaUsuario frame = new AltaUsuario();
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
	public AltaUsuario() {
		fac = new Fachada();
		tip = fac.SelectTipoDoc();
		top = fac.SelectRol();

		cargaComboRol();
		cargaComboTipoDocumento();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 655, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAltaDeUsuario = new JLabel("Alta de usuario");
		lblAltaDeUsuario.setBounds(259, 11, 83, 14);
		contentPane.add(lblAltaDeUsuario);

		JSeparator separator = new JSeparator();
		separator.setBounds(150, 36, 316, 2);
		contentPane.add(separator);

		JLabel lblCompleteElFormulario = new JLabel("Complete el formulario para crear y guardar al nuevo USUARIO");
		lblCompleteElFormulario.setBounds(139, 49, 350, 14);
		contentPane.add(lblCompleteElFormulario);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(100, 74, 46, 14);
		contentPane.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(409, 74, 46, 14);
		contentPane.add(lblApellido);

		JLabel lblTipoDeDocumento = new JLabel("Tipo de documento");
		lblTipoDeDocumento.setBounds(35, 115, 111, 14);
		contentPane.add(lblTipoDeDocumento);

		JLabel lblNumeroDocumento = new JLabel("Numero documento");
		lblNumeroDocumento.setBounds(345, 115, 121, 14);
		contentPane.add(lblNumeroDocumento);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(100, 295, 46, 14);
		contentPane.add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(385, 295, 70, 14);
		contentPane.add(lblContrasea);

		JLabel lblCorreoElectronico = new JLabel("Correo electronico");
		lblCorreoElectronico.setBounds(45, 164, 101, 14);
		contentPane.add(lblCorreoElectronico);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(150, 201, 316, 2);
		contentPane.add(separator_1);

		JLabel lblSeleccioneElTipo = new JLabel("Seleccione el tipo de rol que el usuario tendra");
		lblSeleccioneElTipo.setBounds(164, 214, 226, 14);
		contentPane.add(lblSeleccioneElTipo);

		JLabel lblRol = new JLabel("Rol");
		lblRol.setBounds(127, 245, 19, 14);
		contentPane.add(lblRol);

		JLabel lblRepitaContrasea = new JLabel("Repita Contrase\u00F1a");
		lblRepitaContrasea.setBounds(35, 340, 111, 14);
		contentPane.add(lblRepitaContrasea);

		tNombre = new JTextField();
		tNombre.setBounds(165, 69, 152, 24);
		contentPane.add(tNombre);
		tNombre.setColumns(10);

//		comboBox = new JComboBox();
		comboTipoDoc.setBounds(166, 109, 151, 26);
		contentPane.add(comboTipoDoc);

		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(491, 398, 101, 23);
		contentPane.add(btnGuardar);

		tApellido = new JTextField();
		tApellido.setColumns(10);
		tApellido.setBounds(465, 69, 152, 24);
		contentPane.add(tApellido);

		tNumDoc = new JTextField();
		tNumDoc.setColumns(10);
		tNumDoc.setBounds(465, 108, 152, 24);
		contentPane.add(tNumDoc);

		tEmail = new JTextField();
		tEmail.setColumns(10);
		tEmail.setBounds(164, 159, 240, 24);
		contentPane.add(tEmail);

		tContrasena = new JTextField();
		tContrasena.setColumns(10);
		tContrasena.setBounds(465, 290, 152, 24);
		contentPane.add(tContrasena);

//		comboBox_1 = new JComboBox();
		comboRol.setBounds(174, 239, 151, 26);
		contentPane.add(comboRol);

		tUsuario = new JTextField();
		tUsuario.setColumns(10);
		tUsuario.setBounds(174, 288, 152, 24);
		contentPane.add(tUsuario);

		tRepContrasena = new JTextField();
		tRepContrasena.setColumns(10);
		tRepContrasena.setBounds(174, 333, 152, 24);
		contentPane.add(tRepContrasena);
		cargaListeners();
//		El setModal lo que hace es que la pantalla este por encima de otra y la anterior
//		no sea accesible no mas si se cierra esta
		setModal(true);
//		setLocationRelativeTo obliga a la pantalla habrirse en el centro de la pantalla
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void cargaListeners() {
		// TODO Auto-generated method stub
		btnGuardar.addActionListener(this);

	}

	private String[] cargaComboRol() {
		// TODO Auto-generated method stub

		comboRol = new JComboBox();
		for (RolDTO rolDTO : top) {
			comboRol.addItem(rolDTO.getDescripcion());
		}
		String[] arr = new String[top.size()];
		for (int i = 0; i < top.size(); i++) {
			arr[i] = top.get(i).getDescripcion();
		}
		return arr;

	}

	private void cargaComboTipoDocumento() {
		// TODO Auto-generated method stub
		comboTipoDoc = new JComboBox();
		for (TipoDocumentoDTO tipoDocumentoDTO : tip) {
			comboTipoDoc.addItem(tipoDocumentoDTO.getAbreviacion());
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnGuardar) {
			altaUsuario();
		}

	}

	private void altaUsuario() {
		// TODO Auto-generated method stub
//		if (textField.getText().equals("")) {
//			JOptionPane.showMessageDialog(null, "El campo Nombre esta vacio", "ERROR", JOptionPane.ERROR_MESSAGE);
//		} else {
//		}
		Comprobador name = new Comprobador();
		if (!name.txtVacioMsg(tNombre, "El campo Nombre esta vacio")
				&& !name.txtVacioMsg(tApellido, "El campo apellido no puede estar vacio")
				&& name.txtGenerico(tNumDoc, "El campo numero documento no puede estar vacio",
						Comprobador.COMPROBAR_CADENA_NUMERICA)
				&& !name.txtVacioMsg(tUsuario, "El campo usuario no puede estar vacio")
				&& !name.txtVacioMsg(tContrasena, "El campo no puede estar vacio ")
				&& !name.txtVacioMsg(tEmail, "El campo email no puede estar vacio")) {

			System.out.println("entro");
			UsuarioDto usu = new UsuarioDto();
			usu.setNombre(tNombre.getText());
			usu.setApellido(tApellido.getText());
			usu.setNumerodocumento(tNumDoc.getText());
			usu.setUsuario(tUsuario.getText());
			usu.setContrasenia(tContrasena.getText());
			usu.setCorreoElectrinico(tEmail.getText());
			if (fac.AltaUsuario(usu)) {
				System.out.println("Se ha creado un nuevo usuario");
				//JOptionPane.showConfirmDialog("EXITO", "El usuario fue creado con exito","EXITO",JOptionPane.CLOSED_OPTION);
				
				name.txtExitoUsuario();
				//Menu men = new Menu();
				//men.setVisible(true);
				this.dispose();
				
			}
		}

//		if (textField_1.getText().equals("")) {
//			JOptionPane.showMessageDialog(null, "El campo Apellido esta vacio", "ERROR", JOptionPane.ERROR_MESSAGE);
//		} else {
//			
//
//		}
	}
}
