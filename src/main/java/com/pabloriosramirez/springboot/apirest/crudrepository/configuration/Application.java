/**
 * @author Pablo Ríos Ramírez
 * @Created 28-06-2018 2:43:46
 * @web http://www.pabloriosramirez.com
 *
 */
package com.pabloriosramirez.springboot.apirest.crudrepository.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ServletComponentScan
@SpringBootApplication
@ComponentScan("com.pabloriosramirez.springboot.apirest.crudrepository")
@EnableJpaRepositories("com.pabloriosramirez.springboot.apirest.crudrepository.persistence.repository")
@EntityScan("com.pabloriosramirez.springboot.apirest.crudrepository.persistence.model")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
