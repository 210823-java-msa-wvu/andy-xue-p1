package dev.xue.repositories.hibernate;

import dev.xue.models.Reimbursement;
import dev.xue.repositories.ReimbursementRepo;
import dev.xue.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ReimbursementHibernate implements ReimbursementRepo {

    @Override
    public Reimbursement add(Reimbursement r) {
        // Let's use the Transaction Interface - gives us a little more granular control

        Session s = HibernateUtil.getSession();

        // I'm going to use a try catch finally to make sure that our transaction only commits to the database
        // so long as there are no exceptions thrown.

        Transaction tx = null;

        try {
            tx = s.beginTransaction();
            s.save(r);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null)
                tx.rollback();
        } finally {
            s.close();
        }
        return r;
    }

    @Override
    public Reimbursement getById(Integer id) {
        return null;
    }

    @Override
    public List<Reimbursement> getAll() {
        return null;
    }

    @Override
    public void update(Reimbursement t) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Reimbursement getByName(String name) {
        return null;
    }


}
