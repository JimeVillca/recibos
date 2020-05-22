/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package back.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import front.pantalla.ejecutora.ConnectionPool;

import back.dtos.UsuarioDto;
import java.util.LinkedList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Alumno
 */
public class UsuarioDAO {
	public UsuarioDto loguin(UsuarioDto u) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet res = null;
		Statement stm = null;
		int i = 0;
		String sqlsearch = "";

		try {
			con = ConnectionPool.getConnection();
			// sqlsearch ="select count(*) from usuarios where nombre ="
			// +u.getNombre()+"
			// and Contrasenia "+u.getContrasenia()+" ;";
			//-----------------------------------------------------
			sqlsearch="select rol.idRol   "
					+ "from usuario , rol "
					+ "where usuario.user ='"+u.getUsuario()+"'"
					+ "and usuario.contrasena ='"+u.getContrasenia()+"'"
					+ "and usuario.idRol = rol.idRol";
			/*
			 * SELECT rol.idrol from usuario, rol WHERE 
			 * usuario.usuario= 'prueba' and usuario.contrasena
			 * ='abc123' 
			 * and usuario.idRol=rol.idrol*/
			//-----------------------------------------------------

			/*sqlsearch = "select count(*) from usuario where usuario ='" + u.getUsuario() + "' and contrasena='"
					+ u.getContrasenia() + "';";*/
			stm = con.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
			// pst = con.prepareStatement(sqlsearch);
			res = stm.executeQuery(sqlsearch);
			res.first();
			
				if(res.isFirst()){
					u.setIdrol(res.getInt(1));
					return u;
							
				}
			
			//System.out.println("EL RESULTADO DE LA BUSQUEDA ES " + res.getInt(1));

			//System.out.println("EL RESULTADO DE LA BUSQUEDA ES " + res.getInt(1));


			return null;
		} catch (Exception e) {
			System.out.println("HAY ERRORES REVISE EL CODIGO");
			e.printStackTrace();

			return null;
		} finally {
			try {
				if (res != null)
					res.close();
				if (pst != null)
					pst.close();

			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		
	}

	public void AltaUsuario(UsuarioDto usa) {
		Connection con = null;
		PreparedStatement pts = null;
		ResultSet res = null;
		Statement stm = null;
		int i = 0;
		String sqlsearch = "";

		con = ConnectionPool.getConnection();
		sqlsearch = "INSERT INTO `usuario` ( `nombre`, `apellido`, `idTipoDocumento`, `numeroDocumento`, `usuario`, `contrasena`, `email`,`fechaalta`, `idRol`) VALUES ( ?, ?, ?, ?, ?, ?, ?, CURRENT_DATE() , ?);";
		/*
		 * ( `1nombre`, `2apellido`, `3idTipoDocumento`, `4numeroDocumento`,
		 * `5usuario`, `6contrasena`, `7email`,`8fechaalta`, `9idRol`) VALUES (
		 * ?, ?, ?, ?, ?, ?, ?, CURRENT_DATE() , ?);";
		 */
		try {
			con.setAutoCommit(false);
			pts = con.prepareStatement(sqlsearch);
			pts.setString(1, usa.getNombre());
			pts.setString(2, usa.getApellido());
			pts.setInt(3, 30);
			pts.setInt(4, Integer.valueOf(usa.getNumerodocumento()));
			pts.setString(5, usa.getUsuario());
			pts.setString(6, usa.getContrasenia());
			pts.setString(7, usa.getCorreoElectrinico());
			// pts.setDate(7,usa.getFechaAlta());
			pts.setInt(8, 21);

			/*
			 * pts.setString(2, usa.getApellido()); pts.setString(4,
			 * usa.getCorreoElectrinico()); pts.setInt(5,
			 * usa.getFlaghabilitado()); // pts.setBoole(5,
			 * usa.getFlaghabilitado());
			 */

			if (pts.executeUpdate() != 1) {
				System.out.print("PaSO");
			}
			con.commit();
			if (pts != null) {
				pts.close();
			}
			if (con != null) {
				con.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * terminar la coinsulta solo cargo nombre y apellido
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<UsuarioDto> selctUsuarios() {
		List<UsuarioDto> name = new LinkedList<UsuarioDto>();
		Connection con = ConnectionPool.getConnection();
		ResultSet res = null;
		Statement stm = null;
		try {
			stm = con.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
			res = stm.executeQuery("SELECT * FROM usuario ");
			while (res.next()) {
				// completar la carga de todos los elementos del usuario
				UsuarioDto usua = new UsuarioDto();
				
				usua.setIdusuario(res.getInt(1));
				usua.setNombre(res.getString(2));
				usua.setApellido(res.getString(3));
				usua.setNumerodocumento(res.getString(5));
				usua.setUsuario(res.getString(6));
				usua.setCorreoElectrinico(res.getString(8));
				name.add(usua);
			}
			return name;
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta");
			e.printStackTrace();
			return null;

		} finally {
			try {
				if (res != null)
					res.close();
				if (stm != null)
					stm.close();
			} catch (SQLException e2) {
				System.out.println("Error en el finally");

				e2.printStackTrace();
				throw new RuntimeException();
			}

		}
	}

	public void EliminarUsuario(UsuarioDto use) {
		Connection con = null;
		PreparedStatement pts = null;
		ResultSet res = null;
		Statement stm = null;
		int i = 0;
		String sqlsearch = "";

		con = ConnectionPool.getConnection();
		
		sqlsearch = "UPDATE `usuario` SET `FechaBaja` = now() WHERE `usuario` = '" + use.getUsuario() + "' AND `numeroDocumento` = '"
				+ use.getNumerodocumento()+"';";

		try {
			pts=con.prepareStatement(sqlsearch);
			con.setAutoCommit(false);
			if (pts.executeUpdate() != 1) {
				System.out.print("PaSO");
			}
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (res != null)
					res.close();
				if (stm != null)
					stm.close();
			} catch (SQLException e2) {
				System.out.println("Error en el finally");

				e2.printStackTrace();
				throw new RuntimeException();
			}

		}
	
	}
	
	public boolean RestriccionesUsuario(UsuarioDto user ){
		Connection con = null;
		
		ResultSet res = null;
		Statement stm = null;
		
				
		con = ConnectionPool.getConnection();
		
		/*try {
			stm = con.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
			res = stm.executeQuery("SELECT * FROM firma WHERE idUsuario = '"+user.getIdusuario()+"';");
			res.first();
			if (res.getInt(1)==1) {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta");
			e.printStackTrace();
			return false;

		} finally {*/
			try {
				if (res != null)
					res.close();
				if (stm != null)
					stm.close();
			} catch (SQLException e2) {
				System.out.println("Error en el finally");
				
				e2.printStackTrace();
				throw new RuntimeException();
			}

		//}
		
				

		return false;

		

		
	}
	
}
