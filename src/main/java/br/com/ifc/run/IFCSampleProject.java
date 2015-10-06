package br.com.ifc.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "br.com.ifc")
public class IFCSampleProject {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(IFCSampleProject.class, args);
	}

}