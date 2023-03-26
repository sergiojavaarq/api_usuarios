package br.com.cotiinformatica.domain.services;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.domain.interfaces.UsuarioDomainService;
import br.com.cotiinformatica.domain.models.Usuario;
import br.com.cotiinformatica.infrastructure.components.MD5Component;
import br.com.cotiinformatica.infrastructure.repositories.UsuarioRepository;

@Service
public class UsuarioDomainServiceImpl implements UsuarioDomainService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private MD5Component md5Component;

	@Override
	public void criarConta(Usuario usuario) {

		Optional<Usuario> optional = usuarioRepository.findByEmail(usuario.getEmail());
		if (optional.isPresent()) {
			throw new IllegalArgumentException("O email informado já está cadastrado.");
		}

		usuario.setSenha(md5Component.encrypt(usuario.getSenha()));

		usuario.setDataHoraCriacao(Instant.now());
		usuario.setDataHoraUltimaAlteracao(Instant.now());

		usuarioRepository.save(usuario);
	}

}
