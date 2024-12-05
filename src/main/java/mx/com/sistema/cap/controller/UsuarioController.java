package mx.com.sistema.cap.controller;

import java.io.Serializable;
import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import mx.com.sistema.cap.dto.UsuarioDTO;
import mx.com.sistema.cap.service.impl.CapUserDetails;


@Named
@Scope("session")
public class UsuarioController implements Serializable{
	private static final Logger LOGGER = LogManager.getLogger(UsuarioController.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UsuarioDTO administrador;
	private String emailUser;
	private String nombre;
	private String nombreCompleto;
	private String rol;
	private String username;
	private Long idUsuario;
	private Long idEmpresa;
	
	/**
	 * 
	 */
	@PostConstruct
	public void init() {
		LOGGER.info("Iniciando sesion UsuarioController cortroller");
	}
	
	@PreDestroy 
	public void destroy() {
		
		LOGGER.info("Destroyed sesion UsuarioController cortroller!!!!!");
	}
	
	
	
	private CapUserDetails getUsuarioLogeado() {
		return  (CapUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	

	public Long getIdUsuario() {
		return getUsuarioLogeado().getId();
	}


	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}


	public UsuarioDTO getAdministrador() {
		return administrador;
	}

	public void setAdministrador(UsuarioDTO administrador) {
		this.administrador = administrador;
	}

	public String getEmailUser() {
		return getUsuarioLogeado().getEmail();
	}
	
	public String getUsername() {
		return getUsuarioLogeado().getUsername();
	}


	public String getNombre() {
		return getUsuarioLogeado().getNombreUsuario();
	}


	public String getNombreCompleto() {
		return getUsuarioLogeado().getNombreCompleto();
	}
	
	public String getRol() {
		 Iterator<GrantedAuthority> iterator = getUsuarioLogeado().getAuthorities().iterator();
		 String rol="";
	        while (iterator.hasNext()) {
	        	rol= iterator.next().getAuthority();
	        }

		return rol.replace("ROLE_", "");
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}


	
	
}