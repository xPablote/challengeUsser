package com.api.rest.services;

import com.api.rest.models.entity.Usuario;
import com.api.rest.models.validator.PasswordException;

public interface IUsuarioService {
    public Usuario save(Usuario usuario) throws PasswordException;
}
