package com.example.projeto.service;

import com.example.projeto.models.Funcionario;
import com.example.projeto.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService  {

    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {this.funcionarioRepository = funcionarioRepository;}

    public Funcionario salvarFuncionario(Funcionario funcionario) {return funcionarioRepository.save(funcionario);}

    public List<Funcionario> obterTodosFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Funcionario obterFuncionarioPorId(Long id) {
        Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(id);
        return optionalFuncionario.orElse(null);
        // Alternativamente, você pode lançar uma exceção ou tratar de outra forma se o funcionário não for encontrado.
    }

    public void excluirFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }
}