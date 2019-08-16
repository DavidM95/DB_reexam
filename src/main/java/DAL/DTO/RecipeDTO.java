package DAL.DTO;

import java.util.Date;

public class RecipeDTO implements IRecipeDTO {

    int recipeID;
    String recipename;
    int userID;

    public RecipeDTO(int recipeID, String recipeName, int userID){

        this.recipeID = recipeID;
        this.recipename = recipeName;
        this.userID = userID;

    }

    public int getRecipeID() {
        return this.recipeID;
    }

    public String getRecipeName() {
        return this.recipename;
    }

    public int getUserID() {
        return this.userID;
    }

    @Override
    public String toString() {
        return "RecipeDTO{" +
                "recipeID=" + recipeID +
                ", recipename='" + recipename + '\'' +
                ", userID=" + userID +
                '}';
    }
}
