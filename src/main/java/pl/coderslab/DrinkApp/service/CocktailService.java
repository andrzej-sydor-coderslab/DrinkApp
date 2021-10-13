package pl.coderslab.DrinkApp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.coderslab.DrinkApp.dao.CocktailClient;
import pl.coderslab.DrinkApp.entity.dto.CocktailDto;

@Service
@Slf4j
@RequiredArgsConstructor
public class CocktailService {

private final CocktailClient cocktailClient;


    public String getCocktail(){
        return cocktailClient.getCocktailByName("margarita");
    }

    public CocktailDto getDrink(String drink){
        return cocktailClient.getDrinkByName(drink);
    }

    public String getRandomCocktail(){
        return cocktailClient.getRandomCocktail();
    }


}
