package br.com.postech.health.med.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "br.com.postech.health.med.microservice" })
@EnableJpaRepositories(basePackages = "br.com.postech.health.med.microservice.repository")
public class HealthMedMicroserviceApplication {

  public static void main(String[] args) {
    SpringApplication.run(HealthMedMicroserviceApplication.class, args);
  }

}
