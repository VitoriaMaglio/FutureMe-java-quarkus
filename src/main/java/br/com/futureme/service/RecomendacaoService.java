package br.com.futureme.service;


import br.com.futureme.dao.RecomendacaoDao;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.sql.SQLException;

@ApplicationScoped
public class RecomendacaoService {

    @Inject
    RecomendacaoDao recomendacaoDao;

    public String buscarRecomendacaoPorProfissao(String nome) throws SQLException {
        return recomendacaoDao.buscarRecomendacaoPorIdProfissao(nome);
    }
    }
