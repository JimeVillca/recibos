package front.pantalla.altas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RegistrarFirma extends JFrame {

	private JPanel contentPane;
	private JTextField tusuario;
	private JTextField tcodigo;
	private JTextField trepcodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarFirma frame = new RegistrarFirma();
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
	public RegistrarFirma() {
		setTitle("hola");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(279, 11, 46, 14);
		contentPane.add(lblUsuario);
		
		tusuario = new JTextField();
		tusuario.setBounds(335, 8, 86, 20);
		contentPane.add(tusuario);
		tusuario.setColumns(10);
		
		JLabel lblRegistrarFirma = new JLabel("Registrar firma");
		lblRegistrarFirma.setBounds(153, 39, 86, 14);
		contentPane.add(lblRegistrarFirma);
		
		JLabel lblIngreseCodigoEl = new JLabel("Ingrese codigo, el mismo sera tomado como firma");
		lblIngreseCodigoEl.setBounds(64, 64, 242, 14);
		contentPane.add(lblIngreseCodigoEl);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(109, 100, 46, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblRepitaElCodigo = new JLabel("Repita el codigo");
		lblRepitaElCodigo.setBounds(67, 146, 76, 14);
		contentPane.add(lblRepitaElCodigo);
		
		tcodigo = new JTextField();
		tcodigo.setBounds(170, 97, 114, 20);
		contentPane.add(tcodigo);
		tcodigo.setColumns(10);
		
		trepcodigo = new JTextField();
		trepcodigo.setBounds(170, 143, 114, 20);
		contentPane.add(trepcodigo);
		trepcodigo.setColumns(10);
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setBounds(248, 199, 91, 23);
		contentPane.add(btnRegistrar);
		registrarfirma();
		
	}

	private void registrarfirma() {
		// TODO Auto-generated method stub
		if(tcodigo.equals(trepcodigo)){
			
			//		nombre.setText(usuarioDto.getNombre());

		}
	}

}
