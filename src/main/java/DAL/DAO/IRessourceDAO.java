package DAL.DAO;

import DAL.DTO.IRessourceDTO;
import DAL.DTO.RessourceDTO;

import java.sql.Connection;

public interface IRessourceDAO {

    void createRessource(Connection connection, IRessourceDTO ressourceDTO);
    RessourceDTO getRessource(Connection connection, int ID);
    void updateRessource(Connection connection, IRessourceDTO ressourceDTO);
    void deleteRessource(Connection connection, int ID);
}
