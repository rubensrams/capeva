package mx.com.sistema.cap.dto;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the obras_cargas_poa database table.
 * 
 */
/**
 * 
 */

public class ArchivosEvaDTO implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nombre;
	
	private String tipoDocumento;
	
	private String url;

	private Date fechaCarga;
	
	private int estatus;
	
	private String grupo;
	
	private String licienciatura;
	


	public ArchivosEvaDTO() {

	}

	public ArchivosEvaDTO(Long id, String nombre, String tipoDocumento, String url, Date fechaCarga,int estatus, String grupo, String licienciatura) {
		this.id = id;
		this.nombre = nombre;
		this.tipoDocumento = tipoDocumento;
		this.url = url;
		this.fechaCarga = fechaCarga;
		this.estatus = estatus;
		this.grupo = grupo;
		this.licienciatura = licienciatura;
	}

	
	public ArchivosEvaDTO(String nombre, String tipoDocumento, String url, Date fechaCarga,int estatus, String grupo) {
		this.nombre = nombre;
		this.tipoDocumento = tipoDocumento;
		this.url = url;
		this.fechaCarga = fechaCarga;
		this.estatus = estatus;
		this.grupo = grupo;
	}
	
	
	
	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getLicienciatura() {
		return licienciatura;
	}

	public void setLicienciatura(String licienciatura) {
		this.licienciatura = licienciatura;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}



	public Date getFechaCarga() {
		return fechaCarga;
	}

	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	
	
	@Override
	public String toString() {
		return "ArchivosEvaDTO [id=" + id + ", nombre=" + nombre + ", tipoDocumento=" + tipoDocumento + ", url=" + url
				+ ", fechaCarga=" + fechaCarga + ", estatus=" + estatus + ", grupo=" + grupo + ", licienciatura="
				+ licienciatura + "]";
	}

	
	
	

	

}