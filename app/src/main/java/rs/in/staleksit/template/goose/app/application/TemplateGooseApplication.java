package rs.in.staleksit.template.goose.app.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import rs.in.staleksit.template.goose.app.config.TemplateGooseConfig;

@Import({TemplateGooseConfig.class})
@SpringBootApplication
public class TemplateGooseApplication {

  public static void main(String[] args) {
    SpringApplication.run(TemplateGooseApplication.class, args);
  }
}
