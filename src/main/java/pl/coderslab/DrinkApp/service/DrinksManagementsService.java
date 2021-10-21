package pl.coderslab.DrinkApp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.coderslab.DrinkApp.dao.AdminDao;
import pl.coderslab.DrinkApp.dao.DrinkDao;
import pl.coderslab.DrinkApp.entity.Admin;
import pl.coderslab.DrinkApp.entity.Drink;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DrinksManagementsService {

    private final DrinkDao drinkDao;
    private final AdminDao adminDao;


    public void saveDrinkForCurrentUser(Drink drink) throws Exception {
        Admin user = findUser();
        drink.setAdmin(user);
        drinkDao.createDrink(drink);
    }

    public Object findAllForUser() throws Exception {
        Admin user = findUser();
        return drinkDao.findAllForGivenUser(user);
    }

    public Drink findDrinkForUserById(int idToFind) throws Exception {
        Admin user = findUser();
        Optional<Drink> optionalDrink = drinkDao.findByIdForCurrentUser(user, idToFind);
        if (optionalDrink.isPresent()){
            return optionalDrink.get();
        }
        throw new Exception("User not found");
    }

    private Admin findUser() throws Exception {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<Admin> admin = adminDao.findByEmail(email);
        if (admin.isPresent()){
            return admin.get();
        }
        throw new Exception("User not found");
    }
}
