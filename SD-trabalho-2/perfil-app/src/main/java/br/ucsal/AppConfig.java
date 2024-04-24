package br.ucsal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.ucsal.perfilapp.services.IProfileService;
import br.ucsal.perfilapp.services.ProfileService;

@Configuration
public class AppConfig {

    @Bean
    public IProfileService profileService() {
        return new ProfileService(); 
    }
}