package mx.com.sistema.cap.dto;

import java.io.Serializable;

public class CargaPoaDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String ubicacion;
	private String nombreObra;
	private String numPresupuesto;
	private Double presupuestoAnual;
	private String observaciones;
	
	
	
	
	public String getUbicacion() {
		return ubicacion;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumPresupuesto() {
		return numPresupuesto;
	}
	public void setNumPresupuesto(String numPresupuesto) {
		this.numPresupuesto = numPresupuesto;
	}
	
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Double getPresupuestoAnual() {
		return presupuestoAnual;
	}
	public void setPresupuestoAnual(Double presupuestoAnual) {
		this.presupuestoAnual = presupuestoAnual;
	}
	@Override
	public String toString() {
		return "CargaPoaDTO [id=" + id + ", ubicacion=" + ubicacion + ", nombreObra=" + nombreObra + ", numPresupuesto="
				+ numPresupuesto + ", presupuestoAnual=" + presupuestoAnual + ", observaciones=" + observaciones + "]";
	}

	
	
	
	

}
