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
	
	
	
	
	
	
	public GruposDTO(Long id, String numero, int estatus) {
		this.id = id;
		this.numero = numero;
		this.estatus = estatus;
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
