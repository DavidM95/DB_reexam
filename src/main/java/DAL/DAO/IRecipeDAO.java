package DAL.DAO;

import DAL.DTO.IRecipeDTO;

import java.sql.Connection;

public interface IRecipeDAO {

    void createRecipe(Connection connection, IRecipeDTO recipeDTO);
    IRecipeDTO getRecipe(Connection connection, int ID);
    void updateRecipe(Connection connection, IRecipeDTO recipeDTO);
    void deleteRecipe(Connection connection, int ID);
}
