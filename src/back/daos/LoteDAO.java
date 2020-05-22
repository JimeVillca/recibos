package back.daos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.sound.midi.Soundbank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import front.pantalla.ejecutora.ConnectionPool;

public class LoteDAO {

	private static final String QOUTE = "\"";
	private static final String QUOTE = "\"";

	public void importarCVS(String ruta) {

		List<List> list = cargaLista(ruta);
		insertarDatos(list);
	}

	public void insertarDatos(List<List> list) {
		Connection con = null;
		PreparedStatement pts = null;
		ResultSet res = null;
		Statement stm = null;
		int i = 0;
		String sqlsearch = "";
		for (int m = 1; m < list.size(); m++) {
			con = ConnectionPool.getConnection();
//			esto que te comente es porque la columna concepto no existe y no tngo niguna otra que sea varchar
//			sqlsearch = "INSERT INTO `concepto` ( `fechaAlta`, `concepto`, `tipoConcepto`, `importe`) VALUES ( CURRENT_DATE(), ? , ?, ?);";
			sqlsearch = "INSERT INTO `concepto` ( `fechaAlta`, `concepto`, `tipoConcepto`, `importe`) VALUES ( CURRENT_DATE(), ? , ?, ?);";

			try {
				boolean esNumero = true;
				con.setAutoCommit(false);
				pts = con.prepareStatement(sqlsearch);
				System.out.println(String.valueOf(list.get(m).get(3)));
				pts.setString(1, String.valueOf(list.get(m).get(2)));
				pts.setString(2, String.valueOf(list.get(m).get(3)));
				// pts.setString(2, String.valueOf(list.get(m).get(3)));
				if (isFloat(list.get(m).get(4).toString())) {

					pts.setFloat(3, Float.valueOf(String.valueOf(list.get(m).get(4))));
					// pts.setInt(3, 30);
					// pts.setInt(4, Integer.valueOf(usa.getNumerodocumento()));
				} else {
					esNumero = false;
					System.out.println("El tipo de dato no es numerico no se inserta por el tipo de columna");
				}
				if (esNumero) {
					if (pts.executeUpdate() != 1) {
						System.out.print("PaSO");
						pts.close();
					}
					con.commit();
				
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	private boolean isFloat(String string) {
		try {
			float f = Float.valueOf(string);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	private List<List> cargaLista(String ruta) {
		BufferedReader br = null;
		List<List> archivo = new LinkedList<List>();
		try {
			br = new BufferedReader(new FileReader(ruta));
			String line = br.readLine();
	
			int i = 0;
	
			while (null != line) {
				String[] fields = line.split(",");
				List<String> lista = meter(fields);
				archivo.add(lista);
				System.out.println(lista.toString());
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return archivo;
	}

	private List<String> meter(String[] fields) {
		List<String> l = new LinkedList<String>();
		for (String string : fields) {
			l.add(string);
		}
		return l;
	}

}
/**/
