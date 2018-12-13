package com.littlepo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.littlepo.config.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
	FileStorageProperties.class
})
public class LittlepoPocApplication {


	public static void main(String[] args) {
		SpringApplication.run(LittlepoPocApplication.class, args);
	}
	

	
}
