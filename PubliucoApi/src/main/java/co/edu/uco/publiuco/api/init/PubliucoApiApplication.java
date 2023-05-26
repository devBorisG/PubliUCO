package co.edu.uco.publiuco.api.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.uco"})
@EnableJpaRepositories
public class PubliucoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PubliucoApiApplication.class, args);
	}

}
