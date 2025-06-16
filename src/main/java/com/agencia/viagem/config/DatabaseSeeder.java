package com.agencia.viagem.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.agencia.viagem.model.Usuario;
import com.agencia.viagem.repository.UsuarioRepository;

@Configuration
public class DatabaseSeeder {

    @Bean
    public CommandLineRunner seedUsuarios(UsuarioRepository usuarioRepository, BCryptPasswordEncoder encoder) {
        return args -> {
            if (usuarioRepository.findByLogin("admin").isEmpty()) {
                usuarioRepository.save(new Usuario(null, "admin", encoder.encode("admin123"), "ADMIN"));
                System.out.println("Usuário admin criado.");
            }

            if (usuarioRepository.findByLogin("user").isEmpty()) {
                usuarioRepository.save(new Usuario(null, "user", encoder.encode("user123"), "USER"));
                System.out.println("Usuário user criado.");
            }
        };
    }
}
