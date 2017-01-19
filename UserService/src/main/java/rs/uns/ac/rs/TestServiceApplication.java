package rs.uns.ac.rs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@EnableDiscoveryClient
@SpringBootApplication
public class TestServiceApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(TestServiceApplication.class, args);
	}
	
	
}

