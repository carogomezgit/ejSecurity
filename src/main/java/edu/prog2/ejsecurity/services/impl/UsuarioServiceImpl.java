package edu.prog2.ejsecurity.services.impl;

import edu.prog2.ejsecurity.model.Usuario;
import edu.prog2.ejsecurity.repositories.UsuarioRepository;
import edu.prog2.ejsecurity.services.UsuarioService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {
  /// INYECCIÓN DE DEPENDENCIAS: AGREGO EL REPOSITORY
  private final UsuarioRepository usuarioRepository;

  UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return usuarioRepository.findByUsername(username)
        .orElseThrow(() ->
            new UsernameNotFoundException(
                "Usuario no encontrado: " + username));

  }
}
