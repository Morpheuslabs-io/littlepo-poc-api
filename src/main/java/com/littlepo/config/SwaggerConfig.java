package com.littlepo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	  @Bean
	  public Docket apiDocket() {
	      return new Docket(DocumentationType.SWAGGER_2)
	              .select()
	              .apis(RequestHandlerSelectors.any())
	              .paths(postPaths())
	              .build()
  		  		  .apiInfo(getApiInfo());
}
private ApiInfo getApiInfo() {
    return new ApiInfo(
            "Littlepo POC APIs",
            "These APIs are used in Littlepo POC",
            "V1.0",
            "",
            new Contact("Morpheus Labs","https://morpheuslabs.io","bruce@morpheuslabs.io"),
            "",
            "",
            Collections.emptyList()
    		);
}

	  
		private Predicate<String> postPaths() {
			return regex("/api/.*");
		}

}
