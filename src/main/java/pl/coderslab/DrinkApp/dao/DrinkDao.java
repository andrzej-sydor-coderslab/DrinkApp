package pl.coderslab.DrinkApp.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.DrinkApp.entity.Admin;
import pl.coderslab.DrinkApp.entity.Drink;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class DrinkDao {

    @PersistenceContext
    EntityManager entityManager;

    public void createDrink(Drink drink) {
        entityManager.persist(drink);
    }

    public void update(Drink drink) {
        entityManager.createQuery("update Drink d set d.name=: drinkName, d.description=: drinkDesc, d.ingredients=: drinkIngredients, d.preparationTime=: preparationTime, d.priceLevel=: priceLevel where d.id=: id")
                .setParameter("drinkName",drink.getName())
                .setParameter("drinkDesc", drink.getDescription())
                .setParameter("drinkIngredients", drink.getIngredients())
                .setParameter("preparationTime", drink.getPreparationTime())
                .setParameter("priceLevel", drink.getPriceLevel())
                .setParameter("id", drink.getId())
                .executeUpdate();
    }

    public void delete(Drink drink) {
        entityManager.remove(entityManager.contains(drink) ?
                drink : entityManager.merge(drink));
    }

    public Drink findById(long id) {
        return entityManager.find(Drink.class, id);
    }

    public List<Drink> findAllForGivenUser(Admin user) {
        Query query = entityManager.createQuery("SELECT d from Drink d where d.admin=: user").setParameter("user",user);
        return query.getResultList();
    }

    public Optional<Drink> findByIdForCurrentUser(Admin user, long idToFind) {
            Query query = entityManager.createQuery("SELECT d from Drink d where d.admin=: user and d.id = :id")
                    .setParameter("user",user)
                    .setParameter("id",idToFind);
        Drink drink = (Drink) query.getResultList().get(0);
        return Optional.ofNullable(drink);
    }
}



