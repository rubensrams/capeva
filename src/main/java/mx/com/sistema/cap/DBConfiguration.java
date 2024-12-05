package mx.com.sistema.cap;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@SuppressWarnings("unused")
public class DBConfiguration {
	
	private String url;
	private String username;
	private String password;
	
	
	@Profile("dev")
	@Bean
	public String devDataBaseConnection() {
		return "DB CONNECTION FOR DEV MYSQL";
	}

	@Profile("prod")
	@Bean
	public String prodDataBaseConnection() {
		return "DB CONNECTION FOR PROD MYSQL";
	}

	
}
