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
public class UsuariosRoles {
      private int Id_usuarioroles;
      private int id_usuario;
      private int id_rol;
      private Date FechaAlta;
      private Date FechaBaja;

      public int getId_usuarioroles() {
	    return Id_usuarioroles;
      }

      public void setId_usuarioroles(int Id_usuarioroles) {
	    this.Id_usuarioroles = Id_usuarioroles;
      }

      public int getId_usuario() {
	    return id_usuario;
      }

      public void setId_usuario(int id_usuario) {
	    this.id_usuario = id_usuario;
      }

      public int getId_rol() {
	    return id_rol;
      }

      public void setId_rol(int id_rol) {
	    this.id_rol = id_rol;
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
      
      
      
}
