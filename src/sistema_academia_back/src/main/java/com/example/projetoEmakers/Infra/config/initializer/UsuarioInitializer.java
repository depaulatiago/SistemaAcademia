package com.example.projetoEmakers.Infra.config.initializer;


import com.example.projetoEmakers.data.entity.Usuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.projetoEmakers.repository.UsuarioRepository;

@Configuration
public class UsuarioInitializer {

    @Bean
    public CommandLineRunner initializeUsuarios(UsuarioRepository usuarioRepository) {
        return args -> {
            // Criação de usuários iniciais
            Usuario usuario1 = new Usuario("admin@example.com", "admin123");
            Usuario usuario2 = new Usuario("user@example.com", "user123");

            // Salvando os usuários no banco de dados
            usuarioRepository.save(usuario1);
            usuarioRepository.save(usuario2);

            System.out.println("Usuários iniciais adicionados ao banco de dados.");
        };
    }
}
