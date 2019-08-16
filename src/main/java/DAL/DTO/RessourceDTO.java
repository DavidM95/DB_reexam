package DAL.DTO;

public class RessourceDTO implements IRessourceDTO{

    int productionID;
    int ingredientID;
    String ressourceName;
    int amount;
    boolean reorder;

    public RessourceDTO(int productionID, int ingredientID, String ressourceName, int amount, boolean reorder){

        this.productionID = productionID;
        this.ingredientID = ingredientID;
        this.ressourceName = ressourceName;
        this.reorder = reorder;
    }


    public int getProductionID() {
        return this.productionID;
    }

    public int getIngredientID() {
        return this.ingredientID;
    }

    public String getRessourceName() {
        return this.ressourceName;
    }

    public int getAmount() {
        return this.amount;
    }

    public boolean getReorder() {
        return this.reorder;
    }

    @Override
    public String toString() {
        return "RessourceDTO{" +
                "productionID=" + productionID +
                ", ingredientID=" + ingredientID +
                ", ressourceName='" + ressourceName + '\'' +
                ", amount=" + amount +
                ", reorder=" + reorder +
                '}';
    }
}