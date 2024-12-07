package mx.com.sistema.cap.controller;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import mx.com.sistema.cap.constantes.Constantes;
import mx.com.sistema.cap.dto.ArchivosEvaDTO;
import mx.com.sistema.cap.exception.ServiceException;
import mx.com.sistema.cap.service.IArchivosEvaService;



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

	private String tipoDoc;
	
	@Autowired
	private transient IArchivosEvaService archivosEvaService;


	private List<ArchivosEvaDTO> listaArchivosEvaDTO;
	
	
	private ArchivosEvaDTO rowSelected;

	
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
	
	
	public void eliminarFile() {

		try {
			archivosEvaService.deleteArchivoEva(rowSelected);
			String fileName =RUTA_CARGA_DOCUMENTOS+rowSelected.getNombre();					
			File file = new File(fileName);			
			file.delete();
			PrimeFaces current = PrimeFaces.current();
			current.executeScript("PF('deleteFile').hide();");
			addMessage(FacesMessage.SEVERITY_INFO, Constantes.AVISO, "Archivo eliminado exitosamente");
			listaArchivosEvaDTO = archivosEvaService.listadoArchivosEva(rowSelected.getTipoDocumento());
			actualizaForma();
			
		} catch (ServiceException e) {
			addMessage(FacesMessage.SEVERITY_ERROR, Constantes.ERROR, "Error al eliminar el archivo");
			actualizaFormaModalEliminacion();
		}
	}
	
	
	public void ejectListado() {		
		
		try {
		 FacesContext fc = FacesContext.getCurrentInstance();
	     Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
	     String tipoArchivoParam =  params.get("tipoArchivo");
			listaArchivosEvaDTO = archivosEvaService.listadoArchivosEva(tipoArchivoParam);
		} catch (ServiceException e) {
			addMessage(FacesMessage.SEVERITY_ERROR, Constantes.ERROR, "Error al consultar los archivos");
			actualizaForma();
		}
	
	}
	
	
	private void actualizaFormaModalEliminacion() {
		 PrimeFaces.current().ajax().update(":mainDelFile");
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

	public String getTipoDoc() {
		return tipoDoc;
	}

	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public ArchivosEvaDTO getRowSelected() {
		return rowSelected;
	}

	public void setRowSelected(ArchivosEvaDTO rowSelected) {
		this.rowSelected = rowSelected;
	}

	
	
	
}
