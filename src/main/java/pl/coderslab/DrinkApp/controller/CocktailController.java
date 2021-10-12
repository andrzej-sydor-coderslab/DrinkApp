package pl.coderslab.DrinkApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.DrinkApp.entity.dto.CocktailDto;
import pl.coderslab.DrinkApp.service.CocktailService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CocktailController {

    private final CocktailService cocktailService;

    @GetMapping("/cocktail")
    public String getCocktail(){
        return cocktailService.getCocktail();
    }
    @GetMapping("/random")
    public String randomDrink(){
        return cocktailService.getRandomCocktail();
    }
    @PostMapping("/recipe")
    public CocktailDto test(@Valid String drink){
        return cocktailService.getDrink(drink);
    }
}
