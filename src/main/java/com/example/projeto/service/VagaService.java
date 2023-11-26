package com.example.projeto.service;

import com.example.projeto.models.Vaga;
import com.example.projeto.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    public List<Vaga> obterTodasVagas() {
        return vagaRepository.findAll();
    }

    public Vaga obterVagaPorId(Long id) {
        return vagaRepository.findById(id).orElse(null);
    }

    public Vaga salvarVaga(Vaga vaga) {
        return vagaRepository.save(vaga);
    }

    public void deletarVaga(Long id) {
        vagaRepository.deleteById(id);
    }
}
