package mx.com.sistema.cap.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.sistema.cap.dao.IArchivosEvaDAO;
import mx.com.sistema.cap.dto.ArchivosEvaDTO;
import mx.com.sistema.cap.entity.ArchivosEvaEntity;
import mx.com.sistema.cap.entity.GrupoEntity;
import mx.com.sistema.cap.exception.ServiceException;
import mx.com.sistema.cap.service.IArchivosEvaService;




@Service
public class ArchivosEvaServiceImpl implements IArchivosEvaService {
	private static final Logger LOGGER = LogManager.getLogger(ArchivosEvaServiceImpl.class);

	
	@Autowired
	private IArchivosEvaDAO archivosEvaDAO;
	

	@Override
	@Transactional(readOnly = true)
	public List<ArchivosEvaDTO> listadoArchivosEva(String tipoDoc) throws ServiceException {
		
	try {
		
		List<ArchivosEvaEntity> archivosBD= archivosEvaDAO.findByTipoDocumentoOrderByIdDesc(tipoDoc);
		List<ArchivosEvaDTO> archivosDTO = new ArrayList<>(); 
		
		archivosBD.stream().forEach((p)-> {
			archivosDTO.add(new ArchivosEvaDTO(p.getId(), p.getNombre().toUpperCase(), p.getTipoDocumento(), p.getUrl(),
							p.getFechaCarga(), p.getEstatus(), p.getGrupo().getNumero(), p.getGrupo().getLicenciatura().getNombre().toUpperCase()));
		});		
		
		return archivosDTO;
	}catch(Exception e) {	
		 LOGGER.error("Ocurrio un error al consultar los archivo eva", e);
		 throw new ServiceException();
	 }

	}


	@Override
	public void createArchivoEva(ArchivosEvaDTO archivosEvaDTO) throws ServiceException {
			
		try {
			
			ArchivosEvaEntity alta = new ArchivosEvaEntity(archivosEvaDTO.getNombre(), 
					archivosEvaDTO.getTipoDocumento(),
					archivosEvaDTO.getUrl(),
					archivosEvaDTO.getFechaCarga(),
					archivosEvaDTO.getEstatus());			
					alta.setGrupo(new GrupoEntity(new Long(archivosEvaDTO.getGrupo())));			
			archivosEvaDAO.save(alta);
			LOGGER.info("Archivo eva: {}, guardado exitosamente ", archivosEvaDTO.getNombre());
		}catch(Exception e) {	
			e.printStackTrace();
			 LOGGER.error("Ocurrio un error al crear archivo eva", e);
			 throw new ServiceException();
		 }

		
	}


}
