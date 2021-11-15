package com.refactorizando.example.naturaId;

import com.refactorizando.example.naturaId.repository.impl.NaturalRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = NaturalRepositoryImpl.class)
public class NaturaIdApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaturaIdApplication.class, args);
	}

}
