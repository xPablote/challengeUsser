package com.api.rest.services;

import com.api.rest.models.repository.IUsuarioRepository;
import com.api.rest.models.entity.Usuario;
import com.api.rest.models.validator.PassValidator;
import com.api.rest.models.validator.PasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Override
    public Usuario save(Usuario usuario) throws PasswordException {
        LocalDateTime localDateTime = LocalDateTime.now();
        Optional<Usuario> existingUser = usuarioRepository.findByEmail(usuario.getEmail());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("el email esta registrado");
        }
        PassValidator passValidator = new PassValidator();
        if (!passValidator.isValid(usuario.getPassword())) {
            throw new PasswordException(usuario.getPassword());
        }
        usuario.setCreationDate(localDateTime);
        usuario.setLastUpdate(localDateTime);
        usuario.setLastLogin(localDateTime);
        usuario.setActive(true);
        return usuarioRepository.save(usuario);

    }

}
