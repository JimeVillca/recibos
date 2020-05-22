package front.pantalla.loginejecutora;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import back.dtos.UsuarioDto;
import front.pantalla.altas.AltaUsuario;
import front.pantalla.ejecutora.Fachada;
import front.pantalla.listados.ConsultaUsuario;
import front.pantalla.recibos.ConsultaConcepto;
import front.pantalla.recibos.GenerarRecibos;
//import front.pantalla.altas.RegistrarFirma;
import front.pantalla.recibos.ImportarConceptos;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class Menu extends JDialog implements ActionListener {

	private JPanel contentPane;
	private JMenuItem mntmAltaUsuario;
	private JMenuItem mntmConsultaDeUsuario;
	private JMenuItem mntmRegistrarFirma;
	private JMenuItem mntmGenerarRecibos;
	private JMenuItem mntmImportarDatosRecibos;
	private JMenuItem mntmConsultaRecibos;
	private JMenuItem mntmConsultaConceptosRecibos;
	private UsuarioDto usu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu(null);
					// frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Fachada fac = new Fachada();

	public Menu(UsuarioDto usu2) {
		this.usu = usu2;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnUsuarios = new JMenu("USUARIOS");
		menuBar.add(mnUsuarios);

		mntmAltaUsuario = new JMenuItem("CREAR USUARIO");
		mnUsuarios.add(mntmAltaUsuario);

		mntmConsultaDeUsuario = new JMenuItem("CONSULTA DE USUARIO");
		mnUsuarios.add(mntmConsultaDeUsuario);

		JMenu mnFirma = new JMenu("FIRMA");
		menuBar.add(mnFirma);

		mntmRegistrarFirma = new JMenuItem("REGISTRAR FIRMA");
		mntmRegistrarFirma.setEnabled(true);
		// mntmRegistrarFirma.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent arg0) {
		//// RegistrarFirma reco= new RegistrarFirma();
		//// reco.setVisible(true);
		// }
		// });
		mnFirma.add(mntmRegistrarFirma);

		JMenu mnRecibos = new JMenu("RECIBOS");
		menuBar.add(mnRecibos);

		mntmGenerarRecibos = new JMenuItem("GENERAR RECIBOS");
		mnRecibos.add(mntmGenerarRecibos);

		mntmImportarDatosRecibos = new JMenuItem("IMPORTAR DATOS RECIBOS");
		mnRecibos.add(mntmImportarDatosRecibos);
		
		mntmConsultaConceptosRecibos = new JMenuItem("CONSULTA CONCEPTOS RECIBOS");
		mnRecibos.add(mntmConsultaConceptosRecibos);
	

		mntmConsultaRecibos = new JMenuItem("CONSULTA RECIBOS");
		mnRecibos.add(mntmConsultaRecibos);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		cargaListeners();
		restriccionesUsuario();
		contentPane.setLayout(null);

		// El setModal lo que hace es que la pantalla este por encima de otra y
		// la anterior
		// no sea accesible no mas si se cierra esta
		setModal(true);
		// setLocationRelativeTo obliga a la pantalla habrirse en el centro de
		// la pantalla
		setLocationRelativeTo(null);
		validaroles();
		setVisible(true);

	}

	private void restriccionesUsuario() {

	}

	private void cargaListeners() {
		// este metodose se encarga de inicializar todotipo de listener
		// los listener son los que activan los eventos que disparan las
		// acciones requeridas por el sistema
		mntmAltaUsuario.addActionListener(this);
		mntmConsultaDeUsuario.addActionListener(this);
		mntmConsultaRecibos.addActionListener(this);
		mntmGenerarRecibos.addActionListener(this);
		mntmImportarDatosRecibos.addActionListener(this);
		mntmConsultaConceptosRecibos.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		/*
		 * ConsultaUsuario consulta = new ConsultaUsuario();
		 * consulta.setVisible(true);
		 */

		// este metodo es obligatorio para escuchar los eventosde tipo click
		// cada tipo de evento a escuchar requiere de su interfaz la cual hay
		// que importar
		// en este caso la interfaza requerida es actionListener, pero tambien
		// puede se
		// Keylistener para escuchar teclas de teclado
		// con este metodo agrupamos todosd los eventos del mismo tipo en uno
		// solo
		// dando de esta manera un orden a nuestro codigo ; en vez de crear un
		// metodo por
		// cada objeto que requiera un evento
		if (mntmAltaUsuario == e.getSource()) {
			cargaAltaUsuario();
		}
		if (mntmConsultaDeUsuario == e.getSource()) {
			consultaUsuario();
		}
		if (mntmImportarDatosRecibos == e.getSource()) {
			importarConceptos();
		}
		if (mntmGenerarRecibos == e.getSource()) {
			// generarecibos();
		}
		if(mntmConsultaConceptosRecibos == e.getSource()){
			consultaConceptoRecibo();
		}
	}

	private void consultaConceptoRecibo() {
		// TODO Auto-generated method stub
		
		ConsultaConcepto consultaConcept = new ConsultaConcepto();
		consultaConcept.setVisible(true);
	}

	private void consultaUsuario() {
		// TODO Auto-generated method stub
		ConsultaUsuario consulta = new ConsultaUsuario();
		consulta.setVisible(true);

	}

	private void cargaAltaUsuario() {
		// TODO Auto-generated method stub
		AltaUsuario alta = new AltaUsuario();
		// el setvicible es conveniente activarlo en la propia pantalla, por una
		// cuestion d ecomportamiento
		// alta.setVisible(true);
		// this.dispose();
	}

	public void importarConceptos() {
		ImportarConceptos importar = new ImportarConceptos();
		importar.setVisible(true);
	}

	public void generarRecibos() {
		GenerarRecibos generarecibos = new GenerarRecibos();
		generarecibos.setVisible(true);
	}

	public void asignaUsuarioValido(UsuarioDto usu) {
		this.usu = usu;

	}

	public void validaroles() {

		if (usu.getIdrol() == 22) {
			// consulta
			// mntmRegistrarFirma.setEnabled(fac.RegistricionesUsuario(usu));
			// mntmAltaUsuario.setText("HOLA");
			mntmAltaUsuario.setEnabled(false);
			mntmConsultaDeUsuario.setEnabled(false);
			mntmRegistrarFirma.setEnabled(false);
			mntmGenerarRecibos.setEnabled(false);
			mntmImportarDatosRecibos.setEnabled(false);
			mntmConsultaRecibos.setVisible(true);
			repaint();
		}

	}
}
