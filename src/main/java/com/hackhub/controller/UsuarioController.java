package com.hackhub.controller;

import com.hackhub.DTO.UsuarioDTO.AutenticarUsuarioDTO;
import com.hackhub.DTO.UsuarioDTO.DetalleUsuarioDTO;
import com.hackhub.DTO.UsuarioDTO.RegistrarUsuarioDTO;
import com.hackhub.DTO.tokenDTO.DatosJWTtoken;
import com.hackhub.persistence.model.Usuario;
import com.hackhub.service.implementation.TokenService;
import com.hackhub.service.interfaces.IUsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity autenticarUsuario(@RequestBody @Valid AutenticarUsuarioDTO autenticarUsuarioDTO){
        Authentication authToken = new UsernamePasswordAuthenticationToken(autenticarUsuarioDTO.correoElectronico(),
                autenticarUsuarioDTO.contrasenia());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTtoken(JWTtoken));
    }

    @PostMapping
    public ResponseEntity registrarUsuario(@RequestBody @Valid RegistrarUsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.cambiarRegistroUsuarioDTO(usuarioDTO);
        usuarioService.save(usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<DetalleUsuarioDTO>> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.findAll().stream().map(DetalleUsuarioDTO::new).toList());
    }
}
