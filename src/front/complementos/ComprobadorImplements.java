package front.complementos;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public interface ComprobadorImplements {
	public void txtVacio(JTextField text);

	public boolean txtVacioMsg(JTextField text, String msg);

	
	public boolean txtGenerico(JTextField text, String msg, int valor);

	
	public boolean passwordIsEmpty(JPasswordField pass,String msg );
	
}
