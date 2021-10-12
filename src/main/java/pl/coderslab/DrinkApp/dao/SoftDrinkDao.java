package pl.coderslab.DrinkApp.dao;


import org.springframework.stereotype.Repository;
import pl.coderslab.DrinkApp.entity.SoftDrink;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SoftDrinkDao {
    @PersistenceContext
    EntityManager entityManager;

    public void createSoftDrink(SoftDrink softDrink) {
        entityManager.persist(softDrink);
    }

    public SoftDrink readSoftDrink(long id) {
        return entityManager.find(SoftDrink.class, id);
    }

    public void update(SoftDrink softDrink) {
        entityManager.merge(softDrink);
    }

    public void delete(SoftDrink softDrink) {
        entityManager.remove(entityManager.contains(softDrink) ?
                softDrink : entityManager.merge(softDrink));
    }

    public List<SoftDrink> findAll() {
        Query query = entityManager.createQuery("SELECT s from SoftDrink s");
        return query.getResultList();
    }

    public SoftDrink findById(long id) {
        return entityManager.find(SoftDrink.class, id);
    }
}
