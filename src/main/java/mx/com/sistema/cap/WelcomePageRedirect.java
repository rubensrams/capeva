package mx.com.sistema.cap;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WelcomePageRedirect implements WebMvcConfigurer{

	@Override
	  public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addViewController("/").setViewName("forward:/index.jsf");
	    registry.addViewController("/notFound").setViewName("forward:/pages/error/404.jsf");
	    registry.addViewController("/error").setViewName("forward:/pages/error/500.jsf");
	    registry.addViewController("/forbidden").setViewName("forward:/pages/error/403.jsf");
	    
	    registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	  }
	
	@Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> containerCustomizer() {
	    return container -> {
	        container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/notFound"));
	        container.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN,"/forbidden"));
	        container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/error"));
	        
	    };
	  }

}
