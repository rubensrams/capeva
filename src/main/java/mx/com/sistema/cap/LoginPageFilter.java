package mx.com.sistema.cap;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import mx.com.sistema.cap.dto.UsuarioDTO;

public class LoginPageFilter extends GenericFilterBean{

	@Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
	    HttpServletRequest req = (HttpServletRequest) request;
	    UsuarioDTO login = (UsuarioDTO) req.getSession().getAttribute("userSession");	    
	    String path = req.getRequestURI().substring(req.getContextPath().length());
	    if (path.contains("/pages/")) {
		    System.out.println("path:" + path);
	        if (login != null) {
	            if (login.getUsername() != null && !login.getUsername().equals("")) {
	                chain.doFilter(request, response);
	            } else {
	                HttpServletResponse res = (HttpServletResponse) response;
	                System.out.println("Redireccionanado a capeva 1");
	                res.sendRedirect("/Capeva/logout");
	            }
	        } else {
	            HttpServletResponse res = (HttpServletResponse) response;
	            System.out.println("Redireccionanado a capeva 2");
	            res.sendRedirect("/Capeva/logout");
	        }

	    } else {
	        chain.doFilter(request, response);
	    }
    }

	
}

