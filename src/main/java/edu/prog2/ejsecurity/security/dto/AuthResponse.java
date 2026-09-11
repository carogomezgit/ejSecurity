package edu.prog2.ejsecurity.security.dto;

public record AuthResponse(
    // El token JWT que el cliente
    // debe guardar y enviar en cada petición
    String token

// Podés agregar más info:
// String username;
// List<String> roles;
) {
}
