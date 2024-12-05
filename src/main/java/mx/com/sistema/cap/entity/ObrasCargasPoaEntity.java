package mx.com.sistema.cap.entity;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


/**
 * The persistent class for the obras_cargas_poa database table.
 * 
 */
/**
 * 
 */
@Entity
@Table(name="obras_cargas_poa")
public class ObrasCargasPoaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name="num_presupuesto")
	private String numPresupuesto;

	@Column(name="nombre_obra")
	private String nombreObra;
	
	private String ubicacion;

	@Column(name="presupuesto_anual")
	private Double presupuestoAnual;

	@Column(name="carga_exp")
	private int cargaExp;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_carga")
	private Date fechaCarga;

	@Column(name="nombre_archivo")
	private String nombreArchivo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_act")
	private Date fechaActualizacion;
	
	private String observaciones;

	public ObrasCargasPoaEntity() {
	
	}
	

	public ObrasCargasPoaEntity(Long id, String numPresupuesto, String nombreObra, String ubicacion,
			Double presupuestoAnual, String nombreArchivo, String observaciones) {
		this.id = id;
		this.numPresupuesto = numPresupuesto;
		this.nombreObra = nombreObra;
		this.ubicacion = ubicacion;
		this.presupuestoAnual = presupuestoAnual;
		this.nombreArchivo = nombreArchivo;
		this.observaciones = observaciones;
		this.fechaCarga=new Date();
		this.fechaActualizacion=new Date();
	}



	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}



	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}



	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCargaExp() {
		return this.cargaExp;
	}

	public void setCargaExp(int cargaExp) {
		this.cargaExp = cargaExp;
	}

	public Date getFechaCarga() {
		return this.fechaCarga;
	}

	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
	}

	public String getNumPresupuesto() {
		return this.numPresupuesto;
	}

	public void setNumPresupuesto(String numPresupuesto) {
		this.numPresupuesto = numPresupuesto;
	}

	public Double getPresupuestoAnual() {
		return this.presupuestoAnual;
	}

	public void setPresupuestoAnual(Double presupuestoAnual) {
		this.presupuestoAnual = presupuestoAnual;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getNombreObra() {
		return nombreObra;
	}

	public void setNombreObra(String nombreObra) {
		this.nombreObra = nombreObra;
	}


	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	
	



	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public String toString() {
		return "ObrasCargasPoa [id=" + id + ", numPresupuesto=" + numPresupuesto + ", nombreObra=" + nombreObra
				+ ", ubicacion=" + ubicacion + ", presupuestoAnual=" + presupuestoAnual + ", cargaExp=" + cargaExp
				+ ", fechaCarga=" + fechaCarga + ", nombreArchivo=" + nombreArchivo + ", fechaActualizacion="
				+ fechaActualizacion + "]";
	}
	
	
	

}