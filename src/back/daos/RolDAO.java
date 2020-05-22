/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package back.daos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import back.dtos.RolDTO;
import front.pantalla.ejecutora.ConnectionPool;

import java.sql.Connection;

/**
 *
 * @author Alumno
 */
public class RolDAO {
   private static Connection con = null;

 
	 public List <RolDTO> listado(){
	 List <RolDTO> lista = new LinkedList<RolDTO>();
		try {
			con = ConnectionPool.getConnection();
			Statement stm;
		  stm = con.createStatement();
			ResultSet rst = stm.executeQuery(
					"SELECT * FROM rol");
			
			while (rst.next()) {
				RolDTO name = new RolDTO();
				name.setIdRol(rst.getInt(1));
				name.setDescripcion(rst.getString(2));
				
				System.out.println("ID "+name.getIdRol()+" Descripcion "+name.getDescripcion());
				lista.add(name);
	
			}
		} catch (SQLException e) {
			System.out.println("No se pudo hacer la consulta");
		}
		return lista;
	}


      
      
      
}
