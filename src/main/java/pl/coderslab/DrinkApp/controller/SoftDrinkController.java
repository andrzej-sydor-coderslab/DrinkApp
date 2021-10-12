package pl.coderslab.DrinkApp.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.DrinkApp.dao.DrinkDao;
import pl.coderslab.DrinkApp.dao.SoftDrinkDao;
import pl.coderslab.DrinkApp.entity.Drink;
import pl.coderslab.DrinkApp.entity.SoftDrink;

import javax.validation.Valid;

public class SoftDrinkController {

    private final SoftDrinkDao softDrinkDao;

    public SoftDrinkController(SoftDrinkDao softDrinkDao) {
        this.softDrinkDao = softDrinkDao;
    }

    @GetMapping("/softList")
    public String showAll(Model model) {
        model.addAttribute("allSofts", softDrinkDao.findAll());
        return "softs";
    }

    @GetMapping("/description")
    public String showDescription() {
        return "description";
    }


    @GetMapping("/recipe")
    public String showRecipe(Model model, int idToFind) {
        model.addAttribute("soft", softDrinkDao.findById(idToFind));
        return "softRecipe";
    }

    @GetMapping("/home")
    public String initAddFom() {
        return "/home";
    }

    @GetMapping("/addSoft")
    public String initAddFom(Model model) {
        model.addAttribute("soft", new SoftDrink());
        return "/addRecipe";
    }

    @PostMapping("/add")
    public String persistDrink(@Valid SoftDrink softDrink, BindingResult result) {
        if (result.hasErrors()) {
            return "/add";
        }
        softDrinkDao.createSoftDrink(softDrink);
        return "redirect:/home";
    }

    @GetMapping("/edit")
    public String prepareEdit(@RequestParam int idToEdit, Model model) {
        model.addAttribute("soft", softDrinkDao.findById(idToEdit));
        return "addRecipe";
    }

    @PostMapping("/edit")
    public String merge(SoftDrink softDrink) {
        softDrinkDao.update(softDrink);
        return "redirect:/list";
    }

    @GetMapping("/remove")
    public String prepareRemove(@RequestParam int toRemoveId, Model model) {
        model.addAttribute("soft", softDrinkDao.findById(toRemoveId));
        return "remove";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam String confirmed, @RequestParam int toRemoveId) {
        if ("yes".equals(confirmed)) {
            SoftDrink softDrink = softDrinkDao.findById(toRemoveId);
            softDrinkDao.delete(softDrink);
        }
        return "redirect:/list";
    }
}
