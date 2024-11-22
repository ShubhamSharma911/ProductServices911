package dev.shubham911.productservices911.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration

public class RestTemplateConfig {
    @Bean
    public RestTemplate getRestTemplateConfig() {
        return new RestTemplate();
    }
}
