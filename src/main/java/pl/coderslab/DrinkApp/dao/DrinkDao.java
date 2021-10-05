package pl.coderslab.DrinkApp.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.DrinkApp.entity.Drink;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DrinkDao {

    @PersistenceContext
    EntityManager entityManager;

    public void createDrink(Drink drink) {
        entityManager.persist(drink);
    }

    public Drink readDrink(long id) {
        return entityManager.find(Drink.class, id);
    }

    public void update(Drink drink) {
        entityManager.merge(drink);
    }

    public void delete(Drink drink) {
        entityManager.remove(entityManager.contains(drink) ?
                drink : entityManager.merge(drink));
    }

    public List<Drink> findAll() {
        Query query = entityManager.createQuery("SELECT d from Drink d");
        return query.getResultList();
    }

    public Drink findById(long id) {
        return entityManager.find(Drink.class, id);
    }
}



