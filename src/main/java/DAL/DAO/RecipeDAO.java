package DAL.DAO;

import DAL.DTO.IRecipeDTO;
import DAL.DTO.RecipeDTO;

import java.sql.*;

public class RecipeDAO implements IRecipeDAO {
    public void createRecipe(Connection connection, IRecipeDTO recipeDTO) {
        try {
            PreparedStatement prep = connection.prepareStatement("INSERT into Recipes values(?,?,?);");


            prep.setInt(1, recipeDTO.getRecipeID());
            prep.setString(2, recipeDTO.getRecipeName());
            prep.setInt(3, recipeDTO.getUserID());

            prep.execute();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public IRecipeDTO getRecipe(Connection connection, int ID) {
        try {
            PreparedStatement prep = connection.prepareStatement("SELECT * FROM Recipes WHERE recipe_id = ?;");

            prep.setInt(1, ID);

            ResultSet resultSet = prep.executeQuery();

            IRecipeDTO recipeDTO = null;

            while (resultSet.next()){
                recipeDTO = new RecipeDTO(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
            }

            return recipeDTO;

        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public void updateRecipe(Connection connection, IRecipeDTO recipeDTO) {
        try {
            PreparedStatement prep = connection.prepareStatement("UPDATE Recipes SET recipe_id = ?, recipe_name = ?, user_id = ? WHERE recipe_id = ?;");

            prep.setInt(1, recipeDTO.getRecipeID());
            prep.setString(2, recipeDTO.getRecipeName());
            prep.setInt(3, recipeDTO.getUserID());
            prep.setInt(4, recipeDTO.getRecipeID());

            prep.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteRecipe(Connection connection, int ID) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE from Recipes WHERE recipe_id  = ?;");
            PreparedStatement ingredient = connection.prepareStatement("DELETE FROM Ingredients WHERE recipe_id = ?;");

            statement.setInt(1, ID);

            ingredient.setInt(1,ID);

            ingredient.execute();
            statement.execute();

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
