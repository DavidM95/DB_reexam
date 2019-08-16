import DAL.Connect;
import DAL.DAO.*;
import DAL.DTO.*;
import DAL.IConnect;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws SQLException {

        IConnect connect = new Connect();

        IIngredientDAO ingredientDAO = new IngredientDAO();
        IUserDAO userDAO = new UserDAO();
        IRessourceDAO ressourceDAO = new RessourceDAO();
        IRecipeDAO recipeDAO = new RecipeDAO();
  //      IProduktionDAO produktionDAO = new ProduktionDAO();

        IIngredientDTO ingredientDTO;
        IUserDTO userDTO;
 //       IProduktionDTO produktionDTO;
        IRecipeDTO recipeDTO;
        IRessourceDTO ressourceDTO;

        connect.createConnection();

        ArrayList<String> laborant = new ArrayList<String>();
        laborant.add("Laborant");

        ArrayList<String> produktionsleder = new ArrayList<String>();
        produktionsleder.add("Produktionsleder");

        ArrayList<String> farmaceut = new ArrayList<String>();
        farmaceut.add("Farmaceut");

        Date date = new Date();
        Date enddate = new Date();

        userDAO.createUser(connect.getConnection(),userDTO = new UserDTO(1,"David",true,laborant));
        userDAO.createUser(connect.getConnection(),userDTO = new UserDTO(2,"Pete",true,produktionsleder));
        userDAO.createUser(connect.getConnection(),userDTO = new UserDTO(3,"Matt",false,farmaceut));

        recipeDAO.createRecipe(connect.getConnection(),recipeDTO = new RecipeDTO(1,"Sovemedicin",3));
        recipeDAO.createRecipe(connect.getConnection(),recipeDTO = new RecipeDTO(2,"Painkillers",3));
        ingredientDAO.createIngredient(connect.getConnection(),ingredientDTO = new IngredientDTO(1,"Carbon",4,1));
        ingredientDAO.createIngredient(connect.getConnection(),ingredientDTO = new IngredientDTO(2,"salt",5,2));
        ressourceDAO.createRessource(connect.getConnection(),ressourceDTO = new RessourceDTO(1,1,"Hydrogen",1,false));
        //   produktionDAO.createProduktion(connect.getConnection(),produktionDTO = new ProduktionDTO(1,20000,"i gang",2,recipeDTO.getOpskriftID(), date,enddate));

        System.out.println(userDAO.getUser(connect.getConnection(),1).getUsername());
        System.out.println(recipeDAO.getRecipe(connect.getConnection(),1));
        System.out.println(ingredientDAO.getIngredient(connect.getConnection(),1).getIngredientID());
        ressourceDAO.getRessource(connect.getConnection(),1);
        //    produktionDAO.getProduktion(connect.getConnection(),1);

        userDAO.updateUser(connect.getConnection(),userDTO = new UserDTO(1,"Frank",false,laborant));
        recipeDAO.updateRecipe(connect.getConnection(),recipeDTO = new RecipeDTO(1,"Sovemedicin",3));
        ingredientDAO.updateIngredient(connect.getConnection(),ingredientDTO = new IngredientDTO(1,"CarbonDioxid",540,1));
        ressourceDAO.updateRessource(connect.getConnection(),ressourceDTO = new RessourceDTO(1,2,"Kviksølv",4,false));
        //    produktionDAO.updateProduktion(connect.getConnection(),produktionDTO = new ProduktionDTO(1,20,"igang",2,1,date,enddate));


        //     produktionDAO.endProduktion(connect.getConnection(),produktionDTO = new ProduktionDTO(1,20000,"Færdig",2,1,date,enddate));

        userDAO.getUser(connect.getConnection(),1);
        recipeDAO.getRecipe(connect.getConnection(),1);
        ingredientDAO.getIngredient(connect.getConnection(),1);
        ressourceDAO.getRessource(connect.getConnection(),1);
        //    produktionDAO.getProduktion(connect.getConnection(),1);

        userDAO.deleteUser(connect.getConnection(),1);
        ressourceDAO.deleteRessource(connect.getConnection(),1);
        ingredientDAO.deleteIngredient(connect.getConnection(),1);
        recipeDAO.deleteRecipe(connect.getConnection(),1);


        connect.closeConnection();
    }
}
