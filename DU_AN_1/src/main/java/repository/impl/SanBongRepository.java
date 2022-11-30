/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.SanBong;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.ISanBongRepository;
import utill.HibernateConfig;

/**
 *
 * @author hp
 */
public class SanBongRepository implements ISanBongRepository {

    @Override
    public List<SanBong> getAll() {
        String hql = "From SanBong sb order by sb.tenSanBong";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            Query q = session.createQuery(hql);
            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean saveOrUpdate(SanBong sanBong) {
        boolean check;
        Transaction transaction = null;
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(sanBong);
            check = true;
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            check = false;
            transaction.rollback();
        }
        return check;
    }
    
    @Override
    public boolean deleteSanBong(SanBong sanBong) {
        boolean check;
        Transaction transaction = null;
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(sanBong);
            check = true;
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            check = false;
            transaction.rollback();
        }
        return check;
    }

    @Override
    public List<SanBong> searchByName(String ten) {
        List<SanBong> list = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String hql = "From SanBong Where tenSanBong like :ten ";
            TypedQuery<SanBong> query = session.createQuery(hql, SanBong.class);
            query.setParameter("ten", "%" + ten + "%");
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

}
