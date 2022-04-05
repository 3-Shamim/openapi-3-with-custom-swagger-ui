package com.learningstuff.springbootopenapi3;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.ServerVariable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(title = "Employees API", version = "1.0.0", description = "Employees Information"),
        security = {
                @SecurityRequirement(name = "basic-security"),
                @SecurityRequirement(name = "bearer-security"),
                @SecurityRequirement(name = "api-key"),
                @SecurityRequirement(name = "x-token")
        }, // For root label.
        servers = {
                @Server(url = "http://localhost:8080", description = "Basic base url."),
                @Server(
                        url = "{custom-server}",
                        variables = {@ServerVariable(name = "custom-server", defaultValue = "http://localhost:8080")},
                        description = "Customer url can be applied."
                )
        }
)
@SecurityScheme(name = "basic-security", scheme = "basic", type = SecuritySchemeType.HTTP)
@SecurityScheme(name = "bearer-security", scheme = "bearer", type = SecuritySchemeType.HTTP)
@SecurityScheme(name = "api-key", type = SecuritySchemeType.APIKEY, in = SecuritySchemeIn.HEADER)
@SecurityScheme(name = "x-token", type = SecuritySchemeType.APIKEY, in = SecuritySchemeIn.HEADER)
@SpringBootApplication
public class SpringBootOpenApi3Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootOpenApi3Application.class, args);
    }

}
