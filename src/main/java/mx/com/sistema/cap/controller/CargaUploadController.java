package mx.com.sistema.cap.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.Random;

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
import mx.com.sistema.cap.dto.ArchivosEvaDTO;
import mx.com.sistema.cap.service.IArchivosEvaService;



@Named
@Scope("session")
@PropertySource({
    "classpath:application-dev.properties",
    "classpath:application-prod.properties"
})
public class CargaUploadController extends MainController implements Serializable {

	private static final Logger LOGGER = LogManager.getLogger(CargaUploadController.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Value("${ruta.carga.videos}")
	private String RUTA_CARGA_VIDEOS;
	
	@Value("${ruta.carga.documentos}")
	private String RUTA_CARGA_DOCUMENTOS;
	
	@Value("${url.app.descargas}")
	private String URL_APP_DESCARGAS;
 

	@Autowired
	private transient IArchivosEvaService archivosEvaService;


	private transient UploadedFile uploadedFile;
	private String grupo;
	private String tipoA;	
	
	private boolean listadoFlag; 
	private boolean cargaFlag;
	private boolean videoUp; 
	private boolean doctoUp;
	
	@PreDestroy 
	public void destroy() {
		
		LOGGER.info("Destroyed sesion PoaController cortroller!!!!!");
	}
	
	public CargaUploadController() {
		LOGGER.info("Iniciando consulta de registros POA");
		
	}
	
	@PostConstruct
	private void init() {
		LOGGER.info("Iniciando sesion CargaUploadController cortroller");
		setCargaFlag(true);
	}
	
	public void reset() {
		setListadoFlag(false);
		setCargaFlag(true);
	}

	public void showPanelListado() {
		setListadoFlag(true);
		setCargaFlag(false);
	}

	public void showTipoCarga() {
		
		if(tipoA.equals("DOCUMENTO")) {
			setVideoUp(false);
			setDoctoUp(true);
		}else {
			setVideoUp(true);
			setDoctoUp(false);
			
		}
	}

	public void eventoCarga(FileUploadEvent e) throws IOException {
		
		
		try {
			uploadedFile = e.getFile();
			File file = new File(uploadedFile.getFileName());
			//String nomDoc= uploadedFile.getFileName()+System.currentTimeMillis();
			
			String pathFile="";
			String url = "";
			String nombreArchivo="";
			File fileWithNewName = null;
			if(tipoA.equals("DOCUMENTO")) {
				nombreArchivo=identificador()+"-"+uploadedFile.getFileName();
				fileWithNewName = new File(file.getParent(), nombreArchivo);

				pathFile= RUTA_CARGA_DOCUMENTOS+fileWithNewName;
				
				url= URL_APP_DESCARGAS+"documentos/"+nombreArchivo;
				
			}else {
				nombreArchivo=identificador()+"-"+uploadedFile.getFileName();
				fileWithNewName = new File(file.getParent(), nombreArchivo);
				pathFile= RUTA_CARGA_VIDEOS+fileWithNewName;
				
				url= URL_APP_DESCARGAS+"videos/"+nombreArchivo;
			}			
			
			
			
			archivosEvaService.createArchivoEva(new ArchivosEvaDTO(nombreArchivo, tipoA, url, new Date(), Constantes.ACTIVACION, grupo));
			FileOutputStream fi = new FileOutputStream(pathFile);
			fi.write(uploadedFile.getContent());
			fi.flush();
			fi.close();
			
			addMessage(FacesMessage.SEVERITY_INFO, Constantes.AVISO, "Carga realizada correctamente");
			showPanelListado();
			actualizaForma();
			
		}catch (Exception ex) {
			addMessage(FacesMessage.SEVERITY_ERROR, Constantes.ERROR, "Error al realizar la carga");
			actualizaForma();
		}
			
	

	}
		
	
	private int identificador() {
		Random random = new Random();
		return random.nextInt(1000 - 1 + 1) + 1;
		
	}
	
	


	private void actualizaForma() {
		 PrimeFaces.current().ajax().update(":mainForm");
	}




	
	

	public boolean isListadoFlag() {
		return listadoFlag;
	}

	public void setListadoFlag(boolean listadoFlag) {
		this.listadoFlag = listadoFlag;
	}

	public boolean isCargaFlag() {
		return cargaFlag;
	}

	public void setCargaFlag(boolean cargaFlag) {
		this.cargaFlag = cargaFlag;
	}

	public String getTipoA() {
		return tipoA;
	}

	public void setTipoA(String tipoA) {
		this.tipoA = tipoA;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public boolean isVideoUp() {
		return videoUp;
	}

	public void setVideoUp(boolean videoUp) {
		this.videoUp = videoUp;
	}

	public boolean isDoctoUp() {
		return doctoUp;
	}

	public void setDoctoUp(boolean doctoUp) {
		this.doctoUp = doctoUp;
	}

	

		
	
}
