package pl.coderslab.DrinkApp.entity.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CocktailDto {

    private String drinkName;

    @Override
    public String toString() {
        return drinkName;
    }
}
