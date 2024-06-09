package rs.in.staleksit.template.goose.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import rs.in.staleksit.template.goose.web.config.rest.RestControllerFactory;
import rs.in.staleksit.template.goose.web.config.rest.RestResourcesConfig;

@Configuration
@Import({
    RestResourcesConfig.class,
        RestControllerFactory.class
})
public class WebAdapterConfig {
    //
}
