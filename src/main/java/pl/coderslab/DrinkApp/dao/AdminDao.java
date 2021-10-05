package pl.coderslab.DrinkApp.dao;


import org.springframework.stereotype.Repository;
import pl.coderslab.DrinkApp.entity.Admin;
import org.mindrot.jbcrypt.BCrypt;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AdminDao {

    @PersistenceContext
    EntityManager entityManager;

    public void createAdmin(Admin admin) {
        entityManager.persist(admin);
    }

    public Admin readAdmin(long id) {
        return entityManager.find(Admin.class, id);
    }

    public void update(Admin admin) {
        entityManager.merge(admin);
    }

    public void delete(Admin admin) {
        entityManager.remove(entityManager.contains(admin) ?
                admin : entityManager.merge(admin));
    }

    public List<Admin> findAll() {
        Query query = entityManager.createQuery("SELECT a from Admin a");
        return query.getResultList();
    }

    public Admin findById(long id) {
        return entityManager.find(Admin.class, id);
    }

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}

