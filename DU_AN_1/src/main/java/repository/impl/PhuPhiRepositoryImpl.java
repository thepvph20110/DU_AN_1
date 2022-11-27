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
    public boolean delete(String id) {
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String hql = "DELETE FROM PhuPhi WHERE id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            session.getTransaction().begin();
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public String genMaPhuPhi(){
        String top1 = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String hql = "FROM PhuPhi pp order by pp.maPhuPhi DESC";
            Query query = session.createQuery(hql);
            session.getTransaction().begin();
            query.setMaxResults(1);
            PhuPhi phuPhi = (PhuPhi) query.getSingleResult();
            top1 = phuPhi.getMaPhuPhi();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            return top1;
        }
        return top1;
    }
    
}
