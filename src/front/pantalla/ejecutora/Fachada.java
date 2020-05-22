/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package front.pantalla.ejecutora;

import java.util.List;
import java.util.Scanner;

import back.daos.ConceptoDAO;
import back.daos.LoteDAO;
import back.daos.RolDAO;
import back.daos.TipoDocumentoDAO;
import back.daos.UsuarioDAO;
import back.dtos.ConceptoDTO;
import back.dtos.LoteDTO;
import back.dtos.RolDTO;
import back.dtos.TipoDocumentoDTO;
import back.dtos.UsuarioDto;

/**
 *
 * @author Alumno
 */
public class Fachada {
      
      public UsuarioDto Validacion (UsuarioDto usu){
      
//	    Scanner teclado = new Scanner(System.in);
	    UsuarioDAO usa = new UsuarioDAO ();
	    return usa.loguin(usu);
	    
      }
      public boolean  AltaUsuario(UsuarioDto uss){
	    UsuarioDAO us= new UsuarioDAO();
	    us.AltaUsuario(uss);
	    return true;
      
      }
    	public List <RolDTO> SelectRol(){
		RolDAO ado= new RolDAO();
		return ado.listado();
	}
          	public List <TipoDocumentoDTO> SelectTipoDoc(){
		TipoDocumentoDAO ado= new TipoDocumentoDAO();
		return ado.listado();
	}
          	/**
          	 * realizar el resto de la consulta esto es una simple guia
          	 * @return
          	 */
      public List<UsuarioDto> selectUsuario() {
    	  UsuarioDAO name = new UsuarioDAO();
    	  
    	  
		return name.selctUsuarios();
	}
      
      public List<ConceptoDTO> selectConcepto(){
    	  ConceptoDAO conceptoconst = new ConceptoDAO();
    	  
    	  return conceptoconst.consultaConcepto();
    	  
      }
      
      public boolean EliminarUsuario(UsuarioDto use){
    	  UsuarioDAO usee= new UsuarioDAO();
    	  usee.EliminarUsuario(use);
    	  return true;
      }
      
      public boolean RegistricionesUsuario(UsuarioDto usuario){
    	  UsuarioDAO user = new UsuarioDAO();
    	 return  user.RestriccionesUsuario(usuario);
    	  
    	  
      }
	public void importarArchivo(String ruta) {
		// TODO Auto-generated method stub
		LoteDAO lote = new LoteDAO();
	 lote.importarCVS(ruta);
		
	}
      
}
