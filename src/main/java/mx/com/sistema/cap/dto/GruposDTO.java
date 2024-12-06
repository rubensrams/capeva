package mx.com.sistema.cap.dto;

import java.io.Serializable;

public class GruposDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String numero;
	private int estatus;
	private String licenciatura;
	
	
	
	
	
	public GruposDTO(Long id, String numero, int estatus, String licenciatura) {
		this.id = id;
		this.numero = numero;
		this.estatus = estatus;
		this.licenciatura=licenciatura;
	}
	
	
	
	
	
	public String getLicenciatura() {
		return licenciatura;
	}





	public void setLicenciatura(String licenciatura) {
		this.licenciatura = licenciatura;
	}





	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public int getEstatus() {
		return estatus;
	}
	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}
	
	
	
	
	

}
