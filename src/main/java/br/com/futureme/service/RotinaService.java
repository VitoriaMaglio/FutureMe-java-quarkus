package br.com.futureme.service;
import br.com.futureme.dao.RotinaDao;
import br.com.futureme.dto.RotinaRequestDTO;
import br.com.futureme.dto.RotinaResponseDTO;
import br.com.futureme.model.Rotina;
import br.com.futureme.model.Usuario;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.sql.SQLException;
@ApplicationScoped
public class RotinaService {

    @Inject
    RotinaDao rotinaDao;

    public void cadastrarRotina(RotinaRequestDTO dto) throws SQLException {
        Rotina rotina = dto.convertToRotina(new Usuario());
        rotinaDao.cadastrarRotina(rotina);
    }

    public RotinaResponseDTO buscarRotina(String login) throws SQLException {
        Rotina rotina = rotinaDao.buscarRotina(login);
        if (rotina != null) {
            return new RotinaResponseDTO().convertToRotinaResponseDto(rotina);
        } else {
            throw new NullPointerException("Nenhuma rotina encontrada para o login informado!");
        }
    }

    public RotinaResponseDTO atualizarRotina(String login, RotinaRequestDTO dto) throws SQLException {
        rotinaDao.atualizarRotina(login, dto.getHorasSono(), dto.getHorasTrab(), dto.getPausasDiarias());
        return buscarRotina(login);
    }

    public void deletarRotina(String login) throws SQLException {
        rotinaDao.deletarRotina(login);
    }
}
