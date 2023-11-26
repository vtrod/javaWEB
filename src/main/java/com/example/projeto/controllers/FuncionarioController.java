package com.example.projeto.controllers;

import com.example.projeto.models.Funcionario;
import com.example.projeto.models.Usuario;
import com.example.projeto.models.Vaga;
import com.example.projeto.service.FuncionarioService;
import com.example.projeto.service.UsuarioService;
import com.example.projeto.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private VagaService vagaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/cadastro")
    public String mostrarFormulario(Model model) {
        List<Vaga> vaga = vagaService.obterTodasVagas();
        List<Usuario> usuario = usuarioService.getAllUsuarios();
        model.addAttribute("vaga", vaga);
        model.addAttribute("usuario", usuario);
        model.addAttribute("funcionario", new Funcionario());

        return "FuncionarioCadastro";
    }

    @PostMapping("/cadastro")
    public String processarFormulario(@ModelAttribute Funcionario funcionario, Model model) {
        // Obter o usuário selecionado
        Usuario usuarioSelecionado = usuarioService.getUsuarioById(funcionario.getUsuario().getId());

        // Verificar se a linguagem do usuário é igual à linguagem da vaga
        if (usuarioSelecionado != null && usuarioSelecionado.getLinguagem().equals(funcionario.getLinguagem())) {
            // Configurar a referência à chave estrangeira do usuário
            funcionario.setUsuario(usuarioSelecionado);

            // Configurar o nome do usuário no campo nome_func
            funcionario.setNome(usuarioSelecionado.getNome());


            // Lógica para salvar no banco de dados
            funcionarioService.salvarFuncionario(funcionario);

            return "redirect:/funcionarios/listagem";
        } else {
            // Lógica para lidar com a condição em que a linguagem não é igual à vaga
            model.addAttribute("mensagemErro", "Usuário não apto para essa vaga");
            List<Vaga> vagas = vagaService.obterTodasVagas();
            List<Usuario> usuarios = usuarioService.getAllUsuarios();
            model.addAttribute("vaga", vagas);
            model.addAttribute("usuario", usuarios);
            model.addAttribute("funcionario", new Funcionario());

            return "FuncionarioCadastro";
        }
    }
    @GetMapping("/listagem")
    public String listarFuncionarios(Model model) {
        List<Funcionario> funcionarios = funcionarioService.obterTodosFuncionarios();
        model.addAttribute("funcionarios", funcionarios);
        return "FuncionarioListagem";
    }

    @PostMapping("/excluir")
    public String excluirFuncionario(@ModelAttribute Funcionario funcionario) {
        funcionarioService.excluirFuncionario(funcionario.getId());
        return "redirect:/funcionarios/listagem";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable Long id, Model model) {
        // Lógica para obter o funcionário pelo ID
        Funcionario funcionario = funcionarioService.obterFuncionarioPorId(id);

        // Lógica para obter outras informações necessárias, como usuários e vagas
        List<Vaga> vagas = vagaService.obterTodasVagas();
        List<Usuario> usuarios = usuarioService.getAllUsuarios();

        model.addAttribute("vaga", vagas);
        model.addAttribute("usuario", usuarios);
        model.addAttribute("funcionario", funcionario);

        return "FuncionarioEditar";
    }
}