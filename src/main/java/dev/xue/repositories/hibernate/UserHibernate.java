package dev.xue.repositories.hibernate;

import dev.xue.models.User;
import dev.xue.repositories.UserRepo;
import dev.xue.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserHibernate implements UserRepo {

    @Override
    public User add(User user) {
        return null;
    }

    @Override
    public User getById(Integer id) {

        Session s = HibernateUtil.getSession();
        User u = s.get(User.class, id);
        s.close();
        return u;

//        String sql = "select * from users where id = :id";
//// We can still use native sql - but you shouldn't unless doing large updates or complicated queries.
//        NativeQuery<User> nq = s.createNativeQuery(sql);
//        nq.setParameter("id", id);
//        User u = nq.stream().findFirst().get();
//        return u;
    }

    @Override
    public User getByUsername(String username) {
        // Let's use the Criteria Interface
        Session s = HibernateUtil.getSession();
        User u = null;

        try {

            // Get Criteria Builder from Session
            CriteriaBuilder criteriaBuilder = s.getCriteriaBuilder();

            // Create CriteriaQuery
            CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);

            // Create Root object
            Root<User> root = criteriaQuery.from(User.class);

            // Use Predicates to narrow down our query
            Predicate predicate = criteriaBuilder.equal(root.get("username"), username);
            // you can create multiple predicates (i.e. username AND password)

            // Bringing our Criteria Builder and our Criteria Query together...
            // select * from users where username = ?
            criteriaQuery.select(root).where(predicate); // if using multiple predicates -> .where(cb.and(pred1, pred2)

            // Save that result into an object
            u = s.createQuery(criteriaQuery).getSingleResult();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            s.close();
        }

        return u;

    }

    @Override
    public List<User> getAll() {
        List<User> users;

        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(Integer id) {

    }
}
