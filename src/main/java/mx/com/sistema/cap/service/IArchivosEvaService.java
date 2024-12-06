package mx.com.sistema.cap.service;

import java.util.List;

import mx.com.sistema.cap.dto.ArchivosEvaDTO;
import mx.com.sistema.cap.exception.ServiceException;

public interface IArchivosEvaService {

	void createArchivoEva(ArchivosEvaDTO archivosEvaDTO)throws ServiceException;
	
	
	List<ArchivosEvaDTO> listadoArchivosEva(String tipoDoc) throws ServiceException;
	
	
}
