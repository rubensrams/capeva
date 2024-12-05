package mx.com.sistema.cap;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class CacheFilter implements Filter {
	
	private static final Logger LOGGER = LogManager.getLogger(CacheFilter.class);
	 private static long maxAge = 86400 * 30; // 30 days in seconds
	 @Override
	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	            throws IOException, ServletException {
	        HttpServletResponse httpResponse = (HttpServletResponse) response;
	        String uri = ((HttpServletRequest) request).getRequestURI();
	        if (uri.contains(".js") || uri.contains(".css") || uri.contains(".svg") || uri.contains(".gif")
	                || uri.contains(".woff") || uri.contains(".png") || uri.contains(".jpg")  || uri.contains(".jpeg")) {
	            httpResponse.setHeader("Cache-Control", "max-age=" + maxAge);
	        }
	        chain.doFilter(request, response);
	    }

	    @Override
	    public void init(FilterConfig filterConfig) throws ServletException {
	    	LOGGER.info("Cache Filter started: ");

	    }


}
