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
@Table(name="licenciaturas")
public class LicienciaturaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_licenciatura")
	private Long id;
	
	private String nombre;
	
	private int estatus;
	
	
	
	
	public LicienciaturaEntity() {

	}





	public LicienciaturaEntity(Long id, String nombre, int estatus) {
		this.id = id;
		this.nombre = nombre;
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





	public String getNombre() {
		return nombre;
	}





	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
	
	
	
	

}