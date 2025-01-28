package com.example.projetoEmakers.Infra.config.initializer;

import com.example.projetoEmakers.data.entity.Instrutor;
import com.example.projetoEmakers.repository.InstrutorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class instrutorInitializer {
    @Bean
    public CommandLineRunner initializeInstrutores(InstrutorRepository instrutorRepository) {
        return args -> {
            //Criação de instrutores iniciais
            Instrutor instrutor1 = new Instrutor("Rafael", 30, 2000 );
            Instrutor instrutor2 = new Instrutor("Vinicius", 25, 1500 );

            //Salvando os instrutores no banco de dados
            instrutorRepository.save(instrutor1);
            instrutorRepository.save(instrutor2);

            System.out.println("Instrutores iniciais adicionados ao banco de dados.");
        };
    }
}
