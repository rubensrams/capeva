package mx.com.sistema.cap.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.sistema.cap.constantes.Constantes;
import mx.com.sistema.cap.dao.IGruposDAO;
import mx.com.sistema.cap.dto.GruposDTO;
import mx.com.sistema.cap.entity.GrupoEntity;
import mx.com.sistema.cap.exception.ServiceException;
import mx.com.sistema.cap.service.IGrupoService;




@Service
public class GruposServiceImpl implements IGrupoService {
	private static final Logger LOGGER = LogManager.getLogger(GruposServiceImpl.class);

	
	@Autowired
	private IGruposDAO gruposDAO;
	

	@Override
	@Transactional(readOnly = true)
	public List<GruposDTO> listadoGrupo() throws ServiceException {
		
	try {
		
		List<GrupoEntity> gruposBD= gruposDAO.findByEstatusOrderByNumero(Constantes.ACTIVACION);
		List<GruposDTO> gruposDTO = new ArrayList<>(); 
		
		gruposBD.stream().forEach((p)-> {
			gruposDTO.add(new GruposDTO(p.getId(), p.getNumero(), p.getEstatus(), p.getLicenciatura().getNombre()));
		});		
		
		return gruposDTO;
	}catch(Exception e) {	
		 LOGGER.error("Ocurrio un error al consultar los grupos", e);
		 throw new ServiceException();
	 }

	}

}
