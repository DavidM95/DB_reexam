package DAL.DAO;

import DAL.DTO.IIngredientDTO;
import DAL.DTO.IngredientDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IngredientDAO implements IIngredientDAO {

    public void createIngredient(Connection connection, IIngredientDTO ingredientDTO) {
        try {
            PreparedStatement prep = connection.prepareStatement("INSERT into Ingrediens values(?,?,?,?);");

            prep.setInt(1, ingredientDTO.getRecipeID());
            prep.setString(2, ingredientDTO.getIngredientName());
            prep.setInt(3, ingredientDTO.getIngredientID());
            prep.setInt(4, ingredientDTO.getAmount());

            prep.execute();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public IIngredientDTO getIngredient(Connection connection, int ID) {
        try {
            PreparedStatement prep = connection.prepareStatement("SELECT * FROM Ingrediens WHERE IngrediensID = ?;");

            prep.setInt(1, ID);

            ResultSet resultSet = prep.executeQuery();

            IIngredientDTO ingredientDTO = null;

            while (resultSet.next()){
                ingredientDTO = new IngredientDTO(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(4), resultSet.getInt(3));
            }

            return ingredientDTO;

        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public void updateIngredient(Connection connection, IIngredientDTO ingredientDTO) {
        try {
            PreparedStatement prep = connection.prepareStatement("UPDATE Ingrediens SET OpskriftID = ?, Ingrediensnavn = ?, IngrediensID = ?, Mængde = ? WHERE IngrediensID = ?;");

            prep.setInt(1, ingredientDTO.getRecipeID());
            prep.setString(2, ingredientDTO.getIngredientName());
            prep.setInt(3, ingredientDTO.getIngredientID());
            prep.setInt(4, ingredientDTO.getAmount());
            prep.setInt(5, ingredientDTO.getIngredientID());

            prep.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteIngredient(Connection connection, int ID) {
        try {
            PreparedStatement prep = connection.prepareStatement("DELETE from Ingrediens WHERE IngrediensID  = ?;");

            prep.setInt(1, ID);

            prep.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
