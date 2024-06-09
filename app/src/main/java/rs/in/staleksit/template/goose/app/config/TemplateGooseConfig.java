package rs.in.staleksit.template.goose.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import rs.in.staleksit.template.goose.persistence.config.PersistenceConfig;
import rs.in.staleksit.template.goose.web.config.WebAdapterConfig;

@Configuration
@Import({
        PersistenceConfig.class,
        WebAdapterConfig.class
})
public class TemplateGooseConfig {

}
