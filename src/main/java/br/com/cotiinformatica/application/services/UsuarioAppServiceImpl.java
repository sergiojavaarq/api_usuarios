package br.com.cotiinformatica.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.application.dtos.CriarContaDTO;
import br.com.cotiinformatica.application.dtos.CriarContaResponseDTO;
import br.com.cotiinformatica.application.interfaces.UsuarioAppService;
import br.com.cotiinformatica.domain.interfaces.UsuarioDomainService;

@Service
public class UsuarioAppServiceImpl implements UsuarioAppService {

	@Autowired
	private UsuarioDomainService usuarioDomainService;

	@Override
	public CriarContaResponseDTO criarConta(CriarContaDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
}
