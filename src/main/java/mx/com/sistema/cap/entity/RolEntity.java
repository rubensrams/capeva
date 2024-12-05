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
@Table(name="roles")
public class RolEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_rol")
	private Long id;

	private String name;

	@Column(name="nombre_largo")
	private String nombreLargo;
	


	public RolEntity() {
	
	}

	public RolEntity(String name, String nombreLargo) {
		this.name = name;
		this.nombreLargo = nombreLargo;
	}





	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNombreLargo() {
		return nombreLargo;
	}


	public void setNombreLargo(String nombreLargo) {
		this.nombreLargo = nombreLargo;
	}
	
		

		
	

}