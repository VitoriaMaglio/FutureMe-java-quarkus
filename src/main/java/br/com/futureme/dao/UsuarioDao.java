package br.com.futureme.dao;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import javax.sql.DataSource;

@ApplicationScoped
public class UsuarioDao {
    @Inject
    DataSource dataSource;//objeto de conexão com o banco de dados, garante uma única instância
}
