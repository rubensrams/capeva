package mx.com.sistema.cap.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
//CDI
//import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import mx.com.sistema.cap.constantes.ConstantesNavigation;
import mx.com.sistema.cap.dto.UsuarioDTO;





@Named
@RequestScoped
public class IndexController extends MainController  implements Serializable {

	private static final Logger LOGGER = LogManager.getLogger(IndexController.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String user;

	private String password;
	
	private String mensajeAutenticacion;
	

	
	
	@PostConstruct
	public void init() {
		cleanError();
	}

	public void checkSesion() {
		LOGGER.info("Checando sesion...");
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
			UsuarioDTO usuario = (UsuarioDTO) context.getExternalContext().getSessionMap().get("userSession");
			LOGGER.info("Usuario...{}", usuario);
			if ((request.getRequestedSessionId() != null && !request.isRequestedSessionIdValid()) || null == usuario) {
				LOGGER.info("No se encontro una sesion activa...");
				context.getExternalContext().redirect("/CapEva/index.jsf?faces-redirect=true");
			}else {
				LOGGER.info("Sesion activa!!");
			}	
		} catch (Exception e) {
			addMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrio un error en el sistema");
		}

	}
	
	public String closeSesion() {
		LOGGER.info("Cerrando sesion");
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return ConstantesNavigation.LOGIN;
		
	}
	
	private void cleanError() {
		mensajeAutenticacion="";
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMensajeAutenticacion() {
		return mensajeAutenticacion;
	}

	public void setMensajeAutenticacion(String mensajeAutenticacion) {
		this.mensajeAutenticacion = mensajeAutenticacion;
	}

	
}
