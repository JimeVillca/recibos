/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package front.pantalla.ejecutora;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author Alumno
 */
public class ConnectionPool {
      
      public static Connection cnx=null;
      
      public static Connection getConnection() {
	    try {
		  if (cnx == null) {
			Runtime.getRuntime().addShutdownHook(new MishdwnHook());
			Class.forName("com.mysql.jdbc.Driver");
//			ResourceBundle rb = ResourceBundle.getBundle("jdbc");
			String bd ="recibos";
			String host = "127.0.0.1:3306";			
			String password = "";
			String user = "root";
			String server = "jdbc:mysql://" + host + "/" + bd;

			cnx = DriverManager.getConnection(server, user, password);

		  }

	    } catch (ClassNotFoundException e) {
		  System.out.println("No se pudo cargar el driver");

	    } catch (SQLException e) {
		  System.out.println("no se pudo cargar SingletonBundle.jdbc");
	    }
	    return cnx;
      }

      static class MishdwnHook extends Thread {

	    @Override
	    public void run() {
		  try {
			Connection cnx = ConnectionPool.getConnection();
			cnx.close();
		  } catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		  }
	    }
      }
}