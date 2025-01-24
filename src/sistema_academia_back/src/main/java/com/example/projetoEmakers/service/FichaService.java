package com.example.projetoEmakers.service;

import com.example.projetoEmakers.data.dto.request.FichaRequestDTO;
import com.example.projetoEmakers.data.dto.response.FichaResponseDTO;
import com.example.projetoEmakers.data.entity.Aluno;
import com.example.projetoEmakers.data.entity.Ficha;
import com.example.projetoEmakers.data.entity.Instrutor;
import com.example.projetoEmakers.data.entity.Maquina;
import com.example.projetoEmakers.repository.AlunoRepository;
import com.example.projetoEmakers.repository.FichaRepository;
import com.example.projetoEmakers.repository.InstrutorRepository;
import com.example.projetoEmakers.repository.MaquinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FichaService {

    @Autowired
    private FichaRepository fichaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private InstrutorRepository instrutorRepository;

    @Autowired
    private MaquinaRepository maquinaRepository;

    // Criar Ficha
    public Ficha criarFicha(FichaRequestDTO requestDTO) {
        // Validar Aluno
        Aluno aluno = alunoRepository.findById(requestDTO.idAluno())
                .orElseThrow(() -> new IllegalArgumentException("Aluno com ID " + requestDTO.idAluno() + " não encontrado"));

        // Validar Instrutor
        Instrutor instrutor = instrutorRepository.findById(requestDTO.idInstrutor())
                .orElseThrow(() -> new IllegalArgumentException("Instrutor com ID " + requestDTO.idInstrutor() + " não encontrado"));

        // Validar Máquinas
        List<Maquina> maquinas = maquinaRepository.findAllById(requestDTO.idsMaquinas());
        if (maquinas.size() != requestDTO.idsMaquinas().size()) {
            throw new IllegalArgumentException("Alguns IDs de máquinas fornecidos não foram encontrados");
        }

        // Criar nova ficha
        Ficha ficha = new Ficha();
        ficha.setAluno(aluno);
        ficha.setInstrutor(instrutor);
        ficha.setMaquinas(maquinas);

        return fichaRepository.save(ficha);
    }


    // Consultar Ficha
    public FichaResponseDTO consultarFicha(Long id) {
        // Validar existência da Ficha
        Optional<Ficha> fichaOptional = fichaRepository.findById(id);
        if (fichaOptional.isEmpty()) {
            throw new IllegalArgumentException("Ficha com ID " + id + " não encontrada");
        }

        // Mapear dados da Ficha para o ResponseDTO
        Ficha ficha = fichaOptional.get();
        return new FichaResponseDTO(
                ficha.getAluno().getIdAluno(),
                ficha.getAluno().getNome(),
                ficha.getInstrutor().getIdInst(),
                ficha.getInstrutor().getNome(),
                ficha.getMaquinas().stream().map(Maquina::getIdMaq).collect(Collectors.toList()),
                ficha.getMaquinas().stream().map(Maquina::getNome).collect(Collectors.toList()),
                ficha.getMaquinas().stream().map(Maquina::getCategoria).collect(Collectors.toList())
        );
    }

    public Ficha atualizarFicha(Long id, FichaRequestDTO requestDTO) {
        // Verifica se a ficha existe
        Ficha ficha = fichaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ficha com ID " + id + " não encontrada"));

        // Atualizar Aluno
        Aluno aluno = alunoRepository.findById(requestDTO.idAluno())
                .orElseThrow(() -> new IllegalArgumentException("Aluno com ID " + requestDTO.idAluno() + " não encontrado"));
        ficha.setAluno(aluno);

        // Atualizar Instrutor
        Instrutor instrutor = instrutorRepository.findById(requestDTO.idInstrutor())
                .orElseThrow(() -> new IllegalArgumentException("Instrutor com ID " + requestDTO.idInstrutor() + " não encontrado"));
        ficha.setInstrutor(instrutor);

        // Atualizar Máquinas
        List<Maquina> maquinas = maquinaRepository.findAllById(requestDTO.idsMaquinas());
        if (maquinas.size() != requestDTO.idsMaquinas().size()) {
            throw new IllegalArgumentException("Alguns IDs de máquinas fornecidos não foram encontrados");
        }
        ficha.setMaquinas(maquinas);

        // Salva as mudanças
        return fichaRepository.save(ficha);
    }

    public void deletarFicha(Long id) {
        fichaRepository.deleteById(id);
    }

    public List<Ficha> listarTodasAsFichas() {
        return fichaRepository.findAll();
    }
}
