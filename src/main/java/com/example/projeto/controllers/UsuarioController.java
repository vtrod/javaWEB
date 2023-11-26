package com.example.projeto.controllers;

import com.example.projeto.models.Usuario;
import com.example.projeto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/cadastro")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuariocadastro";
    }

    @PostMapping("/cadastro")
    public String processarFormulario(@ModelAttribute Usuario usuario) {
        usuarioService.salvarUsuario(usuario);
        return "redirect:/usuario/cadastro";
    }
}

    //@GetMapping
    //public List<Usuario> getAllUsuarios() {
    //    return usuarioService.getAllUsuarios();
    //}

    //@GetMapping("/{id}")
    //public Usuario getUsuarioById(@PathVariable Long id) {
    //    return usuarioService.getUsuarioById(id);
    //}

    //@PostMapping
    //public Usuario salvarUsuario(@RequestBody Usuario usuario) {
    //    return usuarioService.salvarUsuario(usuario);
    //}

    //@DeleteMapping("/{id}")
    //public void deletarUsuario(@PathVariable Long id) {
    //    usuarioService.deletarUsuario(id);
    //}
