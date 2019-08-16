package DAL.DTO;

public class IngredientDTO implements IIngredientDTO {

    int recipeID;
    String ingredientName;
    int amount;
    int ingredientID;

    public IngredientDTO(int recipeID, String ingredientName, int amount, int ingredientID){

        this.recipeID = recipeID;
        this.ingredientName = ingredientName;
        this.amount = amount;
        this.ingredientID = ingredientID;

    }

    public int getRecipeID() {
        return this.recipeID;
    }

    public String getIngredientName() {
        return this.ingredientName;
    }

    public int getAmount() {
        return this.amount;
    }

    public int getIngredientID() {
        return this.ingredientID;
    }

    @Override
    public String toString() {
        return "IngredientDTO{" +
                "recipeID=" + recipeID +
                ", ingredientName='" + ingredientName + '\'' +
                ", amount=" + amount +
                ", ingredientID=" + ingredientID +
                '}';
    }
}
