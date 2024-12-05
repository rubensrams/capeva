package mx.com.sistema.cap.service;

import mx.com.sistema.cap.exception.ServiceException;

public interface ICargaPoaService {

	void procesaCargaPoa(final String filePath, final String anio) throws ServiceException;
}
