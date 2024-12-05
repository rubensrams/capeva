package mx.com.sistema.cap.service;

import java.util.List;

import mx.com.sistema.cap.dto.GruposDTO;
import mx.com.sistema.cap.exception.ServiceException;

public interface IGrupoService {

	List<GruposDTO> listadoGrupo() throws ServiceException;
}
