package pl.coderslab.DrinkApp.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import pl.coderslab.DrinkApp.entity.Admin;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class AdminDao {


    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public void createAdmin(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
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

    public Optional<Admin> findById(long id) {
        return Optional.ofNullable(entityManager.find(Admin.class, id));
    }
    public Optional<Admin> findByEmail(String email) {

        Query query = entityManager.createQuery(String.format("Select a from Admin a where a.email='%s'", email));
        Admin admin = (Admin) query.getResultList().get(0);

        return Optional.ofNullable(admin);
    }
}

