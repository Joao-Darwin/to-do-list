package projetopoo.demo.configs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Testando a configuração");
	}
	
}
