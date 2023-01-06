package ozi.library.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import ozi.library.entity.Book;

@Configuration
public class MyDataRestConfig {

    private String theAllowedOrigins = "http://localhost:3000";

    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] theUnsportedActions = { HttpMethod.POST, HttpMethod.PATCH, HttpMethod.PUT, HttpMethod.DELETE };

        config.exposeIdsFor(Book.class);

        disableHttpMethods(Book.class, config, theUnsportedActions);

        /* Configure CORS Mapping */
        cors.addMapping(config.getBasePath() + "/**")
                .allowedOrigins(theAllowedOrigins);
    }

    private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config,
            HttpMethod[] theUnsportedActions) {
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsportedActions));
    }
}
