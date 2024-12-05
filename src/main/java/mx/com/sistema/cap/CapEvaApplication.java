package mx.com.sistema.cap;

import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class CapEvaApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(CapEvaApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CapEvaApplication.class);
	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
        FacesServlet servlet = new FacesServlet();
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(servlet, "*.jsf");
		return servletRegistrationBean;
    }


	  @Bean
	  public ServletContextInitializer servletContextInitializer() {
	    return servletContext -> {
	        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
	        servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", Boolean.TRUE.toString());
	        servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", Boolean.TRUE.toString());
	        servletContext.setInitParameter("primefaces.FONT_AWESOME", Boolean.TRUE.toString());
	        servletContext.setInitParameter("javax.faces.ENABLE_CDI_RESOLVER_CHAIN", Boolean.TRUE.toString());
	        servletContext.setInitParameter("primefaces.UPLOADER", "commons");
	        servletContext.setInitParameter("javax.faces.STATE_SAVING_METHOD", "client");
	        servletContext.setInitParameter("javax.faces.DATETIMECONVERTER_DEFAULT_TIMEZONE_IS_SYSTEM_TIMEZONE", Boolean.TRUE.toString());
	        servletContext.setInitParameter("javax.faces.FACELETS_LIBRARIES", "/WEB-INF/custom-taglib.xml");

	      };
	  }   
	      


	//for setting fileUploadFilter to in front of filterChain - so uploaded file not consumed by other filter
	  @Bean
	  public FilterRegistrationBean primeFacesFileUploadFilter() {

	     FilterRegistrationBean registration = new FilterRegistrationBean(new org.primefaces.webapp.filter.FileUploadFilter(), servletRegistrationBean());
	    
	     registration.addUrlPatterns("/*"); 
	    
	     registration.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD);
	     registration.setName("primeFacesFileUploadFilter");
	     registration.setOrder(1);
	     return registration;
	  }
	  
}
