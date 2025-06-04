package biblioteca.salas.duoc.biblioteca.salas.duoc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    
    @Bean
    public OpenAPI customAPI(){
        return new OpenAPI().info(new Info().title("API 2025 Reservas de salas").version("1.0").description("Documentacion de la API para el sistema de reserva de salas"));
    }
}
