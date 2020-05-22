/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package back.dtos;

import java.util.Date;


//import java.lang.Exception;


/**
 *
 * @author Alumno
 */
public class UsuarioDto {
      private int Idusuario;
      private String Contrasenia;
      private String Nombre;
      private String Apellido;
      private int idtipodocumento;
      private String numerodocumento;
      private String usuario; 
      private String CorreoElectrinico;
      private Date FechaAlta;
      private Date  Fechabaja;
      private int flaghabilitado;
      private int idrol;
      

      public String getContrasenia() {
	    return Contrasenia;
      }

      public void setContrasenia(String Contrasenia) {
	    this.Contrasenia = Contrasenia;
      }

      public String getNombre() {
	    return Nombre;
      }

      public void setNombre(String Nombre) {
	    this.Nombre = Nombre;
      }

      public String getApellido() {
	    return Apellido;
      }

      public void setApellido(String Apellido) {
	    this.Apellido = Apellido;
      }

      public String getCorreoElectrinico() {
	    return CorreoElectrinico;
      }

      public void setCorreoElectrinico(String CorreoElectrinico) {
	    this.CorreoElectrinico = CorreoElectrinico;
      }

      public Date getFechaAlta() {
	    return FechaAlta;
      }

      public void setFechaAlta(Date FechaAlta) {
	    this.FechaAlta = FechaAlta;
      }

      public Date getFechabaja() {
	    return Fechabaja;
      }

      public void setFechabaja(Date Fechabaja) {
	    this.Fechabaja = Fechabaja;
      }

      public int getFlaghabilitado() {
	    return flaghabilitado;
      }

      public void setFlaghabilitado(int flaghabilitado) {
	    this.flaghabilitado = flaghabilitado;
      }

      public int getIdtipodocumento() {
	    return idtipodocumento;
      }

      public void setIdtipodocumento(int idtipodocumento) {
	    this.idtipodocumento = idtipodocumento;
      }

      public String getNumerodocumento() {
	    return numerodocumento;
      }

      public void setNumerodocumento(String numerodocumento) {
	    this.numerodocumento = numerodocumento;
      }

      public String getUsuario() {
	    return usuario;
      }

      public void setUsuario(String usuario) {
	    this.usuario = usuario;
      }

      public int getIdrol() {
	    return idrol;
      }

      public void setIdrol(int idrol) {
	    this.idrol = idrol;
      }

	

	

	public int getIdusuario() {
		return Idusuario;
	}

	public void setIdusuario(int idusuario) {
		Idusuario = idusuario;
	}
	      
      
     
}
