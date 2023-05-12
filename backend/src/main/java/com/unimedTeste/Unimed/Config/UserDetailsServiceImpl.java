//package com.unimedTeste.Unimed.Config;
//
//import com.unimedTeste.Unimed.Usuario.entity.Usuario;
//import com.unimedTeste.Unimed.Usuario.repository.UsuarioRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    final UsuarioRepository usuarioRepository;
//
//    public UserDetailsServiceImpl(UsuarioRepository usuarioRepository){
//        this.usuarioRepository = usuarioRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//        Usuario usuario = usuarioRepository.findByLogin(login)
//                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + login));
//        return null;
//    }
//}
