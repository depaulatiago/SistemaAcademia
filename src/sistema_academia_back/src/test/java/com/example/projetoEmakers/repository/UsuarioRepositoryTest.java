package com.example.projetoEmakers.repository;

import com.example.projetoEmakers.data.entity.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeEach
    public void setUp() {
        // Insira um usuário de teste antes de cada execução de teste
        Usuario usuario = new Usuario();
        usuario.setEmail("email@exemplo.com");
        usuario.setSenha("senha123");
        usuarioRepository.save(usuario);
    }

    @Test
    public void testFindByEmail() {
        Usuario usuario = usuarioRepository.findByEmail("email@exemplo.com");
        assertNotNull(usuario);  // Agora o teste deve passar, já que o usuário foi inserido
    }
}
