package br.com.futureme.service;

import br.com.futureme.dao.UsuarioDao;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped //indica que o objeto anotado terá um único clico de vida durante toda a execução, criando uma única instância ->CDI Contexts and Dependency Injection
public class UsuarioService {
    @Inject
    UsuarioDao usuarioDao;
}
