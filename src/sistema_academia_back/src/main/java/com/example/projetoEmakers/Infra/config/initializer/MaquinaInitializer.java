package com.example.projetoEmakers.Infra.config.initializer;

import java.util.Date;
import com.example.projetoEmakers.data.entity.Maquina;
import com.example.projetoEmakers.repository.MaquinaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MaquinaInitializer {
    @Bean
    public CommandLineRunner initializeMaquina(MaquinaRepository maquinaRepository) {
        return args -> {
            //Criação de maquinaes iniciais
            Maquina maquina1 = new Maquina("LegPress", "Pernas", 200);
            Maquina maquina2 = new Maquina("Supino", "Peito", 150);

            //Salvando os maquinaes no banco de dados
            maquinaRepository.save(maquina1);
            maquinaRepository.save(maquina2);

            System.out.println("Maquinaes iniciais adicionados ao banco de dados.");
        };
    }
}
