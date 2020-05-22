package back.dtos;

import java.util.Date;

public class LoteDTO {
	private int id;
	private Date fechaImportacion;
	private String periodo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFechaImportacion() {
		return fechaImportacion;
	}
	public void setFechaImportacion(Date fechaImportacion) {
		this.fechaImportacion = fechaImportacion;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	

}
