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

import back.dtos.TipoDocumentoDTO;
import front.pantalla.ejecutora.ConnectionPool;

import java.sql.Connection;


/**
 *
 * @author Alumno
 */
public class TipoDocumentoDAO {
      
      	public List <TipoDocumentoDTO> listado(){
	 List <TipoDocumentoDTO> lista = new LinkedList<>();
	    Connection con = ConnectionPool.getConnection();
		try{
			Statement stm = con.createStatement();
			ResultSet re = stm.executeQuery("SELECT * FROM TIPODOCUMENTO");
			while(re.next()){
				TipoDocumentoDTO mt = new TipoDocumentoDTO();
				mt.setIdtipodocumento(re.getInt(1));
				mt.setDescripcion(re.getString(2));
				mt.setAbreviacion(re.getString(3));
			
				lista.add(mt);
				
			}
		}catch(SQLException e){
			return null;
		}
		return lista;
	}
      
}
