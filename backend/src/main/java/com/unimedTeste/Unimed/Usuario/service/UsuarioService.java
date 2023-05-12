package com.unimedTeste.Unimed.Usuario.service;

import com.unimedTeste.Unimed.Usuario.entity.Usuario;
import com.unimedTeste.Unimed.Usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listaUsuario(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorLogin(String login){return usuarioRepository.findByLogin(login);}

}
