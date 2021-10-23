package pl.coderslab.DrinkApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.DrinkApp.dao.DrinkDao;
import pl.coderslab.DrinkApp.entity.Drink;
import pl.coderslab.DrinkApp.service.DrinksManagementsService;

import java.util.Arrays;
import java.util.List;

@Controller
public class DrinkController {

    private final DrinkDao drinkDao;
    private final DrinksManagementsService drinksManagementsService;

    public DrinkController(DrinkDao drinkDao, DrinksManagementsService drinksManagementsService) {
        this.drinkDao = drinkDao;
        this.drinksManagementsService = drinksManagementsService;

    }

    @ModelAttribute("drinkCosts")
    public List<String> checkOptions(){
        String[]a = new String[]{"niski", "przeciętny", "duży"};
        return Arrays.asList(a);
    }
    @ModelAttribute("preparationTime")
    public List<String> checkTime(){
        String[]a = new String[]{"1-3 minuty", "5-7 minut", "powyżej 10 minut"};
        return Arrays.asList(a);
    }



    @GetMapping("/list")
    public String showAll(Model model) {
        try {
            model.addAttribute("allDrinks", drinksManagementsService.findAllForUser());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "list";
    }

    @GetMapping("/description")
    public String showDescription() {
        return "description";
    }

    @GetMapping("/monthDrink")
    public String drinkOfMonth() {
        return "drinkOfMonth";
    }

    @GetMapping("/recipe")
    public String showRecipe(Model model, int idToFind) {
        try {
            model.addAttribute("drink", drinksManagementsService.findDrinkForUserById(idToFind));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "drinkRecipe";
    }


    @GetMapping("/home")
    public String initAddFom() {
        return "/home";
    }

    @GetMapping("/add")
    public String initAddFom(Model model) {
        model.addAttribute("drink", new Drink());
        return "/addRecipe";
    }

    @PostMapping("/add")// walidacja przy pomocy validationgroup https://www.javacodegeeks.com/2014/08/validation-groups-in-spring-mvc.html
    public String persistDrink(Drink drink, BindingResult result) {
        if (result.hasErrors()) {
            return "/add";
        }
        try {
            drinksManagementsService.saveDrinkForCurrentUser(drink);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/dashboard";
    }

    @GetMapping("/edit")
    public String prepareEdit(@RequestParam int idToEdit, Model model) {
        model.addAttribute("drink", drinkDao.findById(idToEdit));
        return "addRecipe";
    }

    @PostMapping("/edit")
    public String merge(Drink drink) {
        drinkDao.update(drink);
        return "redirect:/list";
    }

    @GetMapping("/remove")
    public String prepareRemove(@RequestParam int toRemoveId, Model model) {
        model.addAttribute("drink", drinkDao.findById(toRemoveId));
        return "remove";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam String confirmed, @RequestParam int toRemoveId) {
        if ("yes".equals(confirmed)) {
            Drink drink = drinkDao.findById(toRemoveId);
            drinkDao.delete(drink);
        }
        return "redirect:/list";
    }
}
