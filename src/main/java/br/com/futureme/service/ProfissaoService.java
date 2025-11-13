package br.com.futureme.service;

import br.com.futureme.dao.ProfissaoDao;
import br.com.futureme.dto.ProfissaoRecomendacaoDTO;
import br.com.futureme.model.Usuario;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.sql.SQLException;
import java.util.List;
@ApplicationScoped
public class ProfissaoService {
    @Inject
    ProfissaoDao profissaoDao;

    public List<ProfissaoRecomendacaoDTO> gerarRecomendacoes(Usuario usuario) throws SQLException {
        String area = usuario.getAreaInteresseUsua();

        // teste rápido — remove se funcionar
        if (area == null || area.isBlank()) {
            System.out.println("⚠️ Nenhuma área recebida do usuário, forçando teste");
            area = "Educação e Tecnologia";
        }

        System.out.println("🟩 Buscando profissões da área: " + area);
        return profissaoDao.buscarProfissoesPorArea(area);
    }

}
