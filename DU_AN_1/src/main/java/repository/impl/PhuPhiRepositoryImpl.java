package repository.impl;

import domainmodel.PhuPhi;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.IPhuPhiRepository;
import utill.HibernateConfig;

public class PhuPhiRepositoryImpl implements IPhuPhiRepository {

    @Override
    public List<PhuPhi> getAllPhuPhi() {
        String hql = "FROM PhuPhi";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            Query query = session.createQuery(hql);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(PhuPhi phuPhi) {
        boolean check;
        Transaction transaction = null;
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(phuPhi);
            check = true;
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
            transaction.rollback();
        }
        return check;
    }

    @Override
    public boolean delete(PhuPhi phuPhi) {
        boolean check;
        Transaction transaction = null;
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(phuPhi);
            check = true;
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
            transaction.rollback();
        }
        return check;
    }

}
