package com.example.projetoEmakers.controller;

import com.example.projetoEmakers.data.entity.Usuario;
import com.example.projetoEmakers.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5500")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Listar todos os usuarioes
    @GetMapping
    public List<Usuario> getAllUsuario() {
        return usuarioRepository.findAll();
    }

    // Criar um novo usuario
    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Buscar um usuario pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        return usuarioRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Atualizar um usuario
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario updatedUsuario) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setEmail(updatedUsuario.getEmail());
                    usuario.setSenha(updatedUsuario.getSenha());
                    return ResponseEntity.ok(usuarioRepository.save(usuario));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Deletar um usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUsuario(@PathVariable Long id) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuarioRepository.delete(usuario);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {
        Usuario foundUsuario = usuarioRepository.findByEmail(usuario.getEmail());
        if (foundUsuario != null && foundUsuario.getSenha().equals(usuario.getSenha())) {
            return ResponseEntity.ok("Login bem-sucedido!");
        }
        return ResponseEntity.status(401).body("Credenciais inválidas.");
    }
}


