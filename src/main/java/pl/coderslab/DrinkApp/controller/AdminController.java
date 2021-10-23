package pl.coderslab.DrinkApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
    public String registerForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "/registration";
    }

    @PostMapping("/register")
    public String registerFormPost(@Valid Admin admin, BindingResult result) {
        if (result.hasErrors()) {
            return "/registration";
        }
        adminDao.createAdmin(admin);
        return "redirect:/home";
    }
}
