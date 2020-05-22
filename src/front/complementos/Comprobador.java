package front.complementos;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Comprobador implements ComprobadorImplements {
	/**
	 * selecciona el tipo de comprobacion que se realizara como tipo cadena numerica
	 */
	public static int COMPROBAR_CADENA_NUMERICA = 1;
	/**
	 * selecciona el tipo de comprobacion que se realizara como tipo cadena string
	 */
	public static int COMPROBAR_CADENA_STRING = 2;

	@Override
	public void txtVacio(JTextField text) {
		// TODO Auto-generated method stub
		if (text.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "El campo Nombre esta vacio", "ERROR", JOptionPane.ERROR_MESSAGE);

		} else {
		}
	}
	
	public void txtExitoUsuario(){
		//JOptionPane.showMessageDialog(null, "El campo Nombre esta vacio", "ERROR", JOptionPane.ERROR_MESSAGE);
		JOptionPane.showMessageDialog(null, "El usuario fue creado con exito","EXITO",JOptionPane.CLOSED_OPTION);
		
	}

	/**
	 * metodo generico para comprobartxt vacios Return false si no cuenta con una
	 * cadena cargada recibe un componente de tipo JTextField y el mensaje que se
	 * desea mostrar en el jdialog
	 *
	 */
	public boolean txtVacioMsg(JTextField text, String msg) {
		// TODO Auto-generated method stub
		if (text.getText().equals("")) {
			JOptionPane.showMessageDialog(null, msg, "ERROR", JOptionPane.ERROR_MESSAGE);
			text.requestFocus();
			return true;
		} else {
			return false;
		}
	}

	public boolean txtIsNumber(JTextField text, String msg) {
		// TODO Auto-generated method stub
		if (txtVacioMsg(text, msg)) {
			return false;
		}
		try {

			Integer numero = Integer.valueOf(text.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "El valor del campo debe ser numerico y entero", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			text.requestFocus();
			return false;
		}

		return true;
	}

	/**
	 * recibe un jtextfield El msg es el mensage a mostrar y el valor es el tipo de
	 * dato a analizar en el campo de texto este metodo debuelve true si el campo
	 * esta vacio
	 * 
	 */
	public boolean txtGenerico(JTextField text, String msg, int valor) {
		// TODO Auto-generated method stub
		switch (valor) {
		case 1:
			if (!txtIsNumber(text, msg)) {
				return false;
			}
			break;
		case 2:
			if (!txtVacioMsg(text, msg)) {
				return false;
			}

			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + valor);
		}
		return true;
	}

	@Override
	public boolean passwordIsEmpty(JPasswordField pass, String msg) {

		if (pass.getPassword().length == 0) {
			JOptionPane.showMessageDialog(null, msg, "ERROR", JOptionPane.ERROR_MESSAGE);
			pass.requestFocus();
			return true;

		}
		// TODO Auto-generated method stub

		return false;
	}

}
