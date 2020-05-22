/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package back.dtos;

import java.util.Date;

/**
 *
 * @author Alumno
 */
public class RolDTO {
      private int idRol;
      private String Descripcion;
      private Date FechaAlta;
      private Date FechaBaja;

      public int getIdRol() {
	    return idRol;
      }

      public void setIdRol(int idRol) {
	    this.idRol = idRol;
      }

      public String getDescripcion() {
	    return Descripcion;
      }

      public void setDescripcion(String Descripcion) {
	    this.Descripcion = Descripcion;
      }

      public Date getFechaAlta() {
	    return FechaAlta;
      }

      public void setFechaAlta(Date FechaAlta) {
	    this.FechaAlta = FechaAlta;
      }

      public Date getFechaBaja() {
	    return FechaBaja;
      }

      public void setFechaBaja(Date FechaBaja) {
	    this.FechaBaja = FechaBaja;
      }
      
      @Override
      public String toString(){
	    return "Rol [idRol"+idRol+",descripcion="+Descripcion+"FechaAlta="+FechaAlta+"fechabaja="+FechaBaja+"]";
	/*	return "TipoAutomor 
	 * [idtipomotor"+idtipomotor+
	 * ",descripcion="+descripcion+",flagHabilitado="+flagHabilitado+"]";
	*/
      }
      
      
      
}
