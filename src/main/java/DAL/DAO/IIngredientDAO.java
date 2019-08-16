package DAL.DAO;

import DAL.DTO.IIngredientDTO;

import java.sql.Connection;

public interface IIngredientDAO {

    void createIngredient(Connection connection, IIngredientDTO ingredientDTO);
    IIngredientDTO getIngredient(Connection connection, int ID);
    void updateIngredient(Connection connection, IIngredientDTO ingredientDTO);
    void deleteIngredient(Connection connection, int ID);
}
