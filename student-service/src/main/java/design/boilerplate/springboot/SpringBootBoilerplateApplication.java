package design.boilerplate.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableJpaRepositories
@EnableFeignClients
@EnableEurekaClient
public class SpringBootBoilerplateApplication {

	@Value("${address.service.url}")
	private String addressUrl;

	public static void main(String[] args) {

		SpringApplication.run(SpringBootBoilerplateApplication.class, args);

	}

	@Bean
	WebClient webClient(){
		WebClient webClient = WebClient.builder()
				.baseUrl(addressUrl)
				.build();

		return webClient;
	}

}
