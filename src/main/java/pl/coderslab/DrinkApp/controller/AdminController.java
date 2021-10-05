package pl.coderslab.DrinkApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.DrinkApp.dao.AdminDao;
import pl.coderslab.DrinkApp.entity.Admin;

import javax.validation.Valid;

@Controller
public class AdminController {

    private final AdminDao adminDao;

    public AdminController(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @GetMapping("/register")
    public String initAddFom(Model model) {
        model.addAttribute("admin", new Admin());
        return "/registration";
    }

    @PostMapping("/register")
    public String persistDrink(@Valid Admin admin, BindingResult result) {
        if (result.hasErrors()) {
            return "/register";
        }
        adminDao.createAdmin(admin);
        return "redirect:/home";
    }

}
