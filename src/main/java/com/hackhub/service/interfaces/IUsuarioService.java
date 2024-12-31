package com.hackhub.service.interfaces;

import com.hackhub.DTO.UsuarioDTO.RegistrarUsuarioDTO;
import com.hackhub.persistence.model.Usuario;

public interface IUsuarioService {
    void save(Usuario usuario);
    void update(Usuario usuario);
    Usuario cambiarRegistroUsuarioDTO(RegistrarUsuarioDTO usuarioDTO);
//    Usuario findByCorreoElectronico(String correoElectronico);
}
