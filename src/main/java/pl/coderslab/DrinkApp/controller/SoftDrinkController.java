package pl.coderslab.DrinkApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.DrinkApp.dao.SoftDrinkDao;
import pl.coderslab.DrinkApp.entity.SoftDrink;
import pl.coderslab.DrinkApp.service.DrinksManagementsService;

import java.util.Arrays;
import java.util.List;

@Controller
public class SoftDrinkController {

    private final SoftDrinkDao softDrinkDao;
    private final DrinksManagementsService drinksManagementsService;

    public SoftDrinkController(SoftDrinkDao softDrinkDao, DrinksManagementsService drinksManagementsService) {
        this.softDrinkDao = softDrinkDao;
        this.drinksManagementsService = drinksManagementsService;
    }

    @ModelAttribute("drinkCosts")
    public List<String> checkOptions() {
        String[] a = new String[]{"niski", "przeciętny", "duży"};
        return Arrays.asList(a);
    }

    @ModelAttribute("preparationTime")
    public List<String> checkTime() {
        String[] a = new String[]{"1-3 minuty", "5-7 minut", "powyżej 10 minut"};
        return Arrays.asList(a);
    }


    @GetMapping("/addSoft")
    public String initAddFom(Model model) {
        model.addAttribute("soft", new SoftDrink());
        return "/addSoftRecipe";
    }

    @PostMapping("/addSoft")
    public String persistDrink(SoftDrink softDrink, BindingResult result) {
        if (result.hasErrors()) {
            return "/addSoft";
        }
        try {
            drinksManagementsService.saveSoftForCurrentUser(softDrink);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/dashboard";
    }

    @GetMapping("/editSoft")
    public String prepareEdit(@RequestParam int idToEdit, Model model) {
        model.addAttribute("soft", softDrinkDao.findById(idToEdit));
        return "addSoftRecipe";
    }

    @PostMapping("/editSoft")
    public String merge(SoftDrink softDrink) {
        softDrinkDao.update(softDrink);
        return "redirect:/list";
    }

    @GetMapping("/removeSoft")
    public String prepareRemove(@RequestParam int toRemoveId, Model model) {
        model.addAttribute("soft", softDrinkDao.findById(toRemoveId));
        return "removeSoft";
    }

    @PostMapping("/removeSoft")
    public String remove(@RequestParam String confirmed, @RequestParam int toRemoveId) {
        if ("yes".equals(confirmed)) {
            SoftDrink softDrink = softDrinkDao.findById(toRemoveId);
            softDrinkDao.delete(softDrink);
        }
        return "redirect:/softList";
    }

    @GetMapping("/softList")
    public String showAll(Model model) {
        try {
            model.addAttribute("allSofts", drinksManagementsService.findAllSoftsForUser());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "softList";
    }

    @GetMapping("/softRecipe")
    public String showRecipe(Model model, int idToFind) {
        try {
            model.addAttribute("drink", drinksManagementsService.findSoftForUserById(idToFind));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "drinkRecipe";
    }
}
