package mx.com.sistema.cap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the obras_cargas_poa database table.
 * 
 */
/**
 * 
 */
@Entity
@Table(name="grupos")
public class GrupoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_grupo")
	private Long id;
	
	private String numero;
	
	private int estatus;
	
	
	
	
	public GrupoEntity() {

	}





	public GrupoEntity(Long id, String numero, int estatus) {
		this.id = id;
		this.numero = numero;
		this.estatus = estatus;
	}

	
	
	
	
	public int getEstatus() {
		return estatus;
	}





	public void setEstatus(int estatus) {
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
	
	
	
	

}