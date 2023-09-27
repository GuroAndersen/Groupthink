package com.example.demo.Player;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlayerConfig {

    @Bean
    CommandLineRunner commandLineRunner(PlayerRepository repository) {
        return args -> {
            Player Ole = new Player(1L, "Ole", 0, null);
            Player Sara = new Player(2L, "Sara", 0, null);

            repository.saveAll(List.of(Ole, Sara));
        };
    }
}
