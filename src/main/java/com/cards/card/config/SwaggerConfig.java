package com.cards.card.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	private static final String BASE_PACKAGE = "com.cards.card";
	private static final String PARAMETER_TYPE_HEADER = "header";
	private static final String MODEL_REF_STRING = "string";

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
				.paths(PathSelectors.regex("/.*")).build().apiInfo(apiEndPointsInfo())
				.globalOperationParameters(parameters());
	}

	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title("Card Service").description("Card Service REST API").license("Apache 2.0")
				.version("1.0.0").build();
	}

	private List<Parameter> parameters() {
		Parameter language = parameter("Accept-Language", PARAMETER_TYPE_HEADER, MODEL_REF_STRING, "en-US", false);
		Parameter authorization = parameter("Authorization", PARAMETER_TYPE_HEADER, MODEL_REF_STRING, "Basic Y2FyZHNhcGlkZXY6V2VsY29tZUAxMjM=", true);
                Parameter userId = parameter("userId", PARAMETER_TYPE_HEADER, MODEL_REF_STRING, "", true);
                
		return List.of(language, authorization, userId);
	}

	private Parameter parameter(String name, String type, String modelRef, String defaultValue, boolean required) {
		ParameterBuilder parameters = new ParameterBuilder();
		parameters.name(name) // name of header
				.modelRef(new ModelRef(modelRef)).parameterType(type) // type - header
				.defaultValue(defaultValue)
				.required(required) // for compulsory
				.build();
		return parameters.build();
	}
}
