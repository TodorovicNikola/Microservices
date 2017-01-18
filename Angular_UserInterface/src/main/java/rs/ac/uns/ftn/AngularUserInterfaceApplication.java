package rs.ac.uns.ftn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AngularUserInterfaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngularUserInterfaceApplication.class, args);
	}
}
