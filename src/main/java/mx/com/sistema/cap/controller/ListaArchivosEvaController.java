package mx.com.sistema.cap.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.PrimeFaces;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import mx.com.sistema.cap.constantes.Constantes;
import mx.com.sistema.cap.constantes.ConstantesNavigation;
import mx.com.sistema.cap.dto.ArchivosEvaDTO;
import mx.com.sistema.cap.dto.GruposDTO;
import mx.com.sistema.cap.exception.ServiceException;
import mx.com.sistema.cap.service.IArchivosEvaService;
import mx.com.sistema.cap.service.IGrupoService;



@Named
@Scope("session")
@PropertySource({
    "classpath:application-dev.properties",
    "classpath:application-prod.properties"
})
public class ListaArchivosEvaController extends MainController implements Serializable {

	private static final Logger LOGGER = LogManager.getLogger(ListaArchivosEvaController.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Value("${ruta.carga.videos}")
	private String RUTA_CARGA_VIDEOS;
	
	@Value("${ruta.carga.documentos}")
	private String RUTA_CARGA_DOCUMENTOS;

	
	@Autowired
	private transient IArchivosEvaService archivosEvaService;


	private List<ArchivosEvaDTO> listaArchivosEvaDTO;

	
	@PreDestroy 
	public void destroy() {
		
		LOGGER.info("Destroyed sesion ListaArchivosEvaController cortroller!!!!!");
	}
	
	public ListaArchivosEvaController() {
		LOGGER.info("Iniciando consulta de registros POA");
		
	}
	
	@PostConstruct
	private void init() {
		LOGGER.info("Iniciando sesion ListaArchivosEvaController cortroller");
		
	}
	
	public void ejectListado() {		
		
		try {
		 FacesContext fc = FacesContext.getCurrentInstance();
	     Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
	     String tipoArchivoParam =  params.get("tipoArchivo");
		 System.out.println("Prametro: "+tipoArchivoParam);
			listaArchivosEvaDTO = archivosEvaService.listadoArchivosEva(tipoArchivoParam);
		} catch (ServiceException e) {
			addMessage(FacesMessage.SEVERITY_ERROR, Constantes.ERROR, "Error al consultar los archivos");
			actualizaForma();
		}
	
	}


	private void actualizaForma() {
		 PrimeFaces.current().ajax().update(":mainFormList");
	}

	public List<ArchivosEvaDTO> getListaArchivosEvaDTO() {
		return listaArchivosEvaDTO;
	}

	public void setListaArchivosEvaDTO(List<ArchivosEvaDTO> listaArchivosEvaDTO) {
		this.listaArchivosEvaDTO = listaArchivosEvaDTO;
	}

		
	
	
}
