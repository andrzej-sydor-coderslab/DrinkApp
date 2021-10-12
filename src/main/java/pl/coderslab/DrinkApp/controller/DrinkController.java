package pl.coderslab.DrinkApp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.DrinkApp.dao.DrinkDao;
import pl.coderslab.DrinkApp.entity.Drink;

import javax.validation.Valid;

@Controller
public class DrinkController {

    private final DrinkDao drinkDao;

    public DrinkController(DrinkDao drinkDao) {
        this.drinkDao = drinkDao;
    }

    @GetMapping("/list")
    public String showAll(Model model) {
        model.addAttribute("allDrinks", drinkDao.findAll());
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
        model.addAttribute("drink", drinkDao.findById(idToFind));
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

    @PostMapping("/add")
    public String persistDrink(@Valid Drink drink, BindingResult result) {
        if (result.hasErrors()) {
            return "/add";
        }
        drinkDao.createDrink(drink);
        return "redirect:/home";
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
