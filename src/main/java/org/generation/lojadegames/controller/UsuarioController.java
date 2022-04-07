package org.generation.lojadegames.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.generation.lojadegames.model.Usuario;
import org.generation.lojadegames.model.UsuarioLogin;
import org.generation.lojadegames.repository.UsuarioRepository;
import org.generation.lojadegames.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(originPatterns = "*", allowedHeaders = "*")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioService usuarioService;

	// MÉTODOS
	@GetMapping("/all") // segurança
	public ResponseEntity<List<Usuario>> getAll() {
		return ResponseEntity.ok(usuarioRepository.findAll());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> cadastraUsuario(@Valid @RequestBody Usuario usuario) {
		return usuarioService.cadastrarUsuario(usuario)
				.map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}

	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> autenticaUsuario(@Valid @RequestBody Optional<UsuarioLogin> usuarioL) {
		return usuarioService.autenticarUsuario(usuarioL)
				.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
}
