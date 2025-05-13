package spring_web_api.configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private Contact contact(){
        return new Contact(
            "Dio - API Java/Spring Boot com Swagger",
                "localhost:8080",
                "email@email.com"
        );
    }

    private ApiInfoBuilder apiInfo(){

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Dio - Rest API");
        apiInfoBuilder.description("Dio - Exemplo de uso de Spring boot REST API");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.license("Open Source");
        apiInfoBuilder.licenseUrl("None");
        apiInfoBuilder.contact(this.contact());

        return apiInfoBuilder;
    }

    public Docket apiDetail(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
                .select()
                .apis(RequestHandlerSelectors.basePackage("spring_web_api.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.apiInfo().build())
                .consumes(new HashSet<String>(Arrays.asList("application/json")))
                .produces(new HashSet<String>(Arrays.asList("application/json")));


        return docket;
    }

}
