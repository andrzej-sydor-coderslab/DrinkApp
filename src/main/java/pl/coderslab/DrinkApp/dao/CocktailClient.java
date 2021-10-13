package pl.coderslab.DrinkApp.dao;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.coderslab.DrinkApp.entity.dto.OpenCocktailMainDto;
import pl.coderslab.DrinkApp.entity.dto.OpenCocktailCocktailDto;
import pl.coderslab.DrinkApp.entity.dto.CocktailDto;


@Component
public class CocktailClient {

    private RestTemplate restTemplate = new RestTemplate();
    private static final String cocktails = "https://www.thecocktaildb.com/api/json/v1/1/";

    public String getCocktailByName(String drink){
        return restTemplate.getForObject(cocktails + "search.php?s={drink}"
        ,String.class, drink);
    }

    public CocktailDto getDrinkByName(String drink){
        OpenCocktailCocktailDto openCocktailCocktailDto = restTemplate.getForObject(cocktails
                + "search.php?s={drink}", OpenCocktailCocktailDto.class, drink);
        OpenCocktailMainDto[] array = openCocktailCocktailDto.getDrinks();
        OpenCocktailMainDto firstElement = array[0];

        return CocktailDto.builder()
                .drinkName(firstElement.toString())
                .build();
    }

    public String getRandomCocktail(){
        return restTemplate.getForObject(cocktails + "random.php"
        ,String.class);
    }
}
