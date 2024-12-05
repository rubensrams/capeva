package mx.com.sistema.cap.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.inject.Named;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import mx.com.sistema.cap.constantes.Constantes;
import mx.com.sistema.cap.dto.CargaPoaDTO;
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


	private transient UploadedFile uploadedFile;
	private String grupo;	
	private boolean flagAnio;	
	private boolean flagFile;
	private boolean flagListado;
	private List<CargaPoaDTO> listCarga;
	private CargaPoaDTO rowSelected;
	
	private List<GruposDTO> listaGrupos;
	
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
		} catch (ServiceException e) {			
			addMessage(FacesMessage.SEVERITY_ERROR, Constantes.ERROR, "Error al consultar los grupos");
			actualizaForma();
		}
	}
	
	public void mainPanel() {
		flagAnio=true;
		flagFile=false;
		flagListado=false;
	}
	
	private void uploadPanel() {
		flagAnio=false;
		flagFile=true;
		flagListado=false;
	}
	
	private void listadoPanel() {
		flagListado= true;
		flagAnio=false;
		flagFile=false;
	}
	

	public void eventoCarga(FileUploadEvent e) throws IOException {
		
		uploadedFile = e.getFile();
		File file = new File(uploadedFile.getFileName());
		LOGGER.info("El archivo creado es: {}",file);
		LOGGER.info("Valor de anio: {}", grupo);

		String pathFile= RUTA_CARGA_DOCUMENTOS+file;
		FileOutputStream fi = new FileOutputStream(pathFile);
		fi.write(uploadedFile.getContent());
		fi.flush();
		fi.close();
		
		  listadoPanel();
		  actualizaForma();
		  addMessage(FacesMessage.SEVERITY_INFO, Constantes.AVISO, "Carga realizada correctamente");
		 
	}
		


	private void actualizaForma() {
		 PrimeFaces.current().ajax().update(":mainForm");
	}

	public void seleccionAnio() {		
		if(null == grupo || grupo.equals(Constantes.VALOR_VACIO)) {
			addMessage(FacesMessage.SEVERITY_ERROR, Constantes.ERROR, "Debes seleccionar el grupo");
			return;
		}
		uploadPanel();
	}



	public boolean isFlagAnio() {
		return flagAnio;
	}


	
	

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public void setFlagFile(boolean flagFile) {
		this.flagFile = flagFile;
	}


	public boolean isFlagListado() {
		return flagListado;
	}


	public void setFlagListado(boolean flagListado) {
		this.flagListado = flagListado;
	}


	public List<CargaPoaDTO> getListCarga() {
		return listCarga;
	}


	public void setListCarga(List<CargaPoaDTO> listCarga) {
		this.listCarga = listCarga;
	}

	public CargaPoaDTO getRowSelected() {
		return rowSelected;
	}

	public void setRowSelected(CargaPoaDTO rowSelected) {
		this.rowSelected = rowSelected;
	}

	public List<GruposDTO> getListaGrupos() {
		return listaGrupos;
	}

	public void setListaGrupos(List<GruposDTO> listaGrupos) {
		this.listaGrupos = listaGrupos;
	}

	
	
	
}
