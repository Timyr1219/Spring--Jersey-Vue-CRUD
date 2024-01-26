package com.example.demo.config;

import com.example.demo.resource.ProductStatusResource;
import com.example.demo.resource.ProductTypeResource;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("com.example.demo.resource");
        register(ProductTypeResource.class);
        register(ProductStatusResource.class);
    }
}
