package rs.ac.uns.ftn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CheckProgrammeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckProgrammeServiceApplication.class, args);
	}
}
