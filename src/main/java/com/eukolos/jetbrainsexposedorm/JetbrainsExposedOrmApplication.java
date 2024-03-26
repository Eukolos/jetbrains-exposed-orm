package com.eukolos.jetbrainsexposedorm;

import com.eukolos.jetbrainsexposedorm.configuration.ExposedHints;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;

@ImportRuntimeHints(ExposedHints.class)
@SpringBootApplication
public class JetbrainsExposedOrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(JetbrainsExposedOrmApplication.class, args);
    }

}
