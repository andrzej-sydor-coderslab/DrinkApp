package pl.coderslab.DrinkApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.DrinkApp.dao.CocktailClient;
import pl.coderslab.DrinkApp.entity.dto.CocktailDto;
import pl.coderslab.DrinkApp.service.CocktailService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CocktailController {

    private final CocktailService cocktailService;
    private final CocktailClient cocktailClient;


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

    @GetMapping("/findRecipe")
    public String showRecipe() {
        return "cocktailDescription";
    }

    @PostMapping("/findRecipe")
    public String showThisRecipe(String drink, Model model){
        CocktailDto cocktailDto = cocktailClient.getDrinkByName(drink);
        model.addAttribute("cocktail", cocktailDto);
        return "cocktailDescription";
    }
}
