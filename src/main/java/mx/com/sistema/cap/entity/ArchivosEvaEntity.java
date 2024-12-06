package mx.com.sistema.cap.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the obras_cargas_poa database table.
 * 
 */
/**
 * 
 */
@Entity
@Table(name="archivos_eva")
public class ArchivosEvaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	@Column(name="tipo_docto")
	private String tipoDocumento;
	
	private String url;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_carga")
	private Date fechaCarga;
	
	private int estatus;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grupo", nullable = false)
    private GrupoEntity grupo;
	


	public ArchivosEvaEntity() {

	}

	public ArchivosEvaEntity(String nombre, String tipoDocumento, String url, Date fechaCarga,int estatus) {
		this.nombre = nombre;
		this.tipoDocumento = tipoDocumento;
		this.url = url;
		this.fechaCarga = fechaCarga;
		this.estatus = estatus;
	}
	
	
	

	public GrupoEntity getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoEntity grupo) {
		this.grupo = grupo;
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

	
		
	

	

}