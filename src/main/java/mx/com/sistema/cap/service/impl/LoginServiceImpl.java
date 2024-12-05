package mx.com.sistema.cap.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import mx.com.sistema.cap.constantes.Constantes;
import mx.com.sistema.cap.dao.IUsuarioDAO;
import mx.com.sistema.cap.dto.UsuarioDTO;
import mx.com.sistema.cap.entity.RolEntity;
import mx.com.sistema.cap.entity.UsuarioEntity;




@Service
public class LoginServiceImpl implements UserDetailsService {
	private static final Logger LOGGER = LogManager.getLogger(LoginServiceImpl.class);

	
	@Autowired
	private IUsuarioDAO iUsuarioDAO;
	
	private static final String ROLE_VALIDO = "ADMIN";

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioEntity user= iUsuarioDAO.findByUsername(username);
		
		if(user==null) {
			LOGGER.error("No existe el usuario con correo: {}", username);
			throw new UsernameNotFoundException("No existe en el sistema");
		}
		if(!user.getRoles().getName().equals(ROLE_VALIDO)) {
			LOGGER.error("Rol no permitido para ingresar al eva: {}", user.getRoles().getName());
			throw new UsernameNotFoundException("Usuario invalido");
		}
		UsuarioDTO userdto = new UsuarioDTO(user.getName());
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		request.getSession().setAttribute("userSession", userdto);	   
		
		LOGGER.info("Usuario: {}", user.toString());
		List<GrantedAuthority> authorities= new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_".concat(user.getRoles().getName())));
		CapUserDetails usuario = new CapUserDetails(user.getUsername(), user.getPassword(), user.getEnabled()==1?true:false, true, true, true, authorities);
		StringBuilder sb= new StringBuilder();
		sb.append(user.getName());
		sb.append(Constantes.ESPACIO);
		sb.append(user.getPaterno());
		sb.append(Constantes.ESPACIO);
		sb.append(user.getMaterno());
		usuario.setNombreCompleto(sb.toString());
		usuario.setNombreUsuario(user.getName());
		usuario.setId(user.getId());
		usuario.setEmail(user.getEmail());
		
		return usuario ;
	}

}
