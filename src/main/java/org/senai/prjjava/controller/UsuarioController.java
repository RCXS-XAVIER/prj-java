package org.senai.prjjava.controller;

import java.util.Optional;

import org.senai.prjjava.entity.Usuario;
import org.senai.prjjava.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// http://localhost:8080/api/usuario/add?nome=Raquel&email=raquel.c.santos@aluno.senai.br -- nesse exemplo são usadas váriaveis de parametro chave=valor

@Controller
@RequestMapping(path = "/api/usuario")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    UsuarioRepository uRepository;

    /**
     * @param nome
     * @param email
     * @return
     */
    @PostMapping("/add")
    public @ResponseBody String addUsuario(
            @RequestParam String nome,
            @RequestParam String email) {
        Usuario objU = new Usuario();
        objU.setNome(nome);
        objU.setEmail(email);

        uRepository.save(objU);
        return "Salvo";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Usuario> buscarUsuarios() {
        return uRepository.findAll();
    }
}

// https//:raquel-qua209050.herokuapp.com/api/usuario/
