package com.api.rest.controllers;

import com.api.rest.models.error.ErrorResponse;
import com.api.rest.models.entity.Usuario;
import com.api.rest.services.IUsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class UsuarioRestController {

    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping("/create-usser")
    public ResponseEntity<?> creationUsser(@Valid @RequestBody Usuario useer, BindingResult result){
        ErrorResponse errorResponse = new ErrorResponse();
        Map<String, Object> response = new HashMap<>();
        Usuario usuario = null;
        if (result.hasErrors()) {
            List<String> errores = result.getFieldErrors().stream().map(error -> error.getField() + ": " +error.getDefaultMessage()).toList();
            errorResponse.setMensajes(errores);
            return ResponseEntity
                  .status(HttpStatus.CONFLICT)
                  .header("Content-Type", "application/json")
                  .body(errorResponse);
        }
        try {
            usuario = usuarioService.save(useer);
            response.put("mensaje", "Usuario creado correctamente");
            response.put("Usuario", usuario);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .header("Content-Type", "application/json")
                    .body(response);
        } catch (Exception e) {
            errorResponse.setMensajes(Collections.singletonList(e.getMessage()));
            return ResponseEntity
                   .status(HttpStatus.CONFLICT)
                   .header("Content-Type", "application/json")
                   .body(errorResponse);
        }
    }

}
