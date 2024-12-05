package mx.com.sistema.cap.service;

import mx.com.sistema.cap.dto.UsuarioDTO;
import mx.com.sistema.cap.exception.AuthenticacionException;
import mx.com.sistema.cap.exception.ServiceException;

public interface ILoginService {

	UsuarioDTO login (String usuario, String password)throws ServiceException, AuthenticacionException;
}
