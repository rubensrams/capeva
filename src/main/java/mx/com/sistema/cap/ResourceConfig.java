package mx.com.sistema.cap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@PropertySource({
    "classpath:application-dev.properties",
    "classpath:application-prod.properties"
})
public class ResourceConfig implements WebMvcConfigurer{

	@Value("${ruta.carga.logos.resource}")
	private String EXTERNAL_RESOURCE_LOGOS;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		
		registry.addResourceHandler("/logos/**")
		.addResourceLocations(EXTERNAL_RESOURCE_LOGOS);
	}

}
