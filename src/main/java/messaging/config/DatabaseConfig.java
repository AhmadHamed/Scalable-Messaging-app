package messaging.config;

import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Path;

@Configuration
@EnableConfigurationProperties(DataStaxAstraProperties.class)
public class DatabaseConfig {

  @Bean
  public CqlSessionBuilderCustomizer cqlSessionBuilderCustomizer(
      DataStaxAstraProperties properties) {
    Path bundlePath = properties.getSecureConnectBundle().toPath();
    return cqlSessionBuilder -> cqlSessionBuilder.withCloudSecureConnectBundle(bundlePath);
  }
}
