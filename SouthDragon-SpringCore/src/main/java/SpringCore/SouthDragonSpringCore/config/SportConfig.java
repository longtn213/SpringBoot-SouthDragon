package SpringCore.SouthDragonSpringCore.config;

import SpringCore.SouthDragonSpringCore.Class.SwimCoach;
import SpringCore.SouthDragonSpringCore.Interface.Coach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
