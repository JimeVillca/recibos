/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package back.dtos;

/**
 *
 * @author Alumno
 */
public class TipoDocumentoDTO {
      private int idtipodocumento;
      private String descripcion;
      private String abreviacion;

      public int getIdtipodocumento() {
	    return idtipodocumento;
      }

      public void setIdtipodocumento(int idtipodocumento) {
	    this.idtipodocumento = idtipodocumento;
      }

      public String getDescripcion() {
	    return descripcion;
      }

      public void setDescripcion(String descripcion) {
	    this.descripcion = descripcion;
      }

      public String getAbreviacion() {
	    return abreviacion;
      }

      public void setAbreviacion(String abreviacion) {
	    this.abreviacion = abreviacion;
      }
      
      @Override
      public String toString(){
	    return "TipoDocumento [idTipoDocumento"+idtipodocumento+"Descripcion "+descripcion+"Abreviacion"+abreviacion+"]";
	    
      }
	      
      
}
