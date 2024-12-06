package mx.com.sistema.cap.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import mx.com.sistema.cap.constantes.Constantes;
import mx.com.sistema.cap.constantes.ConstantesNavigation;
import mx.com.sistema.cap.dto.GruposDTO;
import mx.com.sistema.cap.exception.ServiceException;
import mx.com.sistema.cap.service.IGrupoService;



@Named
@Scope("session")
@PropertySource({
    "classpath:application-dev.properties",
    "classpath:application-prod.properties"
})
public class CargaController extends MainController implements Serializable {

	private static final Logger LOGGER = LogManager.getLogger(CargaController.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Value("${ruta.carga.videos}")
	private String RUTA_CARGA_VIDEOS;
	
	@Value("${ruta.carga.documentos}")
	private String RUTA_CARGA_DOCUMENTOS;

	@Autowired
	private transient IGrupoService grupoService;


	private String grupo;
	private String tipoA;	


	private List<GruposDTO> listaGrupos;
	
	private List<String> tipoArchivo;
	
	@Inject
	private Provider<CargaUploadController> cargUpController;
	
	@PreDestroy 
	public void destroy() {
		
		LOGGER.info("Destroyed sesion PoaController cortroller!!!!!");
	}
	
	public CargaController() {
		LOGGER.info("Iniciando consulta de registros POA");
		
	}
	
	@PostConstruct
	private void init() {
		LOGGER.info("Iniciando sesion CargaController cortroller");
		try {
			listaGrupos = grupoService.listadoGrupo();
			tipoArchivo= Constantes.tipoArchivo();
		} catch (ServiceException e) {			
			addMessage(FacesMessage.SEVERITY_ERROR, Constantes.ERROR, "Error al consultar los grupos");
			actualizaForma();
		}
		
	}
	
	public void clean() {
		
		setGrupo("");
		setTipoA("");
	}
	

	
	public String envioCarga() {
	
		if(grupo.equals(Constantes.VALOR_VACIO)) {
			
			addMessage(FacesMessage.SEVERITY_ERROR, Constantes.ERROR, "Debes seleccionar el grupo");
			actualizaForma();
			return ConstantesNavigation.CARGA;
		}

		if(tipoA.equals(Constantes.VALOR_VACIO)) {
			addMessage(FacesMessage.SEVERITY_ERROR, Constantes.ERROR, "Debes seleccionar el tipo de documento");
			actualizaForma();
			return ConstantesNavigation.CARGA;
		}
		
		cargUpController.get().setGrupo(grupo);
		cargUpController.get().setTipoA(tipoA);
		cargUpController.get().reset();
		cargUpController.get().showTipoCarga();
		
		return ConstantesNavigation.CARGA_UP;
	}

	
	private void actualizaForma() {
		 PrimeFaces.current().ajax().update(":mainForm");
	}

	
	

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}



	public List<GruposDTO> getListaGrupos() {
		return listaGrupos;
	}

	public void setListaGrupos(List<GruposDTO> listaGrupos) {
		this.listaGrupos = listaGrupos;
	}

	public List<String> getTipoArchivo() {
		return tipoArchivo;
	}

	public void setTipoArchivo(List<String> tipoArchivo) {
		this.tipoArchivo = tipoArchivo;
	}

	public String getTipoA() {
		return tipoA;
	}

	public void setTipoA(String tipoA) {
		this.tipoA = tipoA;
	}
	
	
	
	
}
