package DAL.DAO;

import DAL.DTO.IRessourceDTO;
import DAL.DTO.RessourceDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RessourceDAO implements IRessourceDAO {

    public void createRessource(Connection connection, IRessourceDTO ressourceDTO) {
        try {
            PreparedStatement prep = connection.prepareStatement("INSERT into Ressources values(?,?,?,?,?);");

            prep.setInt(1, ressourceDTO.getProductionID());
            prep.setInt(2, ressourceDTO.getIngredientID());
            prep.setString(3, ressourceDTO.getRessourceName());
            prep.setInt(4, ressourceDTO.getAmount());
            prep.setBoolean(5, ressourceDTO.getReorder());

            prep.execute();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public RessourceDTO getRessource(Connection connection, int ID) {
        try {
            PreparedStatement prep = connection.prepareStatement("SELECT * FROM Ressources WHERE ingredient_id = ?;");

            prep.setInt(1, ID);

            ResultSet resultSet = prep.executeQuery();

            RessourceDTO ressourceDTO = null;

            while (resultSet.next()){
                ressourceDTO = new RessourceDTO(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getBoolean(5));
            }

            return ressourceDTO;

        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public void updateRessource(Connection connection, IRessourceDTO ressourceDTO) {
        try {
            PreparedStatement prep = connection.prepareStatement("UPDATE Ressources SET production_id = ?, ingredient_id = ?, ressource_name = ?, amount = ?, reorder = ? WHERE ingredient_id = ?;");

            prep.setInt(1, ressourceDTO.getProductionID());
            prep.setInt(2, ressourceDTO.getIngredientID());
            prep.setString(3, ressourceDTO.getRessourceName());
            prep.setInt(4, ressourceDTO.getAmount());
            prep.setBoolean(5, ressourceDTO.getReorder());
            prep.setInt(6, ressourceDTO.getIngredientID());

            prep.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteRessource(Connection connection, int ID) {
        try {
            PreparedStatement prep = connection.prepareStatement("DELETE from Ressources WHERE ingredient_id  = ?;");

            prep.setInt(1, ID);

            prep.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}
