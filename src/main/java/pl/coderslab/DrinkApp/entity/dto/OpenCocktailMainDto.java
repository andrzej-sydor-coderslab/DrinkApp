package pl.coderslab.DrinkApp.entity.dto;

import lombok.Getter;

@Getter
public class OpenCocktailMainDto {

    private String strDrink;
    private String strInstructions;
    private String strIngredient1;
    private String strIngredient2;
    private String strIngredient3;
    private String strIngredient4;
    private String strIngredient5;
    private String strIngredient6;
    private String strIngredient7;

    @Override
    public String toString() {
        return strDrink + " : " + strInstructions + " " +
                "Ingredients: " + " " +
                strIngredient1 + " " + strIngredient2 + " " +
                strIngredient3 + " " + strIngredient4 + " "
                + strIngredient5 + " " + strIngredient6 + " " + strIngredient7;
    }
}
