package rs.in.staleksit.template.goose.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import rs.in.staleksit.template.goose.persistence.config.PersistenceConfig;

@Configuration
@Import({
        PersistenceConfig.class
})
public class TemplateGooseConfig {

}
