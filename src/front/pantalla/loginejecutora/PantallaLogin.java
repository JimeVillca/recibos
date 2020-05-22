package front.pantalla.loginejecutora;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import back.dtos.UsuarioDto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import front.complementos.Comprobador;
import front.pantalla.ejecutora.Fachada;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class PantallaLogin extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnIngresar;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaLogin frame = new PantallaLogin();
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
	public PantallaLogin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAccederAlSistema = new JLabel("ACCEDER AL SISTEMA");
		lblAccederAlSistema.setBounds(148, 11, 138, 14);
		contentPane.add(lblAccederAlSistema);

		JLabel lblIngreseSusCrendenciales = new JLabel("Ingrese Sus Crendenciales Usuario y Contrase\u00F1a");
		lblIngreseSusCrendenciales.setBounds(69, 36, 295, 14);
		contentPane.add(lblIngreseSusCrendenciales);

		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setBounds(81, 73, 52, 14);
		contentPane.add(lblUsuario);

		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A");
		lblContrasea.setBounds(54, 119, 79, 14);
		contentPane.add(lblContrasea);

		textField = new JTextField();
		textField.setBounds(155, 70, 138, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		btnIngresar = new JButton("INGRESAR");

		btnIngresar.setBounds(253, 170, 111, 23);
		contentPane.add(btnIngresar);

		passwordField = new JPasswordField();
		passwordField.setBounds(158, 116, 135, 20);
		contentPane.add(passwordField);
		
//		setLocationRelativeTo obliga a la pantalla habrirse en el centro de la pantalla
		setLocationRelativeTo(null);
		cargalistener();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnIngresar) {
			System.out.println("hola");
			validaIngreso();
		}
	}

	private void validaIngreso() {
		// TODO Auto-generated method stub
		Comprobador name = new Comprobador();
		if (!name.txtGenerico(textField, "Debe escribir un usuario", Comprobador.COMPROBAR_CADENA_STRING)
				&& !name.passwordIsEmpty(passwordField, "El pass no puede estar vacio")) {
			ingresar();
		}

	}

	private void ingresar() {
		// TODO Auto-generated method stub
		UsuarioDto usu = new UsuarioDto();
		usu.setUsuario(textField.getText());
		usu.setContrasenia(String.valueOf(passwordField.getPassword()));
		Fachada fac = new Fachada();
		if (fac.Validacion(usu) != null) {
		      System.out.println("Usuario Autorizado");
		      dispose();
		      
		      Menu men = new Menu(usu);
		      men.asignaUsuarioValido(usu);
//		      men.setVisible(true);
		      
		     
		} else {
		      System.out.println("Usuario incorrecto");
		      JOptionPane.showMessageDialog(null, "USUARIO O CONTRASE INCORRECTOS MACRI GATO", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void cargalistener() {
		// TODO Auto-generated method stub
		btnIngresar.addActionListener(this);
	}

}
