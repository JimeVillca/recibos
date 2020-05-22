package front.pantalla.listados;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import back.dtos.UsuarioDto;
import front.pantalla.ejecutora.Fachada;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.security.auth.Refreshable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerDetalle extends JDialog implements ActionListener {
	
	private JPanel contentPane;
	private UsuarioDto usuarioDto;
	private JTextField nombre;
	private JTextField usuario;
	private JTextField apellido;
	private JTextField email;
	private JTextField fechaAlta;
	private JTextField nroDocumento;
	@SuppressWarnings("rawtypes")
	private JComboBox comboTipoDoc;
	@SuppressWarnings("rawtypes")
	private JComboBox comboRol;
	Fachada fac;
	private JButton btnEliminarUsuario;
	private JButton btnEditarUsuario;
	 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					VerDetalle frame = new VerDetalle();
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
	public VerDetalle(UsuarioDto usu) {
		this.usuarioDto=usu;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVerDetalleDe = new JLabel("Ver detalle de USUARIO");
		lblVerDetalleDe.setBounds(207, 11, 140, 14);
		contentPane.add(lblVerDetalleDe);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(162, 36, 256, 3);
		contentPane.add(separator);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(56, 66, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(355, 66, 46, 14);
		contentPane.add(lblApellido);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(56, 120, 46, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setBounds(355, 120, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblTipoDocumento = new JLabel("Tipo Documento");
		lblTipoDocumento.setBounds(56, 181, 98, 14);
		contentPane.add(lblTipoDocumento);
		
		JLabel lblNroDocumento = new JLabel("Nro documento");
		lblNroDocumento.setBounds(355, 181, 95, 14);
		contentPane.add(lblNroDocumento);
		
		JLabel lblRol = new JLabel("Rol");
		lblRol.setBounds(56, 246, 46, 14);
		contentPane.add(lblRol);
		
		JLabel lblFechaAlta = new JLabel("Fecha Alta");
		lblFechaAlta.setBounds(355, 246, 82, 14);
		contentPane.add(lblFechaAlta);
		
		btnEliminarUsuario = new JButton("Eliminar USUARIO");
		
		btnEliminarUsuario.setBounds(136, 318, 145, 23);
		contentPane.add(btnEliminarUsuario);
		fac=new Fachada();
		btnEditarUsuario = new JButton("Editar USUARIO");
		
		btnEditarUsuario.setBounds(405, 318, 140, 23);
		contentPane.add(btnEditarUsuario);
		
		nombre = new JTextField();
		nombre.setBounds(162, 63, 130, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		usuario = new JTextField();
		usuario.setBounds(162, 117, 130, 20);
		contentPane.add(usuario);
		usuario.setColumns(10);
		
		apellido = new JTextField();
		apellido.setColumns(10);
		apellido.setBounds(464, 63, 130, 20);
		contentPane.add(apellido);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(464, 117, 130, 20);
		contentPane.add(email);
		
		fechaAlta = new JTextField();
		fechaAlta.setColumns(10);
		fechaAlta.setBounds(464, 243, 130, 20);
		contentPane.add(fechaAlta);
		
		nroDocumento = new JTextField();
		nroDocumento.setEditable(false);
		nroDocumento.setColumns(10);
		nroDocumento.setBounds(464, 178, 130, 20);
		contentPane.add(nroDocumento);
		
		comboTipoDoc = new JComboBox();
		comboTipoDoc.setBounds(162, 177, 130, 22);
		contentPane.add(comboTipoDoc);
		
		comboRol = new JComboBox();
		comboRol.setBounds(162, 242, 130, 22);
		contentPane.add(comboRol);
		escuchador();
		setModal(true);
//		setLocationRelativeTo obliga a la pantalla habrirse en el centro de la pantalla
		setLocationRelativeTo(null);
		asignarvalores();
		setVisible(true);
				
	}
	private void escuchador() {
		// TODO Auto-generated method stub
		btnEliminarUsuario.addActionListener(this);
	}

	private void eliminarUsuario() {
		// TODO Auto-generated method stub
		
		fac.EliminarUsuario(usuarioDto);
		
		
	/*	usuarios = fac.selectUsuario();
		for (UsuarioDto usuarioDto : usuarios) {
			System.out.println(usuarioDto.toString() + "  " + usuarioDto.getApellido());
//			aui se carga el modelo linea a line a de  la tabla
			modelo.addRow(new Object[] {usuarioDto.getNombre(),usuarioDto.getApellido(),usuarioDto.getNumerodocumento(),usuarioDto.getUsuario(),usuarioDto.getCorreoElectrinico()});
		}
		 * */
		
	}

	private void asignarvalores() {
		nombre.setText(usuarioDto.getNombre());
		apellido.setText(usuarioDto.getApellido());
		nroDocumento.setText(usuarioDto.getNumerodocumento());
		usuario.setText(usuarioDto.getNombre());
		email.setText(usuarioDto.getCorreoElectrinico());
		//fechaAlta.setCaret(usuarioDto.getFechaAlta());
		repaint();
	}

	public void recibirUsuario(UsuarioDto usuarioDto) {
		// TODO Auto-generated method stub
	

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (btnEliminarUsuario==arg0.getSource()) {
			eliminarUsuario();
		}
	}
	
}
