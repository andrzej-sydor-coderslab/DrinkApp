package pl.coderslab.DrinkApp.entity.dto;

import lombok.Getter;

@Getter
public class OpenCocktailMainDto {

    private String strDrink;
    private String strInstructions;

    @Override
    public String toString() {
        return strDrink + " : " + strInstructions;
    }
}
